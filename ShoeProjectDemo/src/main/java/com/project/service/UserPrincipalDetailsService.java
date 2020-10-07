package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.model.User;
import com.project.repository.UserRepository;
import com.project.springSecurity.UserPrincipal;

@Service
@Transactional
public class UserPrincipalDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository repo;
	
	public User createUser(User user) {
		return repo.save(user);
	}
	
	public UserPrincipalDetailsService(UserRepository userRepository) {
	    this.repo = userRepository;
	  }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.repo.findByUsername(username);
	    UserPrincipal userPrincipal = new UserPrincipal(user);

	    return userPrincipal;
	}
}
