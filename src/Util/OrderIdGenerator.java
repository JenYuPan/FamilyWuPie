package Util;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * @author Jerry
 * @create 2025/4/27下午 10:32
 * @desc：
 */
public class OrderIdGenerator {
    private static String currentPrefix = "AA";
    private static int currentNumber = 0;
    private static YearMonth lastMonth = YearMonth.now();

    public static synchronized String generateOrderId(){
        YearMonth thisMonth = YearMonth.now();

        if(!thisMonth.equals(lastMonth)){
            lastMonth=thisMonth;
            currentNumber=0;
            currentPrefix=nextPerfix(currentPrefix);
        }

        currentNumber++;
        String numberStr = String.format("%06d",currentNumber);
        return currentPrefix+numberStr;
    }

    private static String nextPerfix(String prefix){
        char first = prefix.charAt(0);
        char second = prefix.charAt(1);
        if(first=='Z'&&second=='Z'){
            first='A';
            second='A';
        }

        if(second=='Z'){
            first++;
            second='A';
        }else {
            second++;
        }
        return ""+first+second;
    }
}
