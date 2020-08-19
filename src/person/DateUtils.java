package person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    //1.字符串转换为util.Date
    public java.util.Date utilToStr(String str){
        try {
            java.util.Date date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //2.将util.Date转化为sql.Date
    public java.sql.Date utilToSql(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }

    //3.util.Date转化为字符串
    public String utilToStr(java.util.Date date){
        return sdf.format(date);
    }


}
