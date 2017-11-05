package DatabaseClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import BusinessClass.Division;
import BusinessClass.Store;

public class BigBoxDB implements BigBoxDAO {

	private HashMap<Integer, Division> divisionIdMap = new HashMap<>();

	private Connection getConnection()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		

		Class.forName("com.mysql.jdbc.Driver").newInstance();

		

		String dbUrl = "jdbc:mysql://localhost:3306/bigbox";
		String username = "root";
		String password = "3368";
		Connection connection = DriverManager.getConnection(dbUrl, username, password);
		return connection;
	}

	public BigBoxDB() {

		populateDivisionMap();

	}

	@Override

	public ArrayList<Store> listAllStores() {

		ArrayList<Store> stores = new ArrayList<>();

		String stmt = "SELECT * from Stores";

		try (Connection connection = getConnection();

				PreparedStatement ps = connection.prepareStatement(stmt);

				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				int id = rs.getInt(1);

				int divId = rs.getInt(2);

				Division d = divisionIdMap.get(divId);

				String storeNbr = rs.getString(3);

				double sales = rs.getDouble(4);

				String name = rs.getString(5);

				String address = rs.getString(6);

				String city = rs.getString(7);

				String state = rs.getString(8);

				String zip = rs.getString(9);

				Store s = new Store(id, d, storeNbr, sales, name, address, city, state, zip);

				stores.add(s);

			}

		}

		catch (SQLException se) {

			System.err.println("BigBoxDB:  Error getting all stores!");

			se.printStackTrace();

			return null;

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stores;

	}

	@Override
	public ArrayList<Division> listAllDivisions() {

		ArrayList<Division> divisions = new ArrayList<>();

		String stmt = "SELECT * from divisions";

		try (Connection connection = getConnection();

				PreparedStatement ps = connection.prepareStatement(stmt);

				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				int id = rs.getInt(1);

				String divNum = rs.getString(2);

				String name = rs.getString(3);

				String address = rs.getString(4);

				String city = rs.getString(5);

				String state = rs.getString(6);

				String zip = rs.getString(7);

				Division d = new Division(id, divNum, name, address, city, state, zip);

				divisions.add(d);

			}

		}

		catch (SQLException se) {

			System.err.println("BigBoxDB:  Error getting all divisions!");

			se.printStackTrace();

			return null;

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return divisions;

	}

	private void populateDivisionMap() {

		String stmt = "SELECT * from Divisions";

		try (Connection connection = getConnection();

				PreparedStatement s = connection.prepareStatement(stmt);

				ResultSet rs = s.executeQuery(stmt)) {

			while (rs.next()) {

				int id = rs.getInt(1);

				String divNbr = rs.getString(2);

				String name = rs.getString(3);

				String address = rs.getString(4);

				String city = rs.getString(5);

				String state = rs.getString(6);

				String zip = rs.getString(7);

				Division d = new Division(id, divNbr, name, address, city, state, zip);

				divisionIdMap.put(id, d);

			}

		}

		catch (SQLException se) {

			System.err.println("BigBoxDB:  Error populating division map!");

			se.printStackTrace();

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override

	public ArrayList<Store> listAllStores(String divNbr) {

		ArrayList<Store> stores = new ArrayList<>();

		String stmt = "select * from stores where divisionID in " +

				"(select id from divisions where divisionNumber = ?)";

		try (Connection connection = getConnection();

				PreparedStatement ps = connection.prepareStatement(stmt)) {

			ps.setString(1, divNbr);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt(1);

				int divId = rs.getInt(2);

				Division d = divisionIdMap.get(divId);

				String storeNbr = rs.getString(3);

				double sales = rs.getDouble(4);

				String name = rs.getString(5);

				String address = rs.getString(6);

				String city = rs.getString(7);

				String state = rs.getString(8);

				String zip = rs.getString(9);

				Store s = new Store(id, d, storeNbr, sales, name, address, city, state, zip);

				stores.add(s);

			}

		}

		catch (SQLException se) {

			System.err.println("BigBoxDB:  Error getting all stores!");

			se.printStackTrace();

			return null;

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stores;

	}

	@Override

	public double getSalesSummary() {

		double sum = 0.0;

		String stmt = "select sum(sales) from stores";

		try (Connection connection = getConnection();

				PreparedStatement s = connection.prepareStatement(stmt);

				ResultSet rs = s.executeQuery(stmt)) {

			if (rs.next()) {

				sum = rs.getDouble(1);

			}

		}

		catch (SQLException se) {

			System.err.println("BigBoxDB:  Error in getSalesSummary()!");

			se.printStackTrace();

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sum;

	}

	@Override

	public double getSalesSummary(String d) {

		double sum = 0.0;

		ArrayList<Store> divStores = listAllStores(d);

		for (Store s : divStores) {

			sum += s.getSales();

		}

		return sum;

	}

	@Override

	public boolean addStore(Store s) {

		String stmt = "INSERT INTO stores (divisionID,StoreNumber,sales,Name,Address,City,State,ZipCode) "

				+ " VALUES (?,?, ?, ?, ?, ?, ?,?)";

		try (Connection connection = getConnection();

				PreparedStatement ps = connection.prepareStatement(stmt)) {

			ps.setString(1, s.getDivisionNumber());

			ps.setString(2, s.getStoreNum());

			ps.setDouble(3, s.getSales());

			ps.setString(4, s.getName());

			ps.setString(5, s.getAddress());

			ps.setString(6, s.getCity());

			ps.setString(7, s.getState());

			ps.setString(8, s.getZip());

			ps.executeUpdate();

			

		} catch (SQLException e) {

			System.err.println(e);

		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return false;

	}

	@Override

	public boolean deleteStore(Store s) {
		// ArrayList<Store> divStores = listAllStores(d);

		String stmt = "DELETE FROM stores WHERE StoreNumber = ?";

		boolean response = false;

		try (Connection connection = getConnection();

				PreparedStatement ps = connection.prepareStatement(stmt)) {

			ps.setString(1, s.getStoreNum());

			response = ps.execute();

		//	System.out.println("Delete excuted succesfully.");

		} catch (SQLException e) {

			System.err.println(e);

		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return response;

	}

	@Override

	public boolean addDivision(Division d) {

		String stmt = "INSERT INTO Divisions (ID,DivisionNumber,Name,Address,City,State,ZipCode) "

				+ " VALUES (?,?, ?, ?, ?, ?, ?)";

		try (Connection connection = getConnection();

				PreparedStatement ps = connection.prepareStatement(stmt)) {

			ps.setInt(1, d.getId());

			ps.setString(2, d.getDivNum());

			ps.setString(3, d.getName());

			ps.setString(4, d.getAddress());

			ps.setString(5, d.getCity());

			ps.setString(6, d.getState());

			ps.setString(7, d.getZip());

			ps.executeUpdate();

		//	System.out.println("Division Added Successfully");

		} catch (SQLException e) {

			System.err.println(e);
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;

	}

	@Override

	public boolean deleteDivision(Division d) {

		String stmt = "DELETE FROM divisions WHERE DivisionNumber = ?";

		try (Connection connection = getConnection();

				PreparedStatement ps = connection.prepareStatement(stmt)) {

			ps.setString(1, d.getDivNum());

			ps.executeUpdate();

		//	System.out.println("Division deleted successfully");

		} catch (SQLException e) {

			System.err.println(e);

		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return false;

	}

	public boolean updateStore(Store s) {

		String stmt = "UPDATE stores SET " + "sales = ?," + "Name = ?," + "Address =?," + "City= ?," + "State =?,"
				+ "ZipCode = ?" + "WHERE StoreNumber = ?";

		try (Connection connection = getConnection();

				PreparedStatement ps = connection.prepareStatement(stmt)) {

			ps.setDouble(1, s.getSales());

			ps.setString(2, s.getName());

			ps.setString(3, s.getAddress());

			ps.setString(4, s.getCity());

			ps.setString(5, s.getState());

			ps.setString(6, s.getZip());

			ps.setString(7, s.getStoreNum());

			ps.executeUpdate();

			//System.out.println("Store Updated Succesfully");

		} catch (SQLException e) {

			System.err.println(e);

		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	public void testSQL() {

		String stmt = "SELECT date('now')";

		try (Connection connection = getConnection();

				PreparedStatement s = connection.prepareStatement(stmt);

				ResultSet rs = s.executeQuery(stmt)) {

			while (rs.next()) {

				String testStr = rs.getString(1);

				System.out.println("result from test Select date('now')=" + testStr);

			}

		}

		catch (SQLException se) {

			System.err.println("BigBoxDB:  Error populating division map!");

			se.printStackTrace();

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
