/*
ID: ejoswin2
LANG: JAVA
TASK: gift1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class gift1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new  gift1().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		
		
		String str = bin.readLine();
		int count = Integer.parseInt(str);
		String[] ppl = new String[count];
		
		for(int i = 0; i < count; i++){
			ppl[i] = bin.readLine();					
		}
		int[] net = new int[count];
		int[] initial = new int[count];
		
 		for(int i = 0; i < count; i++){
			String str1 =  bin.readLine();
			int j;
			for(j = 0; i < count; j++){
				if(ppl[j].equals(str1)){
					break;
				}
			}
			
						if(j > count) System.out.println("mismatch");
			
			StringTokenizer st = new StringTokenizer(bin.readLine());
			
			int cost = Integer.parseInt(st.nextToken());
			int n =  Integer.parseInt(st.nextToken());
			int each = 0;
			initial[j] = cost;
			
			if(n != 0)
				 each = cost/n;
			else
				each = 0;
			
			for(int l = 0 ; l < n; l++){
				str1 = bin.readLine();
				for(int k = 0; k < count; k++){
					if(ppl[k].equals(str1)){
						net[k] = net[k] + each;
					}
				}
			}
			if(n!= 0)
			net[j] = net[j] + cost - each*n;
			
		}
 		
 		for(int i = 0; i < count; i++){
 			pout.println(ppl[i] + " " + (net[i] - initial[i]));
 			System.out.println(ppl[i] + " " +  (net[i] - initial[i]));
 		}
		
 		pout.close();
		
	}

}
