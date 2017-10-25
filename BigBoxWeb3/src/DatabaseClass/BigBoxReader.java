package DatabaseClass;

import java.util.ArrayList;

import BusinessClass.Store;


public interface BigBoxReader {
	ArrayList<Store> listAllStores();
	ArrayList<Store>  listAllStores(String d);
	
	
	double getSalesSummary();
	double getSalesSummary(String d);
//	boolean deleteStore(String d);

}
