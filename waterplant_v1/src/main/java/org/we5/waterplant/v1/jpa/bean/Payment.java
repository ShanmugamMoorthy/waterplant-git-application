package org.we5.waterplant.v1.jpa.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the waterplant_payment database table.
 * 
 */
@Entity
@Table(name="waterplant_payment")
@NamedQuery(name="Payment.findAll", query="SELECT w FROM Payment w")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int payID;

	private int amount;

	private Timestamp payment_Date;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Cust_ID")
	private Customer waterplantCustomer;

	//bi-directional many-to-one association to WaterplantPaymentcategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Payment_Type")
	private PaymentCategory waterplantPaymentcategory;

	public Payment() {
	}

	public int getPayID() {
		return this.payID;
	}

	public void setPayID(int payID) {
		this.payID = payID;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getPayment_Date() {
		return this.payment_Date;
	}

	public void setPayment_Date(Timestamp payment_Date) {
		this.payment_Date = payment_Date;
	}

	public Customer getWaterplantCustomer() {
		return this.waterplantCustomer;
	}

	public void setWaterplantCustomer(Customer waterplantCustomer) {
		this.waterplantCustomer = waterplantCustomer;
	}

	public PaymentCategory getWaterplantPaymentcategory() {
		return this.waterplantPaymentcategory;
	}

	public void setWaterplantPaymentcategory(PaymentCategory waterplantPaymentcategory) {
		this.waterplantPaymentcategory = waterplantPaymentcategory;
	}

}