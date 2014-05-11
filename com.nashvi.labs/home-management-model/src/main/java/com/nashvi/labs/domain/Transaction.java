package com.nashvi.labs.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the TRANSACTION database table.
 * 
 */
@Entity
@Table(name="TRANSACTION")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TX_ID", unique=true, nullable=false)
	private int txId;

	@Column(name="TX_AMOUNT", nullable=false)
	private double txAmount;

	@Column(name="TX_COMMENT", length=50)
	private String txComment;

	@Column(name="TX_GROUP_ID", nullable=false, length=20)
	private String txGroupId;

	@Column(name="TX_TIMESTAMP", nullable=false)
	private Timestamp txTimestamp;

	@Column(name="TX_TYPE", nullable=false, length=1)
	private String txType;

	//bi-directional many-to-one association to Ledger
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TX_LEDGER_ID", nullable=false)
	private Ledger ledger;

	public Transaction() {
	}

	public int getTxId() {
		return this.txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public double getTxAmount() {
		return this.txAmount;
	}

	public void setTxAmount(double txAmount) {
		this.txAmount = txAmount;
	}

	public String getTxComment() {
		return this.txComment;
	}

	public void setTxComment(String txComment) {
		this.txComment = txComment;
	}

	public String getTxGroupId() {
		return this.txGroupId;
	}

	public void setTxGroupId(String txGroupId) {
		this.txGroupId = txGroupId;
	}

	public Timestamp getTxTimestamp() {
		return this.txTimestamp;
	}

	public void setTxTimestamp(Timestamp txTimestamp) {
		this.txTimestamp = txTimestamp;
	}

	public String getTxType() {
		return this.txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public Ledger getLedger() {
		return this.ledger;
	}

	public void setLedger(Ledger ledger) {
		this.ledger = ledger;
	}

}