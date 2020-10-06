package Hotel.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HotelResMain {
	
	public static Hotel obj1=new Hotel("Lakewood",3,110,90,80,80);
	public static Hotel obj2=new Hotel("Bridgewood",4,160,60,110,50);
	public static Hotel obj3=new Hotel("Ridgewood",5,220,150,100,40);
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public static void main(String args[])
	{
		System.out.println("Welcome to Hotel Reservation Program");
	}
	public static void find_hotel_without_weekend(String start_date, String end_date) {
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
	
}