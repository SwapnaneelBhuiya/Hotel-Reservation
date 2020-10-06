package Hotel.Reservation;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class HotelResTest {

	HotelResMain obj;
	@Before
	public void initialize()
	{
		obj=new HotelResMain();
	}
	@Test
	public void find_Cheapest_Hotel_Normal()
	{
		obj.find_hotel_without_weekend("14/03/2020","16/03/2020");
	}
}
