package com.example.xmlAssignment;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLEncoderClass {
    public static void main(String[] args) throws IOException {
        User newUser = new User();
        newUser.setStdID(100052);
        newUser.setFullname("Kelsey Makale");
        newUser.setAge(21);
        newUser.setProgrammingLanguage("Java");

        System.out.println(newUser);
        serializeToXML(newUser);

        User LoadSettings = deserializeFromXML();
        System.out.println(LoadSettings);
    }
    private static void serializeToXML(User settings) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("UserProfile.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(e -> System.out.println("Exception! :"+e.toString()));
        encoder.writeObject(settings);
        encoder.close();
        fos.close();
    }
    private static User deserializeFromXML() throws IOException {
        FileInputStream fis = new FileInputStream("UserProfile.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        User decodedSettings = (User) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedSettings;
    }
}
