package com.fukushima.controll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fukushima.controll.entity.ProductList;

/**
 * 在庫一覧のRepository
 * @author koshiro
 *
 */
@Transactional
@Repository
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

	/**
	 * 商品マスタ登録.
	 * @param productNum 商品番号
	 * @param productName 商品名
	 * @param unit_price 商品単価
	 */
	@Modifying
	@Query(value = "INSERT INTO product_mst "
			+ "(product_num, product_name, unit_price, created) "
			+ "VALUES "
			+ "(:productNum, :productName, :unit_price, NOW())", nativeQuery = true)
	void saveProductMst(@Param("productNum") String productNum, @Param("productName") String productName,
						@Param("unit_price") int unit_price);
	
	@Modifying
	@Query(value="INSERT INTO stock_product "
			+ "(product_num, stock_quantit, modify) "
			+ "VALUES "
			+ "(:productNum, :stock_quantit, NOW())", nativeQuery = true)
	void saveStockProduct(@Param("productNum") String productNum, @Param("stock_quantit") int stock_quantit);
}
