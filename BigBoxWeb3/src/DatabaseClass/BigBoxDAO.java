package DatabaseClass;

import java.util.ArrayList;

import BusinessClass.Division;
import BusinessClass.Store;

public interface BigBoxDAO extends BigBoxReader, BigBoxWriter{

	boolean addDivision(Division d);

	boolean deleteStore(Store s);

	boolean deleteDivision(Division d);

	ArrayList<Division> listAllDivisions();

//	Store getStoreForDivisionAndStoreNumber(Division d, String storeNumber);
	
	
	

}
