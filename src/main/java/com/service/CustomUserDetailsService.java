package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.entity.CustomUserDetails;
import com.entity.UserCredential;
import com.google.common.base.Optional;
import com.repo.UserCredentialRepo;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserCredentialRepo repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserCredential> credential = repository.findByName(username);
		UserDetails details = new CustomUserDetails(credential.get());
		return details;
	}

}
