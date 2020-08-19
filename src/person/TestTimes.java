package person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimes {
    public static void main(String[] args) {
        System.out.println(new java.util.Date());

        String str="1997-09-09";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date data=sdf.parse(str);    //将字符串转为Date
            System.out.println(data);
            System.out.println("-----------");
            String dates=sdf.format(new java.util.Date());
            System.out.println(dates);


        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
