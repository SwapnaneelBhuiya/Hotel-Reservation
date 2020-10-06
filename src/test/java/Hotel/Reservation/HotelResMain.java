package Hotel.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
	public void find_cheapest_best_rated(String start_date, String end_date) {
		Calendar c = Calendar.getInstance();Date d1=null,d2=null;
		ArrayList<Hotel> ar=new ArrayList<Hotel>();
		ArrayList<Integer> rating=new ArrayList<Integer>();
		HashMap<String, Integer> cost_name=new HashMap<String,Integer>();
		ar.add(obj1);ar.add(obj2);ar.add(obj3);
		rating.add(obj1.getRating());rating.add(obj2.getRating());rating.add(obj3.getRating());
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
	    String name_for_min_cost="";
	    int rating_for_min=0;
	    for(Map.Entry<String,Integer> entry:cost_name.entrySet())
	    {
	    	if(min==entry.getValue())
	    	{
	    		name_for_min_cost=entry.getKey();
	    		break;
	    	}
	    }	
	    for(Hotel i:ar)
	    {
	    	if(i.getHotel_name().equals(name_for_min_cost))
	    	{
	    		rating_for_min=i.getRating();
	    		break;
	    	}
	    }
	    int var=0;
	    for(Map.Entry<String,Integer> entry:cost_name.entrySet())
	    {
	    	if(entry.getValue()-min<30)
	    	{
	    		for(Hotel i:ar)
	    		{
	    			if(i.getHotel_name().equals(entry.getKey()))
	    			{
	    				if(rating_for_min<i.getRating())
	    				{
	    					System.out.println(entry.getKey()+" "+min);var=1;
	    		    		break;
	    				}
	    			}
	    					
	    		}
	    	}
	    	if(var==1)
	    		break;
	    }
	    if(var==0)
	    	for(Map.Entry<String,Integer> entry:cost_name.entrySet())
		    {
		    	if(min==entry.getValue())
		    	{
		    		System.out.println(entry.getKey()+" "+min+" Rating "+rating_for_min);
		    		break;
		    	}
		    }	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void find_best_rated_hotel(String start_date, String end_date) {
		Calendar c = Calendar.getInstance();Date d1=null,d2=null;
		ArrayList<Hotel> ar=new ArrayList<Hotel>();
		ArrayList<Integer> rating=new ArrayList<Integer>();
		HashMap<String, Integer> cost_name=new HashMap<String,Integer>();
		ar.add(obj1);ar.add(obj2);ar.add(obj3);
		rating.add(obj1.getRating());rating.add(obj2.getRating());rating.add(obj3.getRating());
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
	    int max_rating=Collections.max(rating);int var=0;
	    for(Hotel i: ar)
	    {
	    	if(i.getRating()==(max_rating))
	    	{
	    		for(Map.Entry<String,Integer> entry:cost_name.entrySet())
			    {
			    	if(i.getHotel_name().equals(entry.getKey()))
			    	{
			    		System.out.println(entry.getKey()+" total cost "+entry.getValue()+" Rating "+max_rating);var=1;
			    		break;
			    	}
			    }	
	    	}
	    	if(var==1)
	    		break;
	    }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void find_best_rated_cheap_hotel_rewardcus(String start_date, String end_date) {
		Calendar c = Calendar.getInstance();Date d1=null,d2=null;
		ArrayList<Hotel> ar=new ArrayList<Hotel>();
		ArrayList<Integer> rating=new ArrayList<Integer>();
		HashMap<String, Integer> cost_name=new HashMap<String,Integer>();
		ar.add(obj1);ar.add(obj2);ar.add(obj3);
		rating.add(obj1.getRating());rating.add(obj2.getRating());rating.add(obj3.getRating());
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
	    			sum+=i.getRew_weekend();
	    		else
	    			sum+=i.getRew_cost();
    			c.add(Calendar.DATE, 1);
	    	}
	    	cost_name.put(i.getHotel_name(), sum);
	    }
	    int min=Collections.min(cost_name.values());
	    String name_for_min_cost="";
	    int rating_for_min=0;
	    for(Map.Entry<String,Integer> entry:cost_name.entrySet())
	    {
	    	if(min==entry.getValue())
	    	{
	    		name_for_min_cost=entry.getKey();
	    		break;
	    	}
	    }	
	    for(Hotel i:ar)
	    {
	    	if(i.getHotel_name().equals(name_for_min_cost))
	    	{
	    		rating_for_min=i.getRating();
	    		break;
	    	}
	    }
	    int var=0;
	    for(Map.Entry<String,Integer> entry:cost_name.entrySet())
	    {
	    	if(entry.getValue()-min<30)
	    	{
	    		for(Hotel i:ar)
	    		{
	    			if(i.getHotel_name().equals(entry.getKey()))
	    			{
	    				if(rating_for_min<i.getRating())
	    				{
	    					System.out.println(entry.getKey()+" "+min);var=1;
	    		    		break;
	    				}
	    			}
	    					
	    		}
	    	}
	    	if(var==1)
	    		break;
	    }
	    if(var==0)
	    	for(Map.Entry<String,Integer> entry:cost_name.entrySet())
		    {
		    	if(min==entry.getValue())
		    	{
		    		System.out.println(entry.getKey()+" "+min+" Rating "+rating_for_min);
		    		break;
		    	}
		    }	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void reward_hotel_stream(String start_date, String end_date) {
		Calendar c = Calendar.getInstance();Date d1=null,d2=null;
		ArrayList<Hotel> ar=new ArrayList<Hotel>();
		ArrayList<Integer> rating=new ArrayList<Integer>();
		HashMap<String, Integer> cost_name=new HashMap<String,Integer>();
		ar.add(obj1);ar.add(obj2);ar.add(obj3);
		rating.add(obj1.getRating());rating.add(obj2.getRating());rating.add(obj3.getRating());
		try {
			d1=sdf.parse(start_date);
			d2=sdf.parse(end_date);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		c.setTime(d1);
		long difference=Math.abs(d2.getTime()-d1.getTime());
	    int diff = (int)TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);int sum=0;
		for(Hotel i:ar)
	    {
	    	sum=0;
	    	for(int j=0;j<diff;j++)
	    	{
	    		int day_of_week=c.get(Calendar.DAY_OF_WEEK);
	    		if(day_of_week==Calendar.SATURDAY||day_of_week==Calendar.SUNDAY)
	    			sum+=i.getRew_weekend();
	    		else
	    			sum+=i.getRew_cost();
    			c.add(Calendar.DATE, 1);
	    	}
	    	cost_name.put(i.getHotel_name(), sum);
	    }
		int min=Collections.min(cost_name.values());
	    int rating_for_min=0;
	    final String name_for_min_cost=cost_name.entrySet().stream().filter(e -> e.getValue()==min).findFirst().map(e->e.getKey()).orElse("");
	    rating_for_min=ar.stream().filter(e-> e.getHotel_name().equals(name_for_min_cost)).findFirst().map(e->e.getRating()).orElse(0);
//	    cost_name.entrySet().stream().filter(e-> e.getValue()-min<30).flatMap(e->((Optional<Entry<String, Integer>>) ar.stream()
//	    		.filter(h->h.getHotel_name().equals(e.getKey())&&rating_for_min<h.getRating())
//	    				.peek(h->System.out.println(e.getKey()+" "+min))).orElse(h->System.out.println(e.getKey()+" Rating "+rating_for_min+" "+min)));
	    int var=0;
	    for(Map.Entry<String,Integer> entry:cost_name.entrySet())
	    {
	    	if(entry.getValue()-min<30)
	    	{
	    		for(Hotel i:ar)
	    		{
	    			if(i.getHotel_name().equals(entry.getKey()))
	    			{
	    				if(rating_for_min<i.getRating())
	    				{
	    					System.out.println(entry.getKey()+" "+min);var=1;
	    		    		break;
	    				}
	    			}
	    					
	    		}
	    	}
	    	if(var==1)
	    		break;
	    }
	    if(var==0)
	    	for(Map.Entry<String,Integer> entry:cost_name.entrySet())
		    {
		    	if(min==entry.getValue())
		    	{
		    		System.out.println(entry.getKey()+" "+min+" Rating "+rating_for_min);
		    		break;
		    	}
		    }
	    
	}
}
	