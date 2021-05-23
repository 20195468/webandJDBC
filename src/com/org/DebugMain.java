package com.org;

import com.org.entity.UserInfo;
import com.org.impl.UserinfoServiceImpl;
import com.org.services.UserinfoService;

/**
 * @program: webandJDBC
 * @description
 * @author: 李星泽
 * @create: 2021-05-23 10:02
 **/
public class DebugMain {

    public UserInfo tryDemo() {
        UserinfoService userinfoService = new UserinfoServiceImpl();
        return userinfoService.login("a", "123");
    }

    public static void main(String[] args) {
        UserinfoService userinfoService = new UserinfoServiceImpl();
        UserInfo userInfo = userinfoService.login("a", "123");
        System.out.println(userInfo);
    }
}
