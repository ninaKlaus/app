package com.app.redismodule.jedis;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.*;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JedisConnectionFactory {


    private static final JedisPool jedisPool;

    static {

        // 配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(0);
        poolConfig.setMaxWaitMillis(1000);

        //创建连接池对象
        jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }


    @Data
    public static class ClassA {
        private String name;
        private int age;

        // 省略getter和setter
    }

    @Data
    public static class ClassB {
        private String name;
        private int age;
        private String addr;

        // 省略getter和setter
    }

//    public static void main(String[] args) {
//
//        YourObject obj1 = new YourObject();
//        obj1.setTid("123");
//        obj1.setName("John");
//        obj1.setAge(30);
//
//        YourObject obj2 = new YourObject();
//        obj2.setTid("123");
//        obj2.setName("Doe");
//        obj2.setAge(25);
//
//        // 使用BeanUtil.compare来比较两个对象的属性差异
//        Map<String, Map<String, Object>> diff = BeanUtil.
//
//        // 输出不同的属性
//        for (Map.Entry<String, Map<String, Object>> entry : diff.entrySet()) {
//            System.out.println("Property: " + entry.getKey());
//            Map<String, Object> values = entry.getValue();
//            System.out.println("Object 1 value: " + values.get("left"));
//            System.out.println("Object 2 value: " + values.get("right"));
//        }
//    }

//        double similar = StrUtil.similar("内部公司借款利息测试", "利息");
//        System.out.println("similar = " + similar);
//
//        double ss = StrUtil.similar("内部公司借款利息测试", "内部公司借款利息");
//        System.out.println("similar = " + ss);
//        BigDecimal sss = new BigDecimal("4000000").multiply(new BigDecimal("0.0345"))
//                .multiply(new BigDecimal(DateUtil.between(DateUtil.parse("2023-05-01"), DateUtil.parse("2023-12-31"), DateUnit.DAY, true) + 1))
//                .divide(new BigDecimal("360"), 2, RoundingMode.HALF_UP);
//        System.out.println(sss);
//        System.out.println(sss.add(new BigDecimal("23479.17")));
////        25416.67
//
//        long s =  DateUtil.between(DateUtil.parse("2024-01-31"),DateUtil.parse("2024-03-31"), DateUnit.DAY, true)+1;
//        System.out.println("s = " + s);
//    }

    public static String replaceStr(String source, String findstr, String replacestr) {
        int index = source.indexOf(findstr);
        if (index == -1) {
            return source;
        }
        return replacestr + source.substring(index);
    }


    private static Map<String, Map<Date, Date>> getQuarterAndScope(Long startDate, Long endDate) {
        Map<String, Map<Date, Date>> quarterAndDate = new HashMap<>();
        final Calendar cal = DateUtil.calendar(startDate);
        while (startDate <= endDate) {
            Map<Date, Date> startAndEndDateMap = new HashMap<>();
            String quarter = DateUtil.yearAndQuarter(cal);
            Date tempStartDate = DateUtil.beginOfQuarter(new Date(startDate));
            Date endDateTime = DateUtil.endOfQuarter(new Date(startDate));

            cal.add(Calendar.MONTH, 3);

            startDate = cal.getTimeInMillis();
            Date tempEndDate = startDate <= endDate ? endDateTime : new Date(endDate);

            startAndEndDateMap.put(tempStartDate, tempEndDate);
            quarterAndDate.put(transferQuarter(quarter), startAndEndDateMap);
        }
        return quarterAndDate;
    }

    private static String transferQuarter(String quarter) {
        return quarter.substring(0, 4) + "-Q" + quarter.substring(4);
    }


    private static List<Date> getLastDayOfQuarterMonth(int year) {
        Date parse = DateUtil.parse((year - 1) + "-12-01");
        List<Date> list = new ArrayList<>();
        list.add(DateUtil.endOfQuarter(parse));
        int[] quarterMonths = {3, 6, 9, 12};
        for (int quarterMonth : quarterMonths) {
            Date toYearParse = DateUtil.parse(year + "-" + quarterMonth + "-01");
            list.add(DateUtil.endOfQuarter(toYearParse));
        }
        return list;
    }

    private static Date getAccrualEndTime(Date accrualEndTime, Date endDate) {
        DateTime endOfQuarter = DateUtil.endOfQuarter(accrualEndTime);
        Date fifteenDaysBefore = DateUtil.offsetDay(endOfQuarter, -15);
        Date fifteenDaysAfter = DateUtil.offsetDay(endOfQuarter, 15);
        if (accrualEndTime.after(fifteenDaysBefore) && accrualEndTime.before(fifteenDaysAfter)) {
            return DateUtil.endOfQuarter(accrualEndTime).after(endDate) ? endDate : DateUtil.endOfQuarter(accrualEndTime);
        } else {
            // 获取上一季度第一天
            Date preQuarterDate = DateUtil.offsetHour(DateUtil.beginOfQuarter(DateUtil.date()), -1);
            return DateUtil.endOfQuarter(preQuarterDate).after(endDate) ? endDate : DateUtil.endOfQuarter(preQuarterDate);
        }
    }

    private static Date getAccrualStartTime(Date accrualStartTime, Date startDate) {
        Date endOfQuarter = DateUtil.endOfQuarter(accrualStartTime);
        Date fifteenDaysBefore = DateUtil.offsetDay(endOfQuarter, -15);
        Date fifteenDaysAfter = DateUtil.offsetDay(endOfQuarter, 15);
        // 当前季度月底 15天范围内
        if (accrualStartTime.after(fifteenDaysBefore) && accrualStartTime.before(fifteenDaysAfter)) {
            return DateUtil.beginOfQuarter(accrualStartTime).before(startDate) ? startDate : DateUtil.beginOfQuarter(accrualStartTime);
        } else {
            // 获取上一季度第一天
            Date preQuarterDate = DateUtil.offsetHour(DateUtil.beginOfQuarter(DateUtil.date()), -1);
            return DateUtil.beginOfQuarter(preQuarterDate).before(startDate) ? startDate : DateUtil.beginOfQuarter(preQuarterDate);
        }
    }
}

