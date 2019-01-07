package com.app.dao.models;


public class Product {
	
	private Integer id;
	private String name;
	private String producer;
	private Double price;
	
	public Product(Integer id, String name, String producer, Double price) {
		this.id = id;
		this.name = name;
		this.producer = producer;
		this.price = price;
	}
	
	public Product() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}