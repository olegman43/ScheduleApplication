package Utils;

import java.util.Calendar;

/**
 * Created by Mr.Nobody43 on 25.10.2017.
 */

public class Constants {

   static Calendar calendar = Calendar.getInstance();

   public static final String URL = "http://asu.tti.sfedu.ru/Raspisanie/ShowRaspisanie.aspx?Substance=";
   public static final String START_TIME = "start-time";
   public static final String END_TIME = "end-time";
   public static final String SEPARATOR = " ";
   public static final String BOTH = "row_rowspan";
   public static final String TOP_WEEK = "row top-week";
   public static final String BOTTOM_WEEK = "row bottom-week";
   public static final String CLASS = "class";
   public static final String DAY = "th_row_day";
   public static final String RESERVED = "reserved";
   public static final String POTOK = "&isPotok=";
   public static final String SEMESTR = "&Semestr=";

   public static final int DAYS_ON_WEEK = 7;
   public static final int DATE_INDEX = 1;
   public static final int BEGIN_TIME = 1;
   public static final int DEFAULT_VALUE_CNT_PARSER = 0;
   public static final int FIRST_YEAR = 2017;
   public static final int FIRST_POTOK = 121;
   public static final int START_NEXT_SEMESTR = 7;

   public static String getCurPot(String year)
   {
      int curYear = calendar.get(Calendar.YEAR);
      int curMonth = calendar.get(Calendar.MONTH);

      int pot = FIRST_POTOK + (curYear - FIRST_YEAR);

      if(curYear != FIRST_YEAR)
      {
         if(curMonth < START_NEXT_SEMESTR) --pot;
      }

      return  Integer.toString(pot - Integer.parseInt(year));
   }
}