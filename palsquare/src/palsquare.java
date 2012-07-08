	/*
ID: ejoswin2
LANG: JAVA
TASK: palsquare
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class palsquare {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new palsquare().go();
	}

	private void go() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("palsquare.in"));
		
		int base = Integer.parseInt(bin.readLine().trim());
//		System.out.println(base);
		compute(base);
	}

	private void compute(int base) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

		String basenum = "";
		for(int i = 1; i <= 300; i++){
			basenum = toBase(i*i,base);
//			System.out.print(basenum);
			if(isPal(basenum)){
				//print i basenum-reversed
				pout.println(reverse(toBase(i,base)) + " " + basenum );
			}
//			System.out.println();
		}
		pout.close();
	}

	private String reverse(String basenum) {
		// TODO Auto-generated method stub
		String res = "";
		int l = basenum.length();
		for(int i = 0; i < l; i++){
			res = res+basenum.charAt(l-i-1);
		}
		return res;
	}

	private boolean isPal(String basenum) {
		// TODO Auto-generated method stub
		int l = basenum.length();
		for(int i = 0; i < l/2; i++){
			if(basenum.charAt(i)!= basenum.charAt(l-i-1)){
				return false;
			}
		}
		return true;
	}

	private String toBase(int i, int base) {
		// TODO Auto-generated method stub
		String inbase = "";
		String bases = "0123456789ABCDEFGHIJ";
		while(i != 0){
			inbase+= bases.charAt(i%base);
			i/=base;
		}
		return inbase;
	}
}
