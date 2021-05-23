package com.org.services;

import java.util.List;

import com.org.entity.UserInfo;

public interface UserinfoDao {
	List<UserInfo> selectAll();
	UserInfo selectByUsercodeAndUserpwd(UserInfo userinfo);
}
