package com.fukushima.controll.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ProductListのEntity
 * 
 * @author koshiro
 */
@Entity
public class ProductList {

	/** ID. */
	@Id
	private Integer id;

	/** 商品番号. */
	private String productNum;

	/** 商品名. */
	private String productName;

	/** 単価. */
	private Integer unitPrice;

	/** 総額. */
	private Integer totalAmount;

	/** 商品在庫. */
	private Integer stockQuantit;

	/**
	 * IDのgetter
	 * @return ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * IDのsetter
	 * @param id ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 商品番号のgetter
	 * @return 商品番号
	 */
	public String getProductNum() {
		return productNum;
	}

	/**
	 * 商品番号のsetter
	 * @param productNum 商品番号
	 */
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	/**
	 * 商品名のgetter
	 * @return 商品名
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * 商品名のsetter
	 * @param productName 商品名
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 単価のgetter
	 * @return 単価
	 */
	public Integer getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 単価のsetter
	 * @param unitPrice 単価
	 */
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * 総額のgetter
	 * @return 総額
	 */
	public Integer getTotalAmount() {
		return totalAmount;
	}

	/**
	 * 総額のsetter
	 * @param totalAmount 総額
	 */
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 在庫数量のgetter
	 * @return 在庫数量
	 */
	public Integer getStockQuantit() {
		return stockQuantit;
	}

	/**
	 * 在庫数量のsetter
	 * @param stockQuantit 在庫数量
	 */
	public void setStockQuantit(Integer stockQuantit) {
		this.stockQuantit = stockQuantit;
	}
}
