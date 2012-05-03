package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.ShoppingCartEntry;


public class ShoppingCartRepository extends BaseRepository<ShoppingCartEntry> implements IShoppingCartRepository{

	public ShoppingCartRepository() {
		super(ShoppingCartEntry.class);
	}

	/* (non-Javadoc)
	 * @see data.IShoppingCartRepository#create(int)
	 */
	@Override
	public final void create(int userId) {
		
		execute("INSERT INTO tblshoppingcart (`SC_ID` ,`SC_User_ID`) " +
				"VALUES (NULL, " + userId + " )");
	}

	/* (non-Javadoc)
	 * @see data.IShoppingCartRepository#getIdForUser(int)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see data.IShoppingCartRepository#getEntries(int)
	 */
	@Override
	public final List<ShoppingCartEntry> getEntries(int shoppingCartId){
		return getResults(
				"SELECT * " +
				"FROM shoppingcart_contains_product " +
				"WHERE SC_ID = " + shoppingCartId);
	}
	
	/* (non-Javadoc)
	 * @see data.IShoppingCartRepository#getEntry(int, int)
	 */
	@Override
	public final ShoppingCartEntry getEntry(int shoppingCartId, int productId) {
		
		return getResult(
				"SELECT * " +
				"FROM shoppingcart_contains_product " +
				"WHERE SC_ID = "+shoppingCartId+" AND SC_Product_ID = "+productId+" ");
	}
	
	/* (non-Javadoc)
	 * @see data.IShoppingCartRepository#add(int, int, int)
	 */
	@Override
	public final void add(int shoppingCartId, int productId, int quantity) {
		
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
	
	/* (non-Javadoc)
	 * @see data.IShoppingCartRepository#remove(int, int, int)
	 */
	@Override
	public final void remove(int shoppingCartId, int productId, int quantity) {

		ShoppingCartEntry entry = getEntry(shoppingCartId, productId);
			
		if (entry == null) {
			return;
		} else if (entry.getQuantity() <= quantity) {
			execute("DELETE FROM shoppingcart_contains_product "+
					"WHERE SC_ID = "+ shoppingCartId + " AND SC_Product_ID = " + productId + " ");
		} else {
			execute("UPDATE shoppingcart_contains_product " +
					"SET SC_contains_Prd_Quantity = SC_contains_Prd_Quantity + " + (entry.getQuantity() - quantity) + " " +
					"WHERE SC_ID = " + shoppingCartId +
					" AND SC_Product_ID = " + productId +" ");
		}
	}
}
