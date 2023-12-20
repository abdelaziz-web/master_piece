package dao;

public class user {

	private int id ;
	private String full_name ;
	private String username ;
	private String email ;
	private String password ;
	private String phone_number ;
	private String date_of_birth ;
	private String photo ;
	
	
	


	public user(int id, String full_name, String email, String password, String phone_number, String date_of_birth,String photo,String username) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.date_of_birth = date_of_birth;
		this.photo = photo ;
		this.username=username ;
	}
	
	
	
	public user(String full_name, String email, String password, String phone_number, String date_of_birth,String username) {
		super();
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.date_of_birth = date_of_birth;
		this.username=username ;
		
	}

	
	public user() {
		super();
	}

	


	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	


	public int getId() {
		return id;
	}
	public  void setId(int id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
	
}
