package com.productPack;

import jakarta.persistence.*;

@Entity
@Table( name = "products" )
public class Product {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private int productId;
	
	@Column(name = "Name")
	private String productName;
	
	@Column(name = "Description")
	private String productDescription;
	
	@Column(name = "Price")
	private double productPrice;
	
	@Column(name = "Inventory")
	private int productInventory;
	
	
	
	public Product(){
		
	}
	
	


	public Product(String productName, String productDescription, double productPrice, int productInventory) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productInventory = productInventory;
	}




	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductDescription() {
		return productDescription;
	}



	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}



	public double getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}



	public int getProductInventory() {
		return productInventory;
	}



	public void setProductInventory(int productInventory) {
		this.productInventory = productInventory;
	}




	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productInventory=" + productInventory
				+ "]";
	}
	
	
	
}
