package com.ggs.springboot3;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoDemo4 {

    @Test
    public void josdajflkasdjflksajd() {
        
    }

    @Test
    public void isSameWeekTest() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        DateTimeFormatter EEEE = DateTimeFormatter.ofPattern("EEEE");
        DateTimeFormatter EEEEE = DateTimeFormatter.ofPattern("EEEEE");
        LocalDate nowLocalDate = LocalDate.now();
        String format = nowLocalDate.format(dtf);
        System.out.println(format);

        System.out.println("111111-----------------------------------");
        System.out.println(nowLocalDate.format(EEEE));
        System.out.println("222222-----------------------------------");
        System.out.println(nowLocalDate.format(EEEEE));
        System.out.println("---------------------------------");
        LocalDate mondayNowLocalDate = nowLocalDate.with(DayOfWeek.MONDAY);
        System.out.println(mondayNowLocalDate.format(dtf));
        LocalDate sundayNowLocalDate = nowLocalDate.with(DayOfWeek.SUNDAY);
        System.out.println(sundayNowLocalDate.format(dtf));

        System.out.println("---------------------------------------------------");
        LocalDate compareLocalDate = LocalDate.now().plusWeeks(1);
        System.out.println(compareLocalDate.format(dtf));
        boolean isBefore = compareLocalDate.isBefore(sundayNowLocalDate);
        boolean isAfter = compareLocalDate.isAfter(mondayNowLocalDate);
        System.out.println(isBefore);
        System.out.println(isAfter);
        System.out.println("------------------new week-------------------");

        if (!(isBefore && isAfter)) {
            System.out.println(compareLocalDate.with(DayOfWeek.MONDAY));
            System.out.println(compareLocalDate.with(DayOfWeek.SUNDAY));
        }

    }

    @Test
    public void testestestes() {
        String SEPARATOR = ":";
        LocalDate nowLocalDate = LocalDate.now();
        DateTimeFormatter monthPattern = DateTimeFormatter.ofPattern("yyyy.MM");
        DateTimeFormatter dayPattern = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        // 日
        String dayStatisticalDate = nowLocalDate.format(dayPattern);                            // 2022.09.21
        // 周
        String mondayNowLocalDateStr = nowLocalDate.with(DayOfWeek.MONDAY).format(dayPattern);  // 2022.09.19-2022.09.25
        String sundayNowLocalDateStr = nowLocalDate.with(DayOfWeek.SUNDAY).format(dayPattern);
        String weekStatisticalDate = mondayNowLocalDateStr + "-" + sundayNowLocalDateStr;
        // 月
        String monthStatisticalDate = YearMonth.now().format(monthPattern);                     // 2022.09

        String ORDER_STATISTICAL = "order_statistics";
        String city = "北京";
        String companyId = String.valueOf(10000);
        String positionId = String.valueOf(2000);
        String merchantStoreId = String.valueOf(300);
        String intervalNo = String.valueOf(1);
        String operatorId = String.valueOf(999);

        System.out.println("--------------------------------------------------------------------------------------------------------------");
//      order_statistics:companyId:statisticsDate: 公司维度
        String companyDayKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(dayStatisticalDate).toString();
        String companyWeekKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(weekStatisticalDate).toString();
        String companyMonthKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(monthStatisticalDate).toString();
        System.out.println(companyDayKey);
        System.out.println(companyWeekKey);
        System.out.println(companyMonthKey);
        System.out.println("--------------------------------------------------------------------------------------------------------------");

//      order_statistics:companyId:city:statisticsDate: 公司、城市维度
        String companyCityDayKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(dayStatisticalDate).toString();
        String companyCityWeekKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(weekStatisticalDate).toString();
        String companyCityMonthKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(monthStatisticalDate).toString();
        System.out.println(companyCityDayKey);
        System.out.println(companyCityWeekKey);
        System.out.println(companyCityMonthKey);
        System.out.println("--------------------------------------------------------------------------------------------------------------");

//      order_statistics:companyId:city:positionId:statisticsDate: 公司、城市、点位维度
        String companyCityPositionDayKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(positionId).add(dayStatisticalDate).toString();
        String companyCityPositionWeekKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(positionId).add(weekStatisticalDate).toString();
        String companyCityPositionMonthKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(positionId).add(monthStatisticalDate).toString();
        System.out.println(companyCityPositionDayKey);
        System.out.println(companyCityPositionWeekKey);
        System.out.println(companyCityPositionMonthKey);
        System.out.println("--------------------------------------------------------------------------------------------------------------");

//      order_statistics:companyId:city:positionId:intervalNo:statisticsDate: 公司、城市、点位、餐段维度
        String companyCityPositionIntervalDayKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(positionId).add(intervalNo).add(dayStatisticalDate).toString();
        String companyCityPositionIntervalWeekKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(positionId).add(intervalNo).add(weekStatisticalDate).toString();
        String companyCityPositionIntervalMonthKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(positionId).add(intervalNo).add(monthStatisticalDate).toString();
        System.out.println(companyCityPositionIntervalDayKey);
        System.out.println(companyCityPositionIntervalWeekKey);
        System.out.println(companyCityPositionIntervalMonthKey);
        System.out.println("--------------------------------------------------------------------------------------------------------------");

//      order_statistics:companyId:city:positionId:merchantStoreId:intervalNo:statisticsDate: 公司、城市、点位、商家、餐段维度
        String companyCityPositionMerchantStoreIntervalDayKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(positionId).add(merchantStoreId).add(intervalNo).add(dayStatisticalDate).toString();
        String companyCityPositionMerchantStoreIntervalWeekKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(positionId).add(merchantStoreId).add(intervalNo).add(weekStatisticalDate).toString();
        String companyCityPositionMerchantStoreIntervalMonthKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(companyId).add(city).add(positionId).add(merchantStoreId).add(intervalNo).add(monthStatisticalDate).toString();
        System.out.println(companyCityPositionMerchantStoreIntervalDayKey);
        System.out.println(companyCityPositionMerchantStoreIntervalWeekKey);
        System.out.println(companyCityPositionMerchantStoreIntervalMonthKey);
        System.out.println("--------------------------------------------------------------------------------------------------------------");

        if (StringUtils.isNotBlank(operatorId) && StringUtils.isNumeric(operatorId) && Long.valueOf(operatorId) > 0) {
//          order_statistics:operatorId:positionId:statisticsDate: 运营商、点位维度
            String operatorPositionDayKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(dayStatisticalDate).toString();
            String operatorPositionWeekKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(weekStatisticalDate).toString();
            String operatorPositionMonthKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(monthStatisticalDate).toString();
            System.out.println(operatorPositionDayKey);
            System.out.println(operatorPositionWeekKey);
            System.out.println(operatorPositionMonthKey);
            System.out.println("--------------------------------------------------------------------------------------------------------------");

//          order_statistics:operatorId:positionId:intervalNo:statisticsDate: 运营商、点位、餐段维度
            String operatorPositionIntervalDayKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(intervalNo).add(dayStatisticalDate).toString();
            String operatorPositionIntervalWeekKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(intervalNo).add(weekStatisticalDate).toString();
            String operatorPositionIntervalMonthKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(intervalNo).add(monthStatisticalDate).toString();
            System.out.println(operatorPositionIntervalDayKey);
            System.out.println(operatorPositionIntervalWeekKey);
            System.out.println(operatorPositionIntervalMonthKey);
            System.out.println("--------------------------------------------------------------------------------------------------------------");

//          order_statistics:operatorId:positionId:merchantStoreId:statisticsDate: 运营商、点位、商家维度
            String operatorPositionMerchantStoreDayKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(merchantStoreId).add(dayStatisticalDate).toString();
            String operatorPositionMerchantStoreWeekKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(merchantStoreId).add(weekStatisticalDate).toString();
            String operatorPositionMerchantStoreMonthKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(merchantStoreId).add(monthStatisticalDate).toString();
            System.out.println(operatorPositionMerchantStoreDayKey);
            System.out.println(operatorPositionMerchantStoreWeekKey);
            System.out.println(operatorPositionMerchantStoreMonthKey);
            System.out.println("--------------------------------------------------------------------------------------------------------------");

//          order_statistics:operatorId:positionId:merchantStoreId:intervalNo:statisticsDate: 运营商、点位、商家、餐段维度
            String operatorPositionMerchantStoreIntervalDayKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(merchantStoreId).add(intervalNo).add(dayStatisticalDate).toString();
            String operatorPositionMerchantStoreIntervalWeekKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(merchantStoreId).add(intervalNo).add(weekStatisticalDate).toString();
            String operatorPositionMerchantStoreIntervalMonthKey = new StringJoiner(":").add(ORDER_STATISTICAL).add(operatorId).add(positionId).add(merchantStoreId).add(intervalNo).add(monthStatisticalDate).toString();
            System.out.println(operatorPositionMerchantStoreIntervalDayKey);
            System.out.println(operatorPositionMerchantStoreIntervalWeekKey);
            System.out.println(operatorPositionMerchantStoreIntervalMonthKey);
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
    }


    @Test
    public void isSameMonthTest() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        YearMonth nowYearMonth = YearMonth.now();
        LocalDate localDate = nowYearMonth.atEndOfMonth();
        System.out.println(localDate.format(dtf));
        System.out.println(nowYearMonth.atDay(1).format(dtf));

        System.out.println("比较-----------------------------------------------------------");
        YearMonth yearNextMonth = YearMonth.now().plusMonths(1);
        if (nowYearMonth.equals(yearNextMonth)) {
            System.out.println("同一个月" + yearNextMonth.format(DateTimeFormatter.ofPattern("yyyy.MM")));
        } else {
            System.out.println("不是同一个月" + yearNextMonth.format(DateTimeFormatter.ofPattern("yyyy.MM")));
        }

    }


    @Test
    public void lksadjflkasjdd() {
        DateTimeFormatter fmt = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.YEAR)
                .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 10)
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .toFormatter()
                .withZone(ZoneOffset.UTC);

        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2008", fmt);
        System.out.println(zonedDateTime);
    }

    @Test
    public void sdfjkalskdj() {
        LocalDate now = LocalDate.now();
        TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        System.out.println(now.with(fieldISO, 1)); // 2015-02-09 (Monday)

        TemporalField fieldUS = WeekFields.of(Locale.US).dayOfWeek();
        System.out.println(now.with(fieldUS, 1)); // 2015-02-08 (Sunday)
    }

    @Test
    public void testsetetse() {
        Long xxx = null;
        System.out.println(xxx);
        long number = xxx;
        System.out.println(number);
    }


    @Test
    public void rateLimiterTest() throws InterruptedException {

        RateLimiter rateLimiter = RateLimiter.create(1, 1, TimeUnit.SECONDS);

        Thread thread = new Thread(() -> {
            System.out.println("线程1获取执行权限？" + rateLimiter.tryAcquire());
        });
        thread.start();

        TimeUnit.SECONDS.sleep(2);
        Thread thread1 = new Thread(() -> {
            System.out.println("线程2获取执行权限？" + rateLimiter.tryAcquire());
        });
        thread1.start();

        thread1.join();
        thread.join();
    }

    @Test
    public void teststest() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();
        cache.put("测试", "xxx");
        TimeUnit.SECONDS.sleep(3);
        System.out.println(cache.getIfPresent("测试"));
    }

    @Test
    public void test() {
        List mockList = mock(List.class);

        Assertions.assertEquals(0, mockList.size());
        Assertions.assertEquals(null, mockList.get(0));

        mockList.add("a");  // 调用 mock 对象的写方法，是没有效果的

        Assertions.assertEquals(0, mockList.size());      // 没有指定 size() 方法返回值，这里结果是默认值
        Assertions.assertEquals(null, mockList.get(0));   // 没有指定 get(0) 返回值，这里结果是默认值

        when(mockList.get(0)).thenReturn("a");          // 指定 get(0)时返回 a

        Assertions.assertEquals(0, mockList.size());        // 没有指定 size() 方法返回值，这里结果是默认值
        Assertions.assertEquals("a", mockList.get(0));      // 因为上面指定了 get(0) 返回 a，所以这里会返回 a

        Assertions.assertEquals(null, mockList.get(1));     // 没有指定 get(1) 返回值，这里结果是默认值
    }


    @Mock
    private List<String> mockStringList1;

    @BeforeEach
    public void before1() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test2() {
        mockStringList1.add("a");

//        when(mockStringList1.get(eq(0))).thenReturn("a");
//        when(mockStringList1.get(1)).thenReturn("b");
        when(mockStringList1.get(anyInt())).thenReturn("a");

        Assertions.assertEquals("a", mockStringList1.get(0));
        Assertions.assertEquals("b", mockStringList1.get(1));
    }

}
