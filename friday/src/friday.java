	/*
ID: ejoswin2
LANG: JAVA
TASK: friday
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;


public class friday {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new friday().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader bin = new BufferedReader(new FileReader("friday.in"));
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
//		PrintWriter pout1 = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		
		String str = bin.readLine();
		int y = 1900+ (Integer.parseInt(str))-1;
		
		int[] week = compute(y);
//		System.out.println(Arrays.toString(week));
//		pout1.println("eml");
//		pout.println(Arrays.toString(week));
		
		pout.print(week[6]);
//		System.out.println(week[6]);
		for(int i = 0; i < 6; i++){
			pout.print(" " + week[i]);
//			System.out.println(" " + week[i]);
		}
		pout.println();
		pout.close();
	}

	private int[]compute(int y) {
		// TODO Auto-generated method stub
//		System.out.println(y);
		int k = 0;
		int[] week = new int[7];
		for(int i = 1900; i <= y;  i++){
			for(int m = 1; m <= 12; m++){
				for(int d = 1; d <= 31; d++){
					if(m == 2){ // check for leap year
						if(d == 28){ k++;
						if(i%100 == 0){
							if(i%400 == 0){//2000-true, 2100 - not true
								k++;
//								System.out.println(i);
							}
						}else if(i%4 == 0){
							k++;
//							System.out.println(i);

						}
						break;
						}
					}
					else if(d == 30){
						if(m == 4 || m == 6 || m == 9 || m == 11){// dont iterate to d=31
							k++;
							break; 
						}
					}
					
					k++;
					
					if(d==13){
//						System.out.println(k);
						week[k%7]++;
					}				
				}
			}
			
		}
		return week;
		
	}

}
