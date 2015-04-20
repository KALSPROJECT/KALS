package model;

public class Fines {
	int transaction_id;
	int rental_id;
	int user_id;
	String amount_due;
	String fine_issue_date;
	
	public Fines() {
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
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

	public String getAmount_due() {
		return amount_due;
	}

	public void setAmount_due(String amount_due) {
		this.amount_due = amount_due;
	}

	public String getFine_issue_date() {
		return fine_issue_date;
	}

	public void setFine_issue_date(String fine_issue_date) {
		this.fine_issue_date = fine_issue_date;
	}
	
	
}
