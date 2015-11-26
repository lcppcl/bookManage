package org.bookmanage.bean;

/*
 * 登陆模块
 */
public class Login {
	private Integer id; // 用户ID
	private String name; // 用户名
	private String password; // 密码
	private boolean role; // 角色
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
}
