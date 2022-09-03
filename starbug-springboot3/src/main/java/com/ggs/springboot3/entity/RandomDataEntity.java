package com.ggs.springboot3.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serial;
import java.io.Serializable;

@Data
@ConfigurationProperties(prefix = "my")
public class RandomDataEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4630613340496320137L;

    private String secret;
    private int number;
    private long bignumber;
    private String uuid;
    private int numberLessThanTen;
    private int numberInRange;

}
