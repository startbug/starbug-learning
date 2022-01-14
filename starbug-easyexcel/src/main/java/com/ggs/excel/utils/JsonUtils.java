package com.ggs.excel.utils;

import com.ggs.excel.entity.Order;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author lianghaohui
 * @Date 2022/1/14 10:23
 * @Description
 */
public class JsonUtils {

    /**
     * 直接使用List<T> list = gson.fromJson(isr, new Type<List<T>>(){}.getType());得到的结果，list中每个元素都是一个map，并不是我希望的填充了属性值的实体类
     * new Type<List<T>>(){}.getType()最终的得到的是一个Type，
     * 会调用$Gson$Types的内部类ParameterizedTypeImpl的两个方法
     * getActualTypeArguments() 获取结果的类型
     * getRawType() 获取结果中的泛型
     * ----------------------------------------------------------------------
     * 可以自己编写一个ParameterizedTypeImpl(实现ParameterizedType接口)
     * 通过构造方法传入①结果的类型和②结果中的泛型，
     * 实现ParameterizedType#getActualTypeArgument()和ParameterizedType#getRawType()方法即可
     */
    @SneakyThrows
    public static <T> List<T> fileToList(String classpath, Class<T> clazz) {
        Type type = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        InputStreamReader isr = new InputStreamReader(FileUtils.openInputStream(ResourceUtils.getFile("classpath:" + classpath)));
        List<T> list = gson.fromJson(isr, type);
        return list;
    }

    public static void main(String[] args) {
        List<Order> orderList = fileToList("json/orders.json", Order.class);
        orderList.forEach(System.out::println);
    }

}

//这里以参数类型为Map<String, User>为例子进行说明
class ParameterizedTypeImpl implements ParameterizedType {

    //结果的类型 Map
    private final Class raw;
    //结果类型中的泛型 String和User
    private final Type[] args;

    public ParameterizedTypeImpl(Class raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }

    // 返回Map<String,User>里的String和User，所以这里返回[String.class,User.class]
    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }

    // Map<String,User>里的Map,所以返回值是Map.class
    @Override
    public Type getRawType() {
        return raw;
    }

    // 用于这个泛型上中包含了内部类的情况,一般返回null
    @Override
    public Type getOwnerType() {
        return null;
    }

}
