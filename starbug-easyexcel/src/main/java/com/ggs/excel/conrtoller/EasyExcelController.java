package com.ggs.excel.conrtoller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.ggs.excel.config.CustomMergeStrategy;
import com.ggs.excel.entity.*;
import com.ggs.excel.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lianghaohui
 * @Date 2022/1/14 15:24
 * @Description
 */
@RestController
@Api(tags = "EasyExcelController", description = "EasyExcel导入导出测试")
@RequestMapping("/easyExcel")
public class EasyExcelController {

    @SneakyThrows(IOException.class)
    @ApiOperation("导出会员列表Excel")
    @GetMapping("/exportMemberList")
    public void exportMemberList(HttpServletResponse response) {
        setExcelRespProp(response, "会员列表");
        List<Member> memberList = JsonUtils.fileToList("json/members.json", Member.class);
        EasyExcel.write(response.getOutputStream())
                .head(Member.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("会员列表")
                .doWrite(memberList);
    }

    @SneakyThrows
    @ApiOperation("从Excel导入会员列表")
    @PostMapping(value = "/importMemberList")
    public R importMemberList(@RequestPart("file") MultipartFile file) {
        List<Member> memberList = EasyExcel.read(file.getInputStream())
                .head(Member.class)
                .sheet()
                .doReadSync();
        return R.ok().data(memberList);
    }

    @SneakyThrows
    @ApiOperation(value = "导出订单列表Excel")
    @GetMapping("/exportOrderList")
    public void exportOrderList(HttpServletResponse response) {
        setExcelRespProp(response, "会员列表");
        List<Member> memberList = JsonUtils.fileToList("json/members.json", Member.class);
        List<Order> orderList = JsonUtils.fileToList("json/orders.json", Order.class);
        List<Product> productList = JsonUtils.fileToList("json/products.json", Product.class);
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            order.setMember(memberList.get(i));
            order.setProductList(productList);
        }
        List<OrderData> orderDataList = convert(orderList);
        EasyExcel.write(response.getOutputStream())
                .head(OrderData.class)
                .registerWriteHandler(new CustomMergeStrategy(OrderData.class))
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("订单列表")
                .doWrite(orderDataList);
    }

    private List<OrderData> convert(List<Order> orderList) {
        List<OrderData> result = new ArrayList<>();
        for (Order order : orderList) {
            List<Product> productList = order.getProductList();
            for (Product product : productList) {
                OrderData orderData = new OrderData();
                BeanUtils.copyProperties(product, orderData);
                BeanUtils.copyProperties(order, orderData);
                result.add(orderData);
            }
        }
        return result;
    }

    /**
     * 设置excel下载响应头属性
     */
    private void setExcelRespProp(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(rawFileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
    }

}
