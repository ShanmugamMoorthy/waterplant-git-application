package org.we5.waterplant.v1.jpa.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the waterplant_customer database table.
 * 
 */
@Entity
@Table(name="waterplant_customer")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custID;

	private String company;

	private int credit;

	private String email;

	private String mobileNumber;

	private String name;

	//bi-directional many-to-one association to WaterplantOrder
	@OneToMany(mappedBy="waterplantCustomer")
	private Set<Order> waterplantOrders;

	//bi-directional many-to-one association to WaterplantPayment
	@OneToMany(mappedBy="waterplantCustomer")
	private Set<Payment> waterplantPayments;

	public Customer() {
	}

	public int getCustID() {
		return this.custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getCredit() {
		return this.credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Order> getWaterplantOrders() {
		return this.waterplantOrders;
	}

	public void setWaterplantOrders(Set<Order> waterplantOrders) {
		this.waterplantOrders = waterplantOrders;
	}

	public Order addWaterplantOrder(Order waterplantOrder) {
		getWaterplantOrders().add(waterplantOrder);
		waterplantOrder.setWaterplantCustomer(this);

		return waterplantOrder;
	}

	public Order removeWaterplantOrder(Order waterplantOrder) {
		getWaterplantOrders().remove(waterplantOrder);
		waterplantOrder.setWaterplantCustomer(null);

		return waterplantOrder;
	}

	public Set<Payment> getWaterplantPayments() {
		return this.waterplantPayments;
	}

	public void setWaterplantPayments(Set<Payment> waterplantPayments) {
		this.waterplantPayments = waterplantPayments;
	}

	public Payment addWaterplantPayment(Payment waterplantPayment) {
		getWaterplantPayments().add(waterplantPayment);
		waterplantPayment.setWaterplantCustomer(this);

		return waterplantPayment;
	}

	public Payment removeWaterplantPayment(Payment waterplantPayment) {
		getWaterplantPayments().remove(waterplantPayment);
		waterplantPayment.setWaterplantCustomer(null);

		return waterplantPayment;
	}

}