package quanlithuvien;

public class Account {
	private String username;
	private String password;
	private String name;
	private String identityCard;
	
	public Account(){}
	
	public Account(String username, String password, String name, String identityCard) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.identityCard = identityCard;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	
	public boolean changePassword(){
		
	}
	
}
