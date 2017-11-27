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
}
