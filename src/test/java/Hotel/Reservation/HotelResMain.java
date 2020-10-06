package Hotel.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HotelResMain {
	
	public static Hotel obj1=new Hotel("Lakewood",3,110,90,80,80);
	public static Hotel obj2=new Hotel("Bridgewood",4,160,60,110,50);
	public static Hotel obj3=new Hotel("Ridgewood",5,220,150,100,40);
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public static DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM,yyyy");
	public static void main(String args[])
	{
		System.out.println("Welcome to Hotel Reservation Program");
	}
	public void find_hotel_without_weekend(String start_date, String end_date) {
		//DayOfWeek day=date.getDayOfWeek();
		//DayOfWeek day1=date1.getDayOfWeek();
		Date d1=null; Date d2=null;
		try {
			d1=sdf.parse(start_date);
			d2=sdf.parse(end_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long difference=Math.abs(d2.getTime()-d1.getTime());
	    int diff = (int)TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
	    if(obj1.getReg_cost()*diff<obj2.getReg_cost()*diff)
	    {
	    	if(obj3.getReg_cost()*diff<obj1.getReg_cost()*diff)
	    		System.out.println(obj3.getHotel_name()+" "+obj3.getReg_cost()*diff);
	    	else
	    		System.out.println(obj1.getHotel_name()+" "+obj1.getReg_cost()*diff);
	    }
	    else
	    {
	    	if(obj2.getReg_cost()*diff<obj3.getReg_cost()*diff)
	    		System.out.println(obj2.getHotel_name()+" "+obj2.getReg_cost()*diff);
	    	else
	    		System.out.println(obj3.getHotel_name()+" "+obj3.getReg_cost()*diff);
	    }
	}
	public void find_hotel_based_on_weekend_and_weekday(String start_date, String end_date) {
		Calendar c = Calendar.getInstance();Date d1=null,d2=null;
		int arr[]=new int[3];
		ArrayList<Hotel> ar=new ArrayList<Hotel>();
		HashMap<String, Integer> cost_name=new HashMap<String,Integer>();
		ar.add(obj1);ar.add(obj2);ar.add(obj3);
		try {
			d1=sdf.parse(start_date);
			d2=sdf.parse(end_date);
		c.setTime(d1);int sum=0;
		long difference=Math.abs(d2.getTime()-d1.getTime());
	    int diff = (int)TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
	    for(Hotel i:ar)
	    {
	    	sum=0;
	    	for(int j=0;j<diff;j++)
	    	{
	    		int day_of_week=c.get(Calendar.DAY_OF_WEEK);
	    		if(day_of_week==Calendar.SATURDAY||day_of_week==Calendar.SUNDAY)
	    			sum+=i.getReg_weekend();
	    		else
	    			sum+=i.getReg_cost();
    			c.add(Calendar.DATE, 1);
	    	}
	    	cost_name.put(i.getHotel_name(), sum);
	    }
	    int min=Collections.min(cost_name.values());
	    for(Map.Entry<String,Integer> entry:cost_name.entrySet())
	    {
	    	if(min==entry.getValue())
	    	{
	    		System.out.println(entry.getKey()+" "+min);
	    		break;
	    	}
	    }	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	