package Hotel.Reservation;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class HotelResTest {

	public Hotel obj1=new Hotel("Lakewood",3,110,90,80,80);
	public Hotel obj2=new Hotel("Bridgewood",4,160,60,110,50);
	public Hotel obj3=new Hotel("Ridgewood",5,220,150,100,40);
	public static HotelResMain obj;
	@Before
	public void initialize()
	{
		obj=new HotelResMain();
	}
	@Test
	public void find_Cheapest_Hotel_Normal()
	{
		obj.find_hotel_without_weekend(obj1, obj2, obj3,"14/03/2020","16/03/2020");
	}
	@Test
	public void find_cheapest_hotel_based_on_weekday_and_weekend()
	{
		obj.find_hotel_based_on_weekend_and_weekday(obj1, obj2, obj3,"14/03/2020","18/03/2020");
	}
	@Test
	public void cheapest_best_rated()
	{
		obj.find_cheapest_best_rated(obj1, obj2, obj3,"14/03/2020","18/03/2020");
	}
	@Test
	public void best_rated_hotel()
	{
		obj.find_best_rated_hotel(obj1, obj2, obj3,"14/03/2020","18/03/2020");
	}
	@Test
	public void best_rated_cheap_hotel_reward_customer()
	{
		obj.find_best_rated_cheap_hotel_rewardcus(obj1, obj2, obj3,"14/03/2020","18/03/2020");
	}
	@Test
	public void best_rated_cheap_hotel_reward_customer_usingstream()
	{
		obj.reward_hotel_stream(obj1, obj2, obj3,"14/03/2020","18/03/2020");
	}
	@Test
	public void best_rated_cheap_hotel_regular_usingstream()
	{
		obj.reward_hotel_stream_regular(obj1, obj2, obj3,"14/03/2020","18/03/2020");
	}
}
