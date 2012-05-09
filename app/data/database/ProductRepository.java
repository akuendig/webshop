package data.database;

import java.util.List;

import data.IProductRepository;

import model.Product;


public class ProductRepository extends BaseRepository<Product> implements IProductRepository {

	public ProductRepository() {
		super(Product.class);
	}

	/* (non-Javadoc)
	 * @see data.IProductRepository#getById(int)
	 */
	@Override
	public final Product getById(final int id) {

		return getResult(
				"SELECT * " +
				"FROM tblproduct " +
				"WHERE Product_ID="+id);
	}

	/* (non-Javadoc)
	 * @see data.IProductRepository#getAll()
	 */
	@Override
	public final List<Product> getAll() {

		return getResults(
				"SELECT * " +
				"FROM tblproduct " +
				"ORDER BY ProductName ");
	}

	/* (non-Javadoc)
	 * @see data.IProductRepository#getRefined(java.lang.String, int, int)
	 */
	@Override
	public final List<Product> getRefined(String name, int categoryId, int brandId) {
		String query =
				"SELECT * " +
				"FROM tblproduct ";

		// Important to make the join first!!!
		if (categoryId != 0) {
			query +=
					"INNER JOIN " +
					"( " +
					"	SELECT phc.Product_ID " +
					"	FROM product_has_category AS phc " +
					"	WHERE phc.Category_ID=" + categoryId + " " +
					") AS pds USING(Product_ID) ";
		}

		if (name != null && name != "") {
			query += "WHERE ProductName LIKE '%"+name+"%' ";
		}

		if (brandId != 0) {
			query += name != null && name != "" ? "AND " : "WHERE ";
			query += Product.PRODUCT_BRAND_ID+"="+ brandId + " ";
		}

		query += "ORDER BY ProductName ";

		return getResults(query);
	}

	/* (non-Javadoc)
	 * @see data.IProductRepository#getByName(java.lang.String)
	 */
	@Override
	public final List<Product> getByName(final String name) {

		return getResults(
				"SELECT * " +
				"FROM tblproduct " +
				"WHERE ProductName LIKE '%"+name+"%' " +
				"ORDER BY ProductName ");
	}

	/* (non-Javadoc)
	 * @see data.IProductRepository#getByCategory(java.lang.String)
	 */
	@Override
	public final List<Product> getByCategory(final int categoryId) {

		return getResults(
				"SELECT * " +
				"FROM tblproduct AS p " +
				"WHERE p."+Product.PRODUCT_ID+" IN " +
				"	( " +
				"		SELECT phc.Product_ID as Product_ID " +
				"		FROM tblproduct_has_category AS phc " +
				"		WHERE phc.Category_ID="+ categoryId +
				"	) " +
				"ORDER BY p.ProductName"); // ManuZeile
	}

	/* (non-Javadoc)
	 * @see data.IProductRepository#getByBrand(java.lang.String)
	 */
	@Override
	public final List<Product> getByBrand(final int brandId) {

		return getResults(
				"SELECT * " +
				"FROM tblproduct AS p " +
				"WHERE p."+Product.PRODUCT_BRAND_ID+"="+ brandId + " " +
				"ORDER BY p.ProductName "); // ManuZi
	}


	/* (non-Javadoc)
	 * @see data.IProductRepository#getByPopularity()
	 */
	@Override
	public final List<Product> getByPopularity() {
		return getResults(
	            "SELECT * " +
	            "FROM tblProduct AS p " +
	            "LEFT JOIN ( " +
	            "    SELECT ulp.Product_ID AS ulp_ID, count(*) AS cnt " +
	            "    FROM user_likes_product AS ulp, tblProduct " +
	            "    WHERE ulp.Product_ID = tblProduct.Product_ID " +
	            "    GROUP BY tblProduct.Product_ID " +
	            "    ORDER BY cnt DESC " +
	            "    ) AS j " +
	            "ON p.Product_ID = j.ulp_ID " +
	            "ORDER BY cnt DESC, ProductName ASC; ");
	}

	/* (non-Javadoc)
	 * @see data.IProductRepository#getProductsInShoppingCart(int)
	 */
	@Override
	public final List<Product> getProductsInShoppingCart(int shoppingCartId) {

		return getResults(
				"SELECT * " +
				"FROM tblproduct " +
				"INNER JOIN " +
				"    ( " +
				"        SELECT * " +
				"        FROM shoppingcart_contains_product " +
				"        WHERE SC_ID = " + shoppingCartId + " " +
				"    ) AS scids " +
				"ON tblproduct.Product_ID = scids.SC_Product_ID " +
				"ORDER BY tblProduct.ProductName");
	}
}
