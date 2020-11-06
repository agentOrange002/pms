package sys.app.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sys.app.pms.entity.User;
import sys.app.pms.service.UserService;

@RestController
@RequestMapping({ "/users" })
public class UserController {

	@Autowired
	UserService service;

	@PostMapping()
	public ResponseEntity<String> postUser(@RequestBody User user) {
		if (service.saveUser(user)) {
			return ResponseEntity.ok("Successfully Create User!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = service.fetchAllUser();
		return ResponseEntity.ok(users);
	}

	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserbyId(@PathVariable("id") String id) {		
		return ResponseEntity.ok( service.fetchUserById(id));
	}

}
