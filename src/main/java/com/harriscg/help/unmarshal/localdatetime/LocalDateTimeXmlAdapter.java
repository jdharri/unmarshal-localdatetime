/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harriscg.help.unmarshal.localdatetime;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author jdharri
 */
public class LocalDateTimeXmlAdapter  extends XmlAdapter<String, LocalDateTime>{

    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
     return LocalDateTime.parse(v);
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
       return v.toString();
    }
    
}
