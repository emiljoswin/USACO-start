/*
ID: ejoswin2
LANG: JAVA
TASK: ride
*/

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ride {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new ride().go();
	}

	private void go() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("ride.in"));
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

		String str = "";
//		System.out.println('A' + 1);

		while((str = bin.readLine())!= null){
			long comet = 1,  ufo = 1;
//			System.out.print(str + " ");
//			System.out.println(comet + " " + ufo);
			for(int i = 0; i < str.length(); i++){
//				System.out.println(str.charAt(i));
				comet*= str.charAt(i)-65+1;
			}
			str= bin.readLine();
//			System.out.println(str);
			for(int i = 0; i < str.length(); i++){
//				System.out.println(str.charAt(i)+1);
				ufo*= str.charAt(i)-65+1;
			}			
//			System.out.println(comet + " " + ufo);

//			System.out.println(comet%47 + " " + ufo%47);
			if(ufo%47 == comet%47) pout.println("GO");
			else pout.println("STAY");

		}
		pout.close();
				
		
	}

}
