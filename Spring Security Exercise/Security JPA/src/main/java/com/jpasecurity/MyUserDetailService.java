package com.jpasecurity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jpasecurity.model.MyUserDetails;
import com.jpasecurity.model.User;
import com.jpasecurity.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	
		Optional<User> user= userRepository.findByUserName(userName);
		return user.map(MyUserDetails::new).get();
	}


}
