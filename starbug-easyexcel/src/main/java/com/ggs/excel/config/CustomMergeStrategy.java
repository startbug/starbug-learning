package com.ggs.excel.config;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.ggs.excel.annotation.CustomMerge;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lianghaohui
 * @Date 2022/1/14 16:02
 * @Description 自定义单元格合并策略
 */
public class CustomMergeStrategy implements RowWriteHandler {

    /**
     * 主键下标
     */
    private Integer pkIndex;

    /**
     * 需要合并的列的下标集合
     */
    private List<Integer> needMergeColumnIndex = new ArrayList<>();

    /**
     * DTO数据类型
     */
    private Class<?> elementType;

    public CustomMergeStrategy(Class<?> elementType) {
        this.elementType = elementType;
    }

    @Override
    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {
        //如果是标题，直接返回
        if (isHead) {
            return;
        }

        //获取当前
        Sheet sheet = writeSheetHolder.getSheet();

        if (null == pkIndex) {
            this.lazyInit(writeSheetHolder);
        }

        //判断是否需要和上一行进行合并
        //不能和标题合并，只能数据行之间合并
        if (row.getRowNum() <= 1) {
            return;
        }

        //获取上一行数据
        Row lastRow = sheet.getRow(row.getRowNum() - 1);

        //将本行和上一行是同一类型的数据(通过主键字段进行判断),则需要合并
        if (lastRow.getCell(pkIndex).getStringCellValue().equalsIgnoreCase(row.getCell(pkIndex).getStringCellValue())) {
            for (Integer mergeColumnIndex : needMergeColumnIndex) {
                CellRangeAddress cellAddresses = new CellRangeAddress(row.getRowNum() - 1, row.getRowNum(), mergeColumnIndex, mergeColumnIndex);
                sheet.addMergedRegionUnsafe(cellAddresses);
            }
        }

    }

    /**
     * 初始化主键下标和需要合并字段的下标
     */
    private void lazyInit(WriteSheetHolder writeSheetHolder) {

        //获取当前的sheet
        Sheet sheet = writeSheetHolder.getSheet();

        //获取标题行
        Row titleRow = sheet.getRow(0);
        //获取DTO的类型
        Class<?> elementType = this.elementType;

        //获取DTO的所有属性
        Field[] fields = elementType.getDeclaredFields();

        //遍历所有字段
        for (Field field : fields) {
            //获取@ExcelProperty注解，用户获取该字段对应在excel中的下标
            ExcelProperty excelProperty = field.getAnnotation(ExcelProperty.class);
            //如果字段没有标注@ExcelProperty，则不需要导入到excel中
            if (null == excelProperty) {
                continue;
            }

            //获取自定义的注解，用于合并单元格
            CustomMerge customMerge = field.getAnnotation(CustomMerge.class);

            //如果没有标注@CustomMerge，则不需要进行合并单元格
            if (null == customMerge) {
                continue;
            }

            for (int index = 0; index < fields.length; index++) {
                Cell cell = titleRow.getCell(index);
                if (null == cell) {
                    continue;
                }

                //将字段和excel表头匹配上
                if (excelProperty.value()[0].equalsIgnoreCase(cell.getStringCellValue())) {
                    if (customMerge.isPk()) {
                        this.pkIndex = index;
                    }

                    if (customMerge.needMerge()) {
                        needMergeColumnIndex.add(index);
                    }
                }
            }

        }

        //没有主键，则抛出异常
        if (null == this.pkIndex) {
            throw new IllegalStateException("使用@CustomMerge注解时必须指定主键");
        }

    }

}
