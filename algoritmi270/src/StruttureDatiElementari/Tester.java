/**
 * 
 */
package StruttureDatiElementari;

import java.util.*;

/**
 * @author sflesca
 *
 */
public class Tester {

	/**
	 * 
	 */
	public Tester() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = {0,12,4,23,6};
		Ordinamento.mergeSort(v);
		for(int i =0; i<v.length; i++)
			System.out.println(v[i]+",");
	}

}
