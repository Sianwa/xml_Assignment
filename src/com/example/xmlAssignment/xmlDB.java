package com.example.xmlAssignment;

        import org.w3c.dom.Document;
        import org.w3c.dom.Element;

        import javax.xml.parsers.DocumentBuilder;
        import javax.xml.parsers.DocumentBuilderFactory;
        import javax.xml.transform.OutputKeys;
        import javax.xml.transform.Transformer;
        import javax.xml.transform.TransformerFactory;
        import javax.xml.transform.dom.DOMSource;
        import javax.xml.transform.stream.StreamResult;
        import java.io.StringWriter;
        import java.sql.*;

public class xmlDB {
    static final String url = "jdbc:mysql://localhost/distributed_objs";
    static final String user = "root";
    static final String pass = "";

    public static void main(String[] args) throws Exception {
        // a factory API that enables applications to obtain a parser that produces DOM
        // objects trees from XML and vice verse.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        //creating a DOM structure for our results
        Element results = doc.createElement("Students");//root element
        doc.appendChild(results);
        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Connected");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error due to :" + e);
        }

        ResultSet rs = conn.createStatement().executeQuery("select * from student");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        while (rs.next()) {
            Element row = doc.createElement("Student");
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                if (columnName.equals("StdID")) {
                    results.appendChild(row);
                    Object value = rs.getObject(i);
                    row.setAttribute("id", value.toString());
                }
                else {
                    Object value = rs.getObject(i);
                    Element node = doc.createElement(columnName);
                    node.appendChild(doc.createTextNode(value.toString()));
                    row.appendChild(node);
                }
            }
        }

        DOMSource domSource = new DOMSource(doc);
        Transformer  transformer  = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        transformer.transform(domSource, sr);

        //Print results in XML format
        System.out.println(sw.toString());

        //close DB Connection
        conn.close();
        rs.close();


    }

}
