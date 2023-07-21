package com.ggs.xml.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class XSteamUtil {

    public static Object xmlToBean(Class<?> clazz, String xml) {
        Object xmlObject = null;
        XStream xstream = new XStream();
        xstream.processAnnotations(clazz);
        xstream.autodetectAnnotations(true);
        xstream.addPermission(AnyTypePermission.ANY);
        xmlObject = xstream.fromXML(xml);
        return xmlObject;
    }

}
