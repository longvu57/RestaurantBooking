package restaurantBooking.entity;

public class EmailContent {
	private String email;
	private String subject;
	private String content;

	public EmailContent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailContent(String email, String subject, String content) {
		super();
		this.email = email;
		this.subject = subject;
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
