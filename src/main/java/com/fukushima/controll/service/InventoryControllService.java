package com.fukushima.controll.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fukushima.controll.entity.ProductList;
import com.fukushima.controll.entity.User;
import com.fukushima.controll.repository.ProductListRepository;
import com.fukushima.controll.repository.UserRepository;

/**
 * サービスクラス
 * 
 * @author koshiro
 */
@Service
public class InventoryControllService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductListRepository productListRepository;

	/**
	 * ユーザー情報検索
	 * @param userName ユーザー名
	 * @return ユーザー情報
	 */
	public List<User> serchUser(String userName) {
		return userRepository.findUser(userName);
	}

	/**
	 * 商品在庫情報検索.
	 * @return 商品在庫情報
	 */
	public List<ProductList> serchAllProduct() {
		return productListRepository.findAllProduct();
	}
	
	/**
	 * 商品マスタ登録
	 * @param productNum 商品番号
	 * @param productName 商品名
	 * @param unit_price 単価
	 */
	public void saveProduct(String productNum, String productName, int unit_price) {
		productListRepository.saveProductMst(productNum, productName, unit_price);
	}

	public void saveStockProduct(String productNum, int stock_quantit) {
		productListRepository.saveStockProduct(productNum, stock_quantit);
	}
}
