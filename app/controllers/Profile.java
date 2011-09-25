package controllers;

import models.*;
import play.*;
import play.mvc.*;
import java.util.*;

import play.data.validation.*;
import java.net.*;
import java.io.*;

import play.Logger;

public class Profile extends Application {

	@Before
	static void checkConnected() {
		if (Auth.getUser() == null) {
			Application.login();
		} else {
			renderArgs.put("user", Auth.getEmail());
		}
	}

	public static void index(String tag) {
		User user = getUser();
		
		List<Payment> payments = null;
		payments = Payment.findByUser(user);

		render(user, payments);
	}
	
	public static void edit(Long userId) {
		notFoundIfNull(userId);
		User user = User.findById(userId);
		notFoundIfNull(user);
		checkSelfUser(user);

		String name = params.get("user.name");
		if(null == name || "".equals(name)) {
			render(user);
			return;
		}
		user.name = name;
		user.modifiedAt = new Date();
		user.update();

		index(null);
	}
	
	static void checkOwner(Payment payment) {
        if(!getUser().equals(payment.user)) {
            forbidden();
        }
    }
	
	static void checkSelfUser(User user) {
		if(!getUser().equals(user)) {
			forbidden();
		}
	}
	
	static User getUser() {	
		return User.findByEmail(Auth.getEmail());
    }

}