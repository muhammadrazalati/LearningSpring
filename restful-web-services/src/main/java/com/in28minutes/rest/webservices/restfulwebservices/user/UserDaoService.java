package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static int count = 0;
	private static List<User> users = new ArrayList<>();
	
	static {
		
		users.add(new User(++count,"in28min",LocalDate.now().minusYears(30)));
		users.add(new User(++count,"in30min",LocalDate.now().minusYears(30)));
		users.add(new User(++count,"in25min",LocalDate.now().minusYears(30)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id){
		Predicate<? super User> predicate = user -> user.getId()==id;
		return users.stream().filter(predicate).findFirst().orElse(null);   // orElse returns value if present and if not thn else case
		
	}
	
	public void deleteById(int id){
		Predicate<? super User> predicate = user -> user.getId()==id;
		users.removeIf(predicate);		
	}
	
	public User saveUser(User user){
		user.setId(++count);
		users.add(user);
		return user;
		
	}
	

}
