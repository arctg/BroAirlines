package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dennis on 07.06.2015.
 */
public class CurrentDate {
    /**
     * Setting global Date
     * and returns new Date object
     * Date
     *
     * You also can "move" Date to future or to past
     * to show how price of flights changing
     * by uncomment below lines and comment this line: return new Date();
     *
     *
     */

    public static Date getCurrentDate(){
       return new Date();
//        try {
//            return new SimpleDateFormat("yy-MM-dd HH:mm").parse("2015-06-22 00:00");
//        }catch (ParseException e){
//            System.out.println(e);
//            return new Date();
//        }
    }
}
