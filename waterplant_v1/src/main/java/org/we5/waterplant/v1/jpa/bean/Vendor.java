package org.we5.waterplant.v1.jpa.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the waterplant_vendor database table.
 * 
 */
@Entity
@Table(name="waterplant_vendor")
@NamedQuery(name="WaterplantVendor.findAll", query="SELECT w FROM WaterplantVendor w")
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vendID;

	private String company;

	private String email;

	private String mobileNumber;

	private String name;

	//bi-directional many-to-one association to WaterplantProduct
	@OneToMany(mappedBy="waterplantVendor")
	private Set<Product> waterplantProducts;

	public Vendor() {
	}

	public int getVendID() {
		return this.vendID;
	}

	public void setVendID(int vendID) {
		this.vendID = vendID;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public Set<Product> getWaterplantProducts() {
		return this.waterplantProducts;
	}

	public void setWaterplantProducts(Set<Product> waterplantProducts) {
		this.waterplantProducts = waterplantProducts;
	}

	public Product addWaterplantProduct(Product waterplantProduct) {
		getWaterplantProducts().add(waterplantProduct);
		waterplantProduct.setWaterplantVendor(this);

		return waterplantProduct;
	}

	public Product removeWaterplantProduct(Product waterplantProduct) {
		getWaterplantProducts().remove(waterplantProduct);
		waterplantProduct.setWaterplantVendor(null);

		return waterplantProduct;
	}

}