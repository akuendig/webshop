package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.ShoppingCartEntry;


public class ShoppingCartRepository extends BaseRepository<ShoppingCartEntry>{

	public ShoppingCartRepository() {
		super(ShoppingCartEntry.class);
	}

	public final void create(int userId) {
		
		execute("INSERT INTO tblshoppingcart (`SC_ID` ,`SC_User_ID`) " +
				"VALUES (NULL, " + userId + " )");
	}

	public final int getIdForUser(int userId){

		String query =
				"SELECT SC_ID " +
				"FROM tblshoppingcart " +
				"WHERE SC_User_ID =" + userId;

		try (Statement stmt = this.sqlConnection.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(query)) {
				if (rs.next()) {
					return rs.getInt("SC_ID");
				}
			}

		} catch (final SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	public final List<ShoppingCartEntry> getEntries(int shoppingCartId){
		return getResults(
				"SELECT * " +
				"FROM shoppingcart_contains_product " +
				"WHERE SC_ID = " + shoppingCartId);
	}
	
	public final ShoppingCartEntry getEntry(int shoppingCartId, String productId) {
		
		return getResult(
				"SELECT * " +
				"FROM shoppingcart_contains_product " +
				"WHERE SC_ID = "+shoppingCartId+" AND SC_Product_ID = "+productId+" ");
	}
	
	public final void add(int shoppingCartId, String productId, int quantity) {
		
		ShoppingCartEntry entry = getEntry(shoppingCartId, productId);
		
		if (entry == null) {

			execute("INSERT INTO shoppingcart_contains_product " +
					"VALUES ( "+ shoppingCartId + ", "+ productId + ", " + quantity + " ) ");
		} else {

			execute("UPDATE shoppingcart_contains_product " +
					"SET SC_contains_Prd_Quantity = SC_contains_Prd_Quantity + " + quantity + " " +
					"WHERE SC_ID = " + shoppingCartId +
					" AND SC_Product_ID = " + productId +" ");
		}
		
	}
	
	public final void remove(int scid, String productid) {
		execute("DELETE FROM shoppingcart_contains_product "+
				"WHERE SC_ID = "+scid+ " AND SC_Product_ID = "+productid+" ");
	}

}