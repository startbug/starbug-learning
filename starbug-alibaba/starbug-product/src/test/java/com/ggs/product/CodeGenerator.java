package com.ggs.product;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

/**
 * @Author lianghaohui
 * @Date 2021/12/27 11:02
 * @Description
 */
public class CodeGenerator {

    public static void main(String[] args) throws IOException {
        File file = new File("./starbug-alibaba/starbug-product");
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/starbug_product?serverTimezone=GMT%2B8&characterEncoding=UTF-8", "root", "123456")
                .globalConfig(builder -> {
                    try {
                        builder.author("Starbug") // 设置作者
                                .enableSwagger() // 开启 swagger 模式
                                .fileOverride() // 覆盖已生成文件
                                .outputDir(file.getCanonicalPath() + "/src/main/java"); // 指定输出目录
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                .strategyConfig((scanner, builder) -> builder.build().controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().build())
                .packageConfig(builder -> {
                    try {
                        builder
                                .parent("com.ggs.product") // 设置父包名
                                // .moduleName("") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, file.getCanonicalPath() + "/src/main/resources/mapper")); // 设置mapperXml生成路径
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                .strategyConfig(builder -> {
                    builder.addInclude("product"); // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
