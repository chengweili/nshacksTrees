package treeProject;

public class Client {
	
	private String name;
	private String phoneNumber;
	private String email;
	private Event event;
	
	
	public Client() {
		this.name = "";
		this.phoneNumber = "0";
		this.email = "";
		this.event = null;
		
	}
	
	public Client(String n, String pNum, String eMail, Event e) {
		this();
		this.name = "";
		this.phoneNumber = "-";
		this.email = "";
		this.event = null;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	

	public void createEvent(Event e) {
			
			
		}
	
	

}
