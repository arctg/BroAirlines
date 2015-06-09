package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dennis on 07.06.2015.
 */
public class CurrentDate {
    public static Date getCurrentDate(){
       return new Date();
//        try {
//            return new SimpleDateFormat("yy-MM-dd HH:mm").parse("2015-09-21 00:00");
//        }catch (ParseException e){
//            System.out.println(e);
//            return new Date();
//        }
    }
}
