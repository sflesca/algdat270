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
		int[] v = {4,7,5,8,2,3,7,3,1};
		System.out.println(Ordinamento.mediano(v));
		Ordinamento.quickSort(v);
		for(int i =0; i<v.length; i++)
			System.out.print(v[i]+",");
	}

}
