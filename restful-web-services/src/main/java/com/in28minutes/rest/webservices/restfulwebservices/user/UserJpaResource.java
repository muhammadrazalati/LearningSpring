package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	private UserRepository repository;
	private PostRepository postRepository;

	public UserJpaResource(UserRepository repository, PostRepository postRepository) {
		super();
		this.repository = repository;
		this.postRepository = postRepository;
	}

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {

		return repository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id: " + id);
		return user.get();
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);

	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id: " + id);
		return user.get().getPosts();

	}

	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri(); // to return location also where user is created
		// for accessing current path, to add path of new user, making id availabe to
		// new path, converting to uri.

		return ResponseEntity.created(location).build(); // for returning correct respose i.e 201

	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostsForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id: " + id);
		post.setUser(user.get());
		Post savedPost = postRepository.save(post); // getting description already from requestbody and settting user here then
									// saving

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri(); 

		return ResponseEntity.created(location).build();

	}

}
