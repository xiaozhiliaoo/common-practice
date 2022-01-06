package org.lili.workdemo;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author lili
 * @date 2021/10/8 18:20
 */
@Slf4j
public class LogisticsCourse {

    /**
     * 课程ID
     */
    int courseId;

    /**
     * 合计总摊
     */
    String total;

    /**
     * 剩余待摊
     */
    String remaining;

    /**
     * 物料信息
     */
    List<LogisticsData> logisticsDatas;


    public static LogisticsCourse make(List<String> data, Integer courseId) {
        LogisticsCourse course = new LogisticsCourse();
        course.courseId = courseId;

        List<LogisticsData> logisticsDatas = Lists.newArrayList();


        int total = 0;
        int remain = 0;
        for (int i = 0; i < data.size(); i++) {
            String item = data.get(i);
            if (item.contains("合计:")) {
                total = i;
            }
            if (item.contains("剩余待摊:") && item.startsWith("剩余待摊:")) {
                remain = i;
            }
        }

        course.remaining = getRemaining(data.get(remain));
        course.total = getTotal(data.get(total));

        List<String> logicData = data.subList(0, total);

        for (int i = 0; i < logicData.size(); i = i + 2) {
            String logicInfo = logicData.get(i);
            //String splitInfo = logicData.get(i + 1);

            String logisticsId = betweenString(logicInfo, "物流单", "物料");
            String goodId = betweenString(logicInfo, "物料", "成本");
            String cost = betweenString(logicInfo, "成本", "退货");
            //String splitCost = betweenString(splitInfo, "成本", "退货否发货课程");


            LogisticsData l = LogisticsData.builder().logisticsId(Integer.parseInt(logisticsId))
                    .goodsId(Integer.parseInt(goodId)).costs(cost).build();
            logisticsDatas.add(l);
        }
        course.logisticsDatas = logisticsDatas;

        return course;
    }

    @Override
    public String toString() {
        return "LogisticsCourse{" +
                "courseId=" + courseId +
                ", total='" + total + '\'' +
                ", remaining='" + remaining + '\'' +
                ", logisticsDatas=" + logisticsDatas +
                '}';
    }

    private static String betweenString(String source, String from, String to) {
        return source.substring(source.lastIndexOf(from) + from.length(), source.indexOf(to));
    }

    private static String getTotal(String source) {
        return source.substring(source.lastIndexOf(":") + 1);
    }

    @Test
    public void betweenString() {
        System.out.println(betweenString("物流单210805-134221U1物料12642成本3.368161退货否发货课程90372,90350", "物流单", "物料"));
        System.out.println(betweenString("物流单13298226物料12819成本16.61退货否发货课程88914,88517,88632,88430", "物流单", "物料"));
        System.out.println(betweenString("物流单13298226物料12819成本16.61退货否发货课程88914,88517,88632,88430", "物料", "成本"));
        System.out.println(betweenString("物流单13298226物料12819成本16.61退货否发货课程88914,88517,88632,88430", "成本", "退货否发货课程"));
    }

    @Test
    public void getTotal() {
        System.out.println(getTotal("剩余待摊:16.1025-15.57455=0.52795"));
    }


    @Test
    public void coreCase() {
        String[] dataArr = new String[]{
                "物流单13298226物料12819成本16.61退货否发货课程88914,88517,88632,88430",
                "拆得:16.61*(1750/(1750+1750+1750+1750))=4.1525",
                "物流单13298224物料12723成本11.95退货否发货课程88430",
                "拆得:11.95*(1750/(1750))=11.95",
                "合计:16.1025",
                "往期数据 | 已确认",
                "202109 | 2.28779",
                "202110 | 2.72775",
                "202111 | 2.63975",
                "202112 | 2.72774",
                "202201 | 2.72775",
                "202202 | 2.46377",
                "总和 | 15.57455",
                "剩余待摊:16.1025-15.57455=0.52795",
                "末期结算,等于剩余待摊:0.52795"};

        List<String> data = Arrays.asList(dataArr);

        System.out.println(LogisticsCourse.make(data, 1111));
    }

    @Test
    public void coreCase2() {
        String[] dataArr = new String[]{
                "物流单9088067物料11955成本44退货是发货课程75073",
                "物流单201215-130634U1物料11955成本44.002508退货否发货课程75073",
                "拆得:44.002508*(4299/(4299))=44.002508",
                "合计:44.002508",
                "往期数据 | 已确认",
                "202011 | 0",
                "202012 | 3.76796",
                "202101 | 3.76796",
                "202102 | 3.40331",
                "202103 | 3.76824",
                "202104 | 3.64669",
                "202105 | 3.76824",
                "202106 | 4.34704",
                "202107 | 4.49194",
                "202108 | 4.49194",
                "202109 | 4.34704",
                "总和 | 39.80036",
                "剩余待摊:44.002508-39.80036=4.202148",
                "末期结算,等于剩余待摊:4.202148"
        };

        List<String> data = Arrays.asList(dataArr);

        System.out.println(LogisticsCourse.make(data, 1111));
    }

    private static String getRemaining(String source) {
        return source.substring(source.lastIndexOf("=") + 1);
    }


}
