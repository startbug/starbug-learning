package com.ggs;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.ggs.xml.entity.JaxbCityList;
import com.ggs.xml.entity.XStreamCityList;
import com.ggs.xml.util.XSteamUtil;
import com.ggs.xml.util.XmlBuilder;

public class DemoTest {

    public static void main(String[] args) throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("demo/XmlDemo.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();
        String xmlString = buffer.toString();
        // XML转为Java对象
        System.out.println(XmlBuilder.xmlToBean(JaxbCityList.class, xmlString));
        System.out.println("=================================");
        System.out.println(XSteamUtil.xmlToBean(XStreamCityList.class, xmlString));
    }

}
