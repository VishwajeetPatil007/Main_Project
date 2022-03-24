package utilityClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class weekDatesUtil {
	

	
	public static String getActiveDate() {
		Date date = new Date();
		SimpleDateFormat datef = new SimpleDateFormat("EE, dd MMM");
		String date1 = datef.format(date);
		return date1;
	}

    public static String[] getDaysOfWeek() {
    	Date refDate = new Date();
    	int firstDayOfWeek=Calendar.getInstance().getFirstDayOfWeek();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(refDate);
        calendar.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);
        Date[] daysOfWeek = new Date[7];
        for (int i = 0; i < 7; i++) {
            daysOfWeek[i] = calendar.getTime();
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        String[] newDate =new String[7];
       int i=0;
        for (Date day : daysOfWeek) {
        	SimpleDateFormat datef = new SimpleDateFormat("EE, dd MMM");
    		String date1 = datef.format(day);
    		newDate[i]=date1;
    		//System.out.println(date1);
    		i++;
        	}
        return newDate;
    }

}
