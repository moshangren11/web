package com.graduation.web.util;

public class UserInSession {
	
	private String id;//admin
	
    private String password; //password
    
    private Boolean logged = false;// Ĭ�Ϸ�
    
	/** 
	 * @return id 
	 */
	public String getId() {
		return id;
	}

	/** 
	 * @param id Ҫ���õ� id 
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
	 * @param password Ҫ���õ� password 
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
	 * @param logged Ҫ���õ� logged 
	 */
	public void setLogged(Boolean logged) {
		this.logged = logged;
	}

}
