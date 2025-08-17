package model;

import java.io.Serializable;

public class Customer implements Serializable{
    private int id;
    private String name;
    private String tel;
    private String email;
	
    public Customer() {
	super();
    }

    public Customer( String name, String tel, String email ) {
	super();
	this.name = name;
        this.tel = tel;
        this.email = email;
    }
    public int getId() {
	return id;
    }

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }
  
    public String getTel() {
        return tel;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setId(int id) {
        this.id = id;
    }
    
        	
}