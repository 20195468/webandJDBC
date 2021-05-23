package com.org.entity;

/**
 * @program: webLearn
 * @description
 * @author: 李星泽
 * @create: 2021-05-22 16:34
 **/
public class UserInfo {
    private Integer userid;
    private String usercode;
    private String userpwd;
    private String nickname;

    public UserInfo(Integer userid, String usercode, String userpwd, String nickname) {
        this.userid = userid;
        this.usercode = usercode;
        this.userpwd = userpwd;
        this.nickname = nickname;
    }

    public UserInfo() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }



    @Override
    public String toString() {
        return "UserInfo{" +
                "userid=" + userid +
                ", usercode='" + usercode + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
