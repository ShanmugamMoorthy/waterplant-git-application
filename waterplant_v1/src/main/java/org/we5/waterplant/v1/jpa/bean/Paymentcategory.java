package org.we5.waterplant.v1.jpa.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the waterplant_paymentcategory database table.
 * 
 */
@Entity
@Table(name="waterplant_paymentcategory")
@NamedQuery(name="PaymentCategory.findAll", query="SELECT w FROM PaymentCategory w")
public class PaymentCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int catID;

	private String category;

	//bi-directional many-to-one association to WaterplantPayment
	@OneToMany(mappedBy="waterplantPaymentcategory")
	private Set<Payment> waterplantPayments;

	public PaymentCategory() {
	}

	public int getCatID() {
		return this.catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<Payment> getWaterplantPayments() {
		return this.waterplantPayments;
	}

	public void setWaterplantPayments(Set<Payment> waterplantPayments) {
		this.waterplantPayments = waterplantPayments;
	}

	public Payment addWaterplantPayment(Payment waterplantPayment) {
		getWaterplantPayments().add(waterplantPayment);
		waterplantPayment.setWaterplantPaymentcategory(this);

		return waterplantPayment;
	}

	public Payment removeWaterplantPayment(Payment waterplantPayment) {
		getWaterplantPayments().remove(waterplantPayment);
		waterplantPayment.setWaterplantPaymentcategory(null);

		return waterplantPayment;
	}

}