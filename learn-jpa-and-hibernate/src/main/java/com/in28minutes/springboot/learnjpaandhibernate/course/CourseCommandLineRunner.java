package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CoursejdbcRepository repository;      used for jdbc
	
//	@Autowired
//	private CourseJpaRepository repository;       used for Jpa
	
	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		repository.save(new Course(1,"Learn AWS NOW!","in28minutes"));
		repository.save(new Course(2,"Learn Azure NOW!","in28minutes"));
		repository.save(new Course(3,"Learn Devops NOW!","in28minutes"));
		repository.deleteById(3L);
		System.out.println(repository.findById(1L));
		System.out.println(repository.findById(2L));
		System.out.println(repository.findAll());
		
		//Calling custom methods defined in CourseSpringDataJpaRepository
		System.out.println(repository.findByAuthor("in28minutes"));
		System.out.println(repository.findByName("Learn Azure NOW!"));
		
	}

}
