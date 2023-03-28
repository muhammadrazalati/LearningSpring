package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	public static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "in28minutes", "Learn Aws", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "in28minutes", "Learn Azure", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "in28minutes", "Learn DevOps", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsernamme(String usename){
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done){
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	
	}
}
