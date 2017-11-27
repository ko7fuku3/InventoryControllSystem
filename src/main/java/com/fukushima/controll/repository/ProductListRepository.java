package com.fukushima.controll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fukushima.controll.entity.ProductList;

/**
 * 在庫一覧のRepository
 * @author koshiro
 *
 */
public interface ProductListRepository extends JpaRepository<ProductList, Integer> {

	/**
	 * 商品在庫情報検索.
	 * 
	 * @return 全商品在庫情報
	 */
	@Query(value = "SELECT mst.id,"
			+"stk.product_num,"
			+"mst.product_name,"
			+"mst.unit_price,"
			+"stk.stock_quantit,"
			+"mst.unit_price * stk.stock_quantit as 'total_amount'"
			+"FROM stock_product stk "
			+ "LEFT JOIN product_mst mst "
			+ "ON stk.product_num = mst.product_num",
			nativeQuery = true)
	List<ProductList> findAllProduct();
}
