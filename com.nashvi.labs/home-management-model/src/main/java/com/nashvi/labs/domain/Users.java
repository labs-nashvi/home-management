package com.nashvi.labs.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
@Table(name="USERS", schema="nashvi_idm")
public class Users implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID", length=15, nullable=false)
	private String userId;
	
	@Column(name="PASSWORD", length=15, nullable=false)
	private String password;
	
	@Column(name="CREATE_TIMESTAMP", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTimestamp;
	
	@Column(name="LAST_LOGIN_TIMESTAMP", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginTimestamp;
	
	@Column(name="INVALID_LOGIN_ATTEMPT", nullable=false)
	private int invalidLoginAttempt;
	
	@Column(name="STATUS", length=1, nullable=false)
	private char status;
	
	@Column(name="ROLES", length=45)
	private String roles;
	
	
	public Users() {
		super();
	}
   
}
