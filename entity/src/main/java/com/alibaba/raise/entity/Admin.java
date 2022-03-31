package com.alibaba.raise.entity;

public class Admin {
    private Integer id;

    private String loginAct;

    // 应该是loginPwd,但是之前写太多了,怕改的太多浪费时间,就不改回来了,下回注意!
    private String userPwd;

    private String userName;

    private String email;

    private String createTime;
    
    public Admin() {
		
	}

    public Admin(Integer id, String loginAct, String userPwd, String userName, String email, String createTime) {
        this.id = id;
        this.loginAct = loginAct;
        this.userPwd = userPwd;
        this.userName = userName;
        this.email = email;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public Admin setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLoginAct() {
        return loginAct;
    }

    public Admin setLoginAct(String loginAct) {
        this.loginAct = loginAct;
        return this;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public Admin setUserPwd(String userPwd) {
        this.userPwd = userPwd;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Admin setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Admin setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Admin setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }
}