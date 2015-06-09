package logic;

import manager.Message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * Created by dennis on 03.06.2015.
 */
public class DateChecker {
    public static void main(String args[]){
//        String date = "2015-05-14 00:00";
//        try {
//            Date date1 = new SimpleDateFormat("yy-MM-dd HH:mm").parse("2015-05-14 14:00");
//            Date date2 = new SimpleDateFormat("yy-MM-dd HH:mm").parse("2015-05-14 00:00");
//            System.out.println(TimeUnit.DAYS.convert((date1.getTime() - date2.getTime()),TimeUnit.MILLISECONDS));
//        }catch (ParseException e){
//            System.out.println(e);
//        }


        System.out.println(Message.getInstance(new Locale("ru_RU")).getProperty(Message.LOGIN_ERROR));

    }
}
