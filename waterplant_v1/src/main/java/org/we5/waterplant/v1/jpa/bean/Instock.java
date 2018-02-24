package org.we5.waterplant.v1.jpa.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the waterplant_instock database table.
 * 
 */
@Entity
@Table(name="waterplant_instock")
@NamedQuery(name="WaterplantInstock.findAll", query="SELECT w FROM WaterplantInstock w")
public class Instock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stockID;

	private Timestamp date_of_creation;

	private int quantity;

	private String stock_ProductName;

	public Instock() {
	}

	public int getStockID() {
		return this.stockID;
	}

	public void setStockID(int stockID) {
		this.stockID = stockID;
	}

	public Timestamp getDate_of_creation() {
		return this.date_of_creation;
	}

	public void setDate_of_creation(Timestamp date_of_creation) {
		this.date_of_creation = date_of_creation;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStock_ProductName() {
		return this.stock_ProductName;
	}

	public void setStock_ProductName(String stock_ProductName) {
		this.stock_ProductName = stock_ProductName;
	}

}