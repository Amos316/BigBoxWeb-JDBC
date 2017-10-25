package DatabaseClass;

import BusinessClass.Division;
import BusinessClass.Store;

public interface BigBoxWriter {
	boolean addStore(Store s);
	boolean updateStore(Store s);
	boolean addDivision(Division d);
//	boolean deleteStore(String d);

}
