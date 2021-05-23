package com.org.impl;

import java.util.List;

import com.org.services.UserinfoDao;
import com.org.impl.*;
import com.org.entity.UserInfo;
import com.org.services.UserinfoService;

public class UserinfoServiceImpl implements UserinfoService{

	private UserinfoDao userinfoDao = new UserInfoDaoImpl();
	
	@Override
	public List<UserInfo> getAll() {
		return userinfoDao.selectAll();
	}

	@Override
	public UserInfo login(String usercode, String userpwd) {
		
		if(usercode==null || usercode.length()<1) {
			return null;
		}
		
		if(userpwd==null || userpwd.length()<1) {
			return null;
		}
			
		return userinfoDao.selectByUsercodeAndUserpwd(
				new UserInfo(null,usercode,userpwd,null));
		
		
	}

}
