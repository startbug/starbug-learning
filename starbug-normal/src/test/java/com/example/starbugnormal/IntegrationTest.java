package com.example.starbugnormal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.assertj.core.util.Lists;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author lianghaohui
 * @Date 2022/2/12 10:17
 * @Description
 */
public class IntegrationTest {

    @Test
    public void test1() {
        GoodArgs goodArgs1 = new GoodArgs(10.5, 15.5, 100);
        GoodArgs goodArgs2 = new GoodArgs(20.5, 20.5, 110);
        GoodArgs goodArgs3 = new GoodArgs(30.5, 25.5, 120);
        GoodArgs goodArgs4 = new GoodArgs(40.5, 30.5, 130);
        Favorites favorites1 = new Favorites("西瓜", 10.0, goodArgs1);
        Favorites favorites2 = new Favorites("雪梨", 20.0, goodArgs2);
        Favorites favorites3 = new Favorites("苹果", 30.5, goodArgs3);
        Favorites favorites4 = new Favorites("柠檬", 40.5, goodArgs4);
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime dateTime1 = DateTime.parse("1999-6-14", dtf);
        DateTime dateTime2 = DateTime.parse("1998-6-14", dtf);
        ArrayList<Favorites> list1 = Lists.newArrayList(favorites1, favorites2);
        ArrayList<Favorites> list2 = Lists.newArrayList(favorites3, favorites4);
        Student student1 = new Student(1001, "万娜", true, dateTime1.toDate(), list1);
        Student student2 = new Student(1002, "谭芳", false, dateTime2.toDate(), list2);

        System.out.println(student2 instanceof Student);
        Field[] declaredFields = Student.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getType());
        }


    }

    @Test
    public void test2() {
        GoodArgs goodArgs1 = new GoodArgs(10.5, 15.5, 100);
        GoodArgs goodArgs2 = new GoodArgs(20.1, 20.5, 110);
        Favorites favorites1 = new Favorites("西瓜", 10.0, goodArgs1);
        Favorites favorites2 = new Favorites("雪梨", 20.0, goodArgs2);
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime dateTime1 = DateTime.parse("1999-6-14", dtf);
        ArrayList<Favorites> list1 = Lists.newArrayList(favorites1, favorites2);
        Student student1 = new Student(1001, "万娜", true, dateTime1.toDate(), list1);
        Student student2 = new Student(1001, "万娜", true, dateTime1.toDate(), list1);
        System.out.println(student1.equals(student2));
    }

}


@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
class Student {

    private int id;
    private String name;
    private boolean rich;
    private Date birth;
    private List<Favorites> favoritesList;


}

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
class Favorites {
    private String fruit;
    private Double money;
    private GoodArgs goodArgs;
}

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
class GoodArgs {
    private Double weight;
    private Double high;
    private int inventory;


}
