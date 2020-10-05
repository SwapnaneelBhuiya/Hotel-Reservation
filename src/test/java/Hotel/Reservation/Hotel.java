package Hotel.Reservation;

public class Hotel {
	private String hotel_name;
	private int rating;
	private int reg_cost;
	private int reg_weekend;
	private int rew_cost;
	private int rew_weekend;
	public Hotel(String ar, int a, int b, int c, int d, int e)
	{
		hotel_name=ar;
		rating=a;
		reg_cost=b;
		reg_weekend=c;
		rew_cost=d;
		rew_weekend=e;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getReg_cost() {
		return reg_cost;
	}
	public void setReg_cost(int reg_cost) {
		this.reg_cost = reg_cost;
	}
	public int getReg_weekend() {
		return reg_weekend;
	}
	public void setReg_weekend(int reg_weekend) {
		this.reg_weekend = reg_weekend;
	}
	public int getRew_cost() {
		return rew_cost;
	}
	public void setRew_cost(int rew_cost) {
		this.rew_cost = rew_cost;
	}
	public int getRew_weekend() {
		return rew_weekend;
	}
	public void setRew_weekend(int rew_weekend) {
		this.rew_weekend = rew_weekend;
	}
}
