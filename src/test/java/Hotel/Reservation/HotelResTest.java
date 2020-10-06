package Hotel.Reservation;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class HotelResTest {

	public static Hotel obj1;
	public static Hotel obj2;
	public static Hotel obj3;
	public static HotelResMain obj;
	@Before
	public void initialize()
	{
		obj=new HotelResMain();
		obj1=new Hotel("Lakewood");
		obj2=new Hotel("Bridgewood");
		obj3=new Hotel("Ridgewood");
	}
	@Test
	public void find_Cheapest_Hotel_Normal()
	{
		obj.find_hotel_without_weekend("14/03/2020","16/03/2020");
	}
	@Test
	public void add_weekend_and_weekday_rates()
	{
		obj1.setReg_cost(110);
		obj1.setReg_weekend(90);
		obj2.setReg_cost(160);
		obj2.setReg_weekend(60);
		obj3.setReg_cost(220);obj3.setReg_weekend(150);
	}
}
