package person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimes {
    public static void main(String[] args) {
        System.out.println(new java.util.Date());

        String str="1997-09-09";
        //将字符串转为Date
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            //parse方法转换为util.Date
            java.util.Date date=sdf.parse(str);
            System.out.println(date);
            System.out.println("-----------");
            //format方法转换为String类型
            String dates=sdf.format(new java.util.Date());
            System.out.println(dates);

            //sql.Date不支持字符串转换   只支持毫秒创建
            //通过util.Date拿到指定日期的毫秒值，转换为sql.Date
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
