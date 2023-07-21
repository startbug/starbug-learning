package com.ggs.xml.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggs.xml.entity.JaxbCityList;
import com.ggs.xml.entity.R;
import com.ggs.xml.entity.XStreamCityList;
import com.ggs.xml.util.XSteamUtil;
import com.ggs.xml.util.XmlBuilder;

@RestController
@RequestMapping("/xml")
public class XmlController {

    @GetMapping("/jaxb/listcity")
    public R<JaxbCityList> jaxbListcity() throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("demo/XmlDemo.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();
        // XML转为Java对象
        JaxbCityList jaxbCityList = (JaxbCityList) XmlBuilder.xmlToBean(JaxbCityList.class, buffer.toString());
        return R.ok(jaxbCityList.getJaxbCityList());
    }

    @GetMapping("/xstream/listcity")
    public R<List<XStreamCityList>> xstreamListcity() throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("demo/XmlDemo.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();
        // XML转为Java对象
        XStreamCityList xStreamCityList = (XStreamCityList) XSteamUtil.xmlToBean(XStreamCityList.class, buffer.toString());
        return R.ok(xStreamCityList.getCityList());
    }

}
