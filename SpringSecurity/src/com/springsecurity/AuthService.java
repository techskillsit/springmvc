package com.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.DB.DBConfig;
import com.springsecurity.model.User;
 
@Service
public class AuthService implements UserDetailsService{

	@Autowired
	private DBConfig db;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//go to DB and fetch user based on username
		System.out.println(username);
		User user  = db.loadUserByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid");
		}
		 
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getAuthorities());
	}

}
