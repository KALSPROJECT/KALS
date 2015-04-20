package model;

public class Books {

	String ISBN;
	String title;
	String author;
	String publisher;
	String published_date;
	String cover_type;
	String language;
	int quantity;
	String section;
	String cost;
	
	public Books() {
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublished_date() {
		return published_date;
	}

	public void setPublished_date(String publisher_date) {
		this.published_date = publisher_date;
	}

	public String getCover_type() {
		return cover_type;
	}

	public void setCover_type(String cover_type) {
		this.cover_type = cover_type;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

}
