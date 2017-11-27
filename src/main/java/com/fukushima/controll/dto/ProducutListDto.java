package com.fukushima.controll.dto;

import java.text.NumberFormat;

import javax.persistence.Id;

import com.fukushima.controll.entity.ProductList;

/**
 * 在庫のDTO.
 * @author koshiro
 */
public class ProducutListDto {
	
	/** ID. */
	private Integer id;

	/** 商品番号. */
	private String productNum;

	/** 商品名. */
	private String productName;

	/** 単価. */
	private String unitPrice;

	/** 総額. */
	private String totalAmount;

	/** 商品在庫. */
	private String stockQuantit;

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
	public String getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 単価のsetter
	 * @param unitPrice 単価
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * 総額のgetter
	 * @return 総額
	 */
	public String getTotalAmount() {
		return totalAmount;
	}

	/**
	 * 総額のsetter
	 * @param totalAmount 総額
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 在庫数量のgetter
	 * @return 在庫数量
	 */
	public String getStockQuantit() {
		return stockQuantit;
	}

	/**
	 * 在庫数量のsetter
	 * @param stockQuantit 在庫数量
	 */
	public void setStockQuantit(String stockQuantit) {
		this.stockQuantit = stockQuantit;
	}

	/**
	 * ProductListのプロパティをDtoに転送.
	 * @param ProductListのentity
	 */
	public void copyPropertys(ProductList entity) {

		id = entity.getId();
		productNum = entity.getProductNum();
		productName = entity.getProductName();
		unitPrice = convertSeparateComma(entity.getUnitPrice());
		totalAmount = convertSeparateComma(entity.getTotalAmount());
		stockQuantit = convertSeparateComma(entity.getStockQuantit());
	}

	/**
	 * 数値をカンマ区切りに変換する
	 * @param num 数値
	 * @return 変換後の文字列
	 */
	private String convertSeparateComma(Integer num) {

		NumberFormat nfNum = NumberFormat.getNumberInstance();
		return nfNum.format(num);
	}

}
