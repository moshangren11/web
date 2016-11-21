package com.graduation.web.util;

public class UserInSession {
	
	private String id;//admin
	
    private String password; //password
    
    private Boolean logged = false;// 默认否
    
	/** 
	 * @return id 
	 */
	public String getId() {
		return id;
	}

	/** 
	 * @param id 要设置的 id 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/** 
	 * @return password 
	 */
	public String getPassword() {
		return password;
	}

	/** 
	 * @param password 要设置的 password 
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** 
	 * @return logged 
	 */
	public Boolean getLogged() {
		return logged;
	}

	/** 
	 * @param logged 要设置的 logged 
	 */
	public void setLogged(Boolean logged) {
		this.logged = logged;
	}

}
