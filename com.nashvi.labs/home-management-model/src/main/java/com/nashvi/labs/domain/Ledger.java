package com.nashvi.labs.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LEDGER database table.
 * 
 */
@Entity
@Table(name="LEDGER")
@NamedQuery(name="Ledger.findAll", query="SELECT l FROM Ledger l")
public class Ledger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LEDGER_ID", unique=true, nullable=false)
	private int ledgerId;

	@Column(name="LEDGER_NAME", nullable=false, length=50)
	private String ledgerName;

	@Column(name="LEDGER_TYPE", nullable=false, length=1)
	private String ledgerType;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="ledger")
	private List<Transaction> transactions;

	public Ledger() {
	}

	public int getLedgerId() {
		return this.ledgerId;
	}

	public void setLedgerId(int ledgerId) {
		this.ledgerId = ledgerId;
	}

	public String getLedgerName() {
		return this.ledgerName;
	}

	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}

	public String getLedgerType() {
		return this.ledgerType;
	}

	public void setLedgerType(String ledgerType) {
		this.ledgerType = ledgerType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setLedger(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setLedger(null);

		return transaction;
	}

}