package com.grokonez.jwtauthentication.controller;

import java.awt.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.grokonez.jwtauthentication.message.request.LoginForm;
import com.grokonez.jwtauthentication.message.request.SignUpForm;
import com.grokonez.jwtauthentication.message.response.JwtResponse;
import com.grokonez.jwtauthentication.message.response.ResponseMessage;
import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.RoleName;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.RoleRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}
	@GetMapping("/member")
	public List<User> getAllUsers(){return (List<User>) userRepository.findAll();
	}

	@DeleteMapping("/member/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable("id") long id) {
		System.out.println("Delete Member with ID = " + id + "...");

		userRepository.deleteById(id);

		return new ResponseEntity<>("Member has been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "member/fname/{fname}")
	public List<User> findByFname(@PathVariable String fname) {

		List<User> members = userRepository.findByFname(fname);
		return members;
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getFname(), signUpRequest.getLname(), signUpRequest.getGender(), signUpRequest.getBirthday(), signUpRequest.getAddress(), signUpRequest.getTelephone(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "pm":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
	//Isurie
//	@GetMapping("/member")
//	public List<User> getAllMembers(){return userRepository.findAll();}

	@PostMapping("/membercreate")
	public User createMember(@Valid @RequestBody User memberDataObj) {

		return userRepository.save(memberDataObj);
	}

	@GetMapping(path = {"/member/{id}"})
	public User getMemberById(@PathVariable("id") Long id) {
		return userRepository.findById(id).get();

	}

	@PutMapping("/updatemember/{id}")
	public ResponseEntity<Object> updatemember(@RequestBody User member,@PathVariable Long id){
		Optional<User> memberupdateOptional = userRepository.findById(id);
		if(!memberupdateOptional.isPresent())
			return ResponseEntity.notFound().build();

		member.setId(id);
		userRepository.save(member);

		return  ResponseEntity.noContent().build();
	}


	@GetMapping(value="/userid/{username}")
	public Optional<User> getIdByUsername(@PathVariable String username){
		Optional<User> members = userRepository.findByUsername(username);
		return members;

	}

}