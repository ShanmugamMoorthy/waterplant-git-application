package org.we5.waterplant.v1.jpa.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the waterplant_order database table.
 * 
 */
@Entity
@Table(name="waterplant_order")
@NamedQuery(name="Order.findAll", query="SELECT w FROM Order w")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date order_Date;

	private String order_Desc;

	private int price;

	private int quantity_Ordered;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Cust_ID")
	private Customer waterplantCustomer;

	//bi-directional many-to-one association to WaterplantProduct
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Prod_ID")
	private Product waterplantProduct;

	public Order() {
	}

	public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrder_Date() {
		return this.order_Date;
	}

	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}

	public String getOrder_Desc() {
		return this.order_Desc;
	}

	public void setOrder_Desc(String order_Desc) {
		this.order_Desc = order_Desc;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity_Ordered() {
		return this.quantity_Ordered;
	}

	public void setQuantity_Ordered(int quantity_Ordered) {
		this.quantity_Ordered = quantity_Ordered;
	}

	public Customer getWaterplantCustomer() {
		return this.waterplantCustomer;
	}

	public void setWaterplantCustomer(Customer waterplantCustomer) {
		this.waterplantCustomer = waterplantCustomer;
	}

	public Product getWaterplantProduct() {
		return this.waterplantProduct;
	}

	public void setWaterplantProduct(Product waterplantProduct) {
		this.waterplantProduct = waterplantProduct;
	}

}