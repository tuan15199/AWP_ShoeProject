//package com.project;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.project.model.Role;
//import com.project.model.User;
//import com.project.repository.UserRepository;
//
//import javax.transaction.Transactional;
//
//@Service
//@Transactional
//public class DbInitUser implements CommandLineRunner {
//	@Autowired
//	private UserRepository userRepository;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
////	public DbInitUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
////		this.userRepository = userRepository;
////		this.passwordEncoder = passwordEncoder;
////	}
//
//	@Override
//	public void run(String... args) {
//		// Delete all
////		this.userRepository.deleteAll();
//
//		// Create users
////		admin.setUsername("admin");
////		admin.setPassword(passwordEncoder.encode("admin123"));
////		admin.setRoles(Role.ADMIN);
////		admin.setPermissions("");
//		User admin = new User("admin", passwordEncoder.encode("admin123"), Role.ADMIN, "");
//
////		List<User> users = Arrays.asList(admin);
//
//		// Save to database
//		this.userRepository.save(admin);
//	}
//}
