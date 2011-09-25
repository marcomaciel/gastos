package models;

import java.util.*;
import siena.*;

public class Payment extends Model {

	@Id(Generator.AUTO_INCREMENT)
	public Long id;

	public Date paymentDate;
	public Double amount;
	public Category category;
	public String description;
	public Date createdAt;
	public Date modifiedAt;

	@Index("user_index")
	public User user;

	public Payment() {
	}

	static Query<Payment> all() {
		return Model.all(Payment.class);
	}

	public static Payment findById(Long id) {
		return all().filter("id", id).get();
	}

	public static List<Payment> findByUser(User user) {
		return all().filter("user", user).order("-created").fetch();
	}

	public Payment(Double amount, User user) {
		super();
		this.amount = amount;
		this.user = user;
	}

	public Payment(Double amount, Category category, String description,
			User user) {
		super();
		this.amount = amount;
		this.category = category;
		this.description = description;
		this.user = user;
	}

}
