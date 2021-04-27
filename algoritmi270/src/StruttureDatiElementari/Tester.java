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
		int[] v = {2000000000,7,5,8,2,3,7,3,-10000};
		for(int i =0; i<v.length; i++)
			System.out.print(v[i]+",");
		System.out.println();
		System.out.println(Ordinamento.mediano(v));
		Ordinamento.countingSort(v);
		for(int i =0; i<v.length; i++)
			System.out.print(v[i]+",");
	}

}
