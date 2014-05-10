package com.nashvi.labs.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID", unique=true, nullable=false)
	private int userId;

	@Column(name="CREATE_TIMESTAMP", nullable=false)
	private Timestamp createTimestamp;

	@Column(name="INVALID_ATTEMPTS")
	private int invalidAttempts;

	@Column(name="LAST_LOGIN_TIMESTAMP", nullable=false)
	private Timestamp lastLoginTimestamp;

	@Column(nullable=false, length=15)
	private String password;

	@Column(nullable=false, length=1)
	private String status;

	@Column(name="USER_NAME", nullable=false, length=15)
	private String userName;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="user")
	private List<Address> addresses;

	//bi-directional many-to-one association to Ledger
	@OneToMany(mappedBy="user")
	private List<Ledger> ledgers;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public int getInvalidAttempts() {
		return this.invalidAttempts;
	}

	public void setInvalidAttempts(int invalidAttempts) {
		this.invalidAttempts = invalidAttempts;
	}

	public Timestamp getLastLoginTimestamp() {
		return this.lastLoginTimestamp;
	}

	public void setLastLoginTimestamp(Timestamp lastLoginTimestamp) {
		this.lastLoginTimestamp = lastLoginTimestamp;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setUser(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setUser(null);

		return address;
	}

	public List<Ledger> getLedgers() {
		return this.ledgers;
	}

	public void setLedgers(List<Ledger> ledgers) {
		this.ledgers = ledgers;
	}

	public Ledger addLedger(Ledger ledger) {
		getLedgers().add(ledger);
		ledger.setUser(this);

		return ledger;
	}

	public Ledger removeLedger(Ledger ledger) {
		getLedgers().remove(ledger);
		ledger.setUser(null);

		return ledger;
	}

}