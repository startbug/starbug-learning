package com.ggs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggs.entity.OrderStatistics;
import com.ggs.mappers.OrderStatisticsMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisXmlHotSwapApplication {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        OrderStatisticsMapper mapper = session.getMapper(OrderStatisticsMapper.class);
        OrderStatistics orderStatistics = mapper.selectOne(15);
        ObjectMapper om = new ObjectMapper();
        System.out.println(om.writeValueAsString(orderStatistics));
    }

}
