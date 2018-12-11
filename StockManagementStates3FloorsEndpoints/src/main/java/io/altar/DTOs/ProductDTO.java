package io.altar.DTOs;

import java.util.ArrayList;
import java.util.List;

import io.altar.models.BaseEntity;
import io.altar.models.Product;
import io.altar.models.Shelf;

public class ProductDTO extends BaseEntity{
	private static final long serialVersionUID=1L;
	private int discount;
	private int iva;
	private double pvp;
	private long id;
	public ProductDTO(){}
	public ProductDTO(int discount, int iva, double pvp, long id) {
		//super();
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
		this.id=id;
	}
	public static ProductDTO turnProductToProductDTO(Product productToPresent){
		ProductDTO productDTOToPresent=new ProductDTO(productToPresent.getDiscount(),productToPresent.getIva(),productToPresent.getPvp(),productToPresent.getId());
		return productDTOToPresent;
		
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public double getPvp() {
		return pvp;
	}
	public void setPvp(double pvp) {
		this.pvp = pvp;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
