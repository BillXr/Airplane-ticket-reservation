package Airtickets;
 

public class Tickets {
	String ticket_id;
	String issue_date;
	String client_name;
	String itinenary;
	double price;
	String company;
	int client_age;
	double luggage_weight;
	int height;

	public Tickets() {
		super();
	}
	public String getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getItinenary() {
		return itinenary;
	}

	public void setItinenary(String itinenary) {
		this.itinenary = itinenary;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getClient_age() {
		return client_age;
	}

	public void setClient_age(int client_age) {
		this.client_age = client_age;
	}

	public double getLuggage_weight() {
		return luggage_weight;
	}

	public void setLuggage_weight(double luggage_weight) {
		this.luggage_weight = luggage_weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	

	public Tickets(String ticket_id, String issue_date, String client_name, String itinenary, double price,
			String company, int client_age, double luggage_weight, int height) {
		//super();
		this.ticket_id = ticket_id;
		this.issue_date = issue_date;
		this.client_name = client_name;
		this.itinenary = itinenary;
		this.price = price;
		this.company = company;
		this.client_age = client_age;
		this.luggage_weight = luggage_weight;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Tickets [ticket_id=" + ticket_id + ", issue_date=" + issue_date + ", client_name=" + client_name
				+ ", itinenary=" + itinenary + ", price=" + price + ", company=" + company + ", client_age="
				+ client_age + ", luggage_weight=" + luggage_weight + ", height=" + height + "]";
	}
	
			
}
