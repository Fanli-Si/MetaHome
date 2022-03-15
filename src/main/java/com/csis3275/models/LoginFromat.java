package com.csis3275.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class LoginFromat {
	@Entity
	@Table(name = "LoginFormat")
	public class LoginFormat {

		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long UserID;

		@Column(name = "username")
		private String username;

		@Column(name = "password")
		private String password;

		public LoginFormat(String username, String password) {
			
			this.username = username;
			this.password = password;
		}

		public LoginFormat() {
			
		}

		public long getUserID() {
			return UserID;
		}

		public void setUserID(long userID) {
			UserID = userID;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
	}

}
