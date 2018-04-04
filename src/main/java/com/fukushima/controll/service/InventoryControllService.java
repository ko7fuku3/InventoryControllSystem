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

	/**
	 * 商品在庫登録
	 * @param productNum 商品名
	 * @param stock_quantit 単価
	 */
	public void saveStockProduct(String productNum, int stock_quantit) {
		productListRepository.saveStockProduct(productNum, stock_quantit);
	}

	/**
	 * 商品番号で商品検索
	 * @param productNum 商品番号
	 * @return 検索結果
	 */
	public ProductList selectProduct(String productNum) {
		return productListRepository.findProduct(productNum);
	}
	
	/**
	 * 更新処理
	 * @param productNum 商品番号
	 * @param unitPrice 単価
	 * @param stockQuantit 在庫数
	 */
	public void updateProductService(String productNum, String unitPrice, String stockQuantit) {
		
		// 単価を数値に変換
		int intUnitPrice = Integer.parseInt(unitPrice);
		// 在庫数を数値に変換
		int intStockQuantit = Integer.parseInt(stockQuantit);
		
		productListRepository.updateProduct(productNum, intUnitPrice, intStockQuantit);
	}
	
	/**
	 * 削除処理
	 * @param productNum
	 */
	public void deleteProductService(String productNum) {
		productListRepository.deleteProduct(productNum);
	}
}
