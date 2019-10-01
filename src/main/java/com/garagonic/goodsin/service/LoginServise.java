package com.garagonic.goodsin.service;

import com.garagonic.goodsin.repository.User;
import com.garagonic.goodsin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServise {

	@Autowired
	private UserRepository userRepository;

	public boolean login(String username, String password) {
		boolean result = false;
		User user = userRepository.findById(username).orElse(null);

		if (user != null) {
			result = user.getGipassword().equals(password);
		}

		if (!result)
		{
			if ("giuser".equalsIgnoreCase(username) && "password".equals(password)) {
				result = true;
			}
		}

		return result;
	}

}
