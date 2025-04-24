package it.rf.biblioteca.DTO;

public class LoginRequestDTO {
	
	private String user;
	private String psw;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
	public LoginRequestDTO () {
		
	}
	public LoginRequestDTO(String user, String psw) {
		super();
		this.user = user;
		this.psw = psw;
	}
	
	

}
