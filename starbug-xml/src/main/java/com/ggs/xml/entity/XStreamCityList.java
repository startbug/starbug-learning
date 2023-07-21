package com.ggs.xml.entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("c")
public class XStreamCityList {
    @XStreamImplicit(itemFieldName = "d")
    private List<XStreamCity> cityList;
}
