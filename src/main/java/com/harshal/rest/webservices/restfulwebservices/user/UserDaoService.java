package com.harshal.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;



@Component
public class UserDaoService {
	private int userCount = 3; 
	
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1,"Jesus",LocalDate.now().minusYears(30)));
		users.add(new User(2,"Moses",LocalDate.now().minusYears(40)));
		users.add(new User(3,"Lucifer",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public User findOne(int id){
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id){
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
		
	}
	
}
