package cn.henry.patient.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 *
 * @author Henry
 * @date 2022-04-25 18:02
 **/
public class DateUtil {
    /**
     * 获取某段时间内的所有日期
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 日期列表
     */
    public static List<Date> genDates(Date startDate, Date endDate) {
        Calendar cStart = Calendar.getInstance();
        cStart.setTime(startDate);

        List<Date> dateList = new ArrayList<>();
        dateList.add(startDate);
        while (endDate.after(cStart.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cStart.add(Calendar.DAY_OF_MONTH, 1);
            dateList.add(cStart.getTime());
        }
        return dateList;
    }
}
