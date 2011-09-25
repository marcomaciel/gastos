package models;

import siena.*;
import java.util.*;

public class User extends Model {
 
	@Id
	public Long id;
	
    public String email;
    public String password;
    public String name;
	public Date createdAt;
	public Date modifiedAt;
	
	static Query<User> all() {
		return Model.all(User.class);
	}
	
	public static User findById(Long id) {
		return all().filter("id", id).get();
	}
	
	public static User findByEmail(String email) {
		return all().filter("email", email).get();
	}
    
	public User() {
		super();
	}
	
	public User(String email) {
		this.email = email;
	}
	
	public String toString() {
		return email;
	}
	
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
