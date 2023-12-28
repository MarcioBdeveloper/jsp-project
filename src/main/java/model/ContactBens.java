package model;

public class ContactBens {
	
	private String id;
	private String name;
	private String fone;
	private String email;
	private String adress;
	private String zipCode;
	
	
	public ContactBens() {
		super();
	}

	public ContactBens(String id, String name, String fone, String email, String adress, String zipCode) {
		super();
		this.id = id;
		this.name = name;
		this.fone = fone;
		this.email = email;
		this.adress = adress;
		this.zipCode = zipCode;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
