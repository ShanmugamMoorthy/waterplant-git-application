package org.we5.waterplant.v1.jpa.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the waterplant_product database table.
 * 
 */
@Entity
@Table(name="waterplant_product")
@NamedQuery(name="WaterplantProduct.findAll", query="SELECT w FROM WaterplantProduct w")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prodID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date_of_creation;

	private int price;

	private String prod_Name;

	private String product_Desc;

	private int quantity;

	//bi-directional many-to-one association to WaterplantOrder
	@OneToMany(mappedBy="waterplantProduct")
	private Set<Order> waterplantOrders;

	//bi-directional many-to-one association to WaterplantVendor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Vend_ID")
	private Vendor waterplantVendor;

	public Product() {
	}

	public int getProdID() {
		return this.prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public Date getDate_of_creation() {
		return this.date_of_creation;
	}

	public void setDate_of_creation(Date date_of_creation) {
		this.date_of_creation = date_of_creation;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProd_Name() {
		return this.prod_Name;
	}

	public void setProd_Name(String prod_Name) {
		this.prod_Name = prod_Name;
	}

	public String getProduct_Desc() {
		return this.product_Desc;
	}

	public void setProduct_Desc(String product_Desc) {
		this.product_Desc = product_Desc;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Set<Order> getWaterplantOrders() {
		return this.waterplantOrders;
	}

	public void setWaterplantOrders(Set<Order> waterplantOrders) {
		this.waterplantOrders = waterplantOrders;
	}

	public Order addWaterplantOrder(Order waterplantOrder) {
		getWaterplantOrders().add(waterplantOrder);
		waterplantOrder.setWaterplantProduct(this);

		return waterplantOrder;
	}

	public Order removeWaterplantOrder(Order waterplantOrder) {
		getWaterplantOrders().remove(waterplantOrder);
		waterplantOrder.setWaterplantProduct(null);

		return waterplantOrder;
	}

	public Vendor getWaterplantVendor() {
		return this.waterplantVendor;
	}

	public void setWaterplantVendor(Vendor waterplantVendor) {
		this.waterplantVendor = waterplantVendor;
	}

}