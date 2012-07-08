/*
ID: ejoswin2
LANG: JAVA
TASK: milk2
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class milk2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new milk2().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int count = Integer.parseInt(bin.readLine());
		
		int[][] array = new int[count][2];
		for(int i = 0; i < count; i++){
			StringTokenizer st = new StringTokenizer(bin.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = compute(array,count);
		
		
		pout.println(result[0] + " "  + result[1]);
//		System.out.println(result[0] + " "  + result[1]);
		
		pout.close();
	}

	private int[] compute(int[][] array, int count) {
		// TODO Auto-generated method stub
		int[] temp = new int[count];
		for(int i = 0; i < count; i++){
			temp[i] = array[i][0];
		}
		
		Arrays.sort(temp);
		
		int[][] a = new int[count][2];
		for(int i = 0; i < count; i++){
			for(int j= 0; j  < count; j++){
				if(temp[i] == array[j][0]){
					a[i][0] = array[j][0];
					a[i][1] = array[j][1];
					break;
				}
			}
		}
		
		
		for(int i = 0; i < count; i++){
			System.out.println(Arrays.toString(a[i]));
		}
		
		int milk = a[0][1]-a[0][0];
		int idle = 0;
		
		int longmilk = milk;
		int longidle = 0;
		int mango = a[0][1];
		int apple =  a[0][1];
		for(int i = 0; i < count-1; i++){
			if(apple >= a[i+1][0]){
				if(a[i+1][1] > apple) {
					milk+= a[i+1][1]-apple;
					apple = a[i+1][1];
				}							
			}
			else{
				if(milk>longmilk){
					longmilk = milk;
				}
				milk = a[i+1][1] - a[i+1][0];
				apple = a[i+1][1];
			}
			if(a[i][1] > mango) mango = a[i][1];
			
			if(mango < a[i+1][0]){
				idle = a[i+1][0]-mango;
				if(idle > longidle) longidle = idle;
			}
			
		}
		int[] res =  {longmilk,longidle};
		return res;
	}

}