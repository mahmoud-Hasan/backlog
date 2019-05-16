package com.swf.cairo.backlog.service;

import com.swf.cairo.backlog.model.User;

public interface UserService {
	
	User saveUser(User user);
	User getUserByName(String userName);
	
}
