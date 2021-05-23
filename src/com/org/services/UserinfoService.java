package com.org.services;

import java.util.List;

import com.org.entity.UserInfo;

public interface UserinfoService {
	List<UserInfo> getAll();
	UserInfo login(String usercode,String userpwd);
}
