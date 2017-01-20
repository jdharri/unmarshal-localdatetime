/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harriscg.help.unmarshal.localdatetime;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.xml.sax.InputSource;

/**
 *
 * @author jdharri
 */
public class Main {

    public static void main(String[] args) {
        try {
            JAXBContext jax = JAXBContext.newInstance(MyClass.class);
            MyClass mine = new MyClass();
            mine.setFirstName("TED");
            mine.setDateTime(LocalDateTime.now());

            Marshaller m = jax.createMarshaller();

            m.marshal(mine, System.out);

            Unmarshaller un = jax.createUnmarshaller();
            String marshalled = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><myClass><dateTime>2017-01-20T09:48:54.805</dateTime><firstName>TED</firstName></myClass>";
            InputSource in = new InputSource(new StringReader(marshalled));
            MyClass me = (MyClass) un.unmarshal(in);
            
            System.out.println("name from my class:"+me.getFirstName());
            System.out.println("localdatetime from unmarshaled class:"+me.getDateTime().toString());

        } catch (JAXBException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
