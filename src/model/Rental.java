package model;

public class Rental {
	int rental_id;
	int user_id;
	String video_title;
	String ISAN;
	String book_title;
	String ISBN;
	String rental_start_date;
	String rental_end_date;
	
	public Rental(){
	}

	public int getRental_id() {
		return rental_id;
	}

	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getVideo_title() {
		return video_title;
	}

	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}

	public String getISAN() {
		return ISAN;
	}

	public void setISAN(String iSAN) {
		ISAN = iSAN;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getRental_start_date() {
		return rental_start_date;
	}

	public void setRental_start_date(String rental_start_date) {
		this.rental_start_date = rental_start_date;
	}

	public String getRental_end_date() {
		return rental_end_date;
	}

	public void setRental_end_date(String rental_end_date) {
		this.rental_end_date = rental_end_date;
	}
	
}
