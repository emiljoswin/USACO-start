/*
* Got Tle for the first time from usaco. Passed in the second run. Since the upper limit of the 
* no of farmers is explicitly given we need not sort it on the basis of the cost rether we can
* input them into the array where the cost will be the array index. 
* Awesome idea. You will solve the problem in lenear time with this approach. =)))) 
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/*
ID: ejoswin2
LANG: JAVA
TASK: milk
*/

public class milk {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new milk().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("milk.in"));
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		
		String[] str1 = bin.readLine().trim().split(" ");
		int cap = Integer.parseInt(str1[0]);
		int count = Integer.parseInt(str1[1]);
		int[][] input = new int[count][2];
		int i = count-1;
		while(i >= 0){
			str1 = bin.readLine().trim().split(" ");
			input[i][0]	= Integer.parseInt(str1[0]);
			input[i][1] = Integer.parseInt(str1[1]);
			i--;
		}
		int res = compute(input, count, cap);
		pout.println(res);
		pout.close();
	}

	private int compute(int[][] input, int count, int cap) {
//		// TODO Auto-generated method stub
//		for(int i = 0; i < count; i++){
//			System.out.println(Arrays.toString(input[i]));
//		}
//		System.out.println(count);
//		System.out.println(cap);
		int[] cost = new int[count];
		for(int i = 0; i < count; i++){
			cost[i] = input[i][0];
		}
		Arrays.sort(cost);
		int[][] Array = new int[count][2];
		int req = 0;
		int money = 0;
		int i = 0;
		for(i = 0; i < count && req < cap ; i++){
			for(int j = 0; j < count; j++){
				if(cost[i] == input[j][0]){
					Array[i][0] = input[j][0];
					Array[i][1] = input[j][1];
					input[j][0] = -1;
					req+= Array[i][1];
					money+= Array[i][1]*Array[i][0];
					break;
				}
			}
		}
		if(req == cap) return money;
		req = req-Array[i-1][1];
		money = money - Array[i-1][1]*Array[i-1][0];
		money += (cap-req)*Array[i-1][0];
		
//		for(int i = 0; i < count ; i++){
//			for(int j = 0; j < count; j++){
//				if(cost[i] == input[j][0]){
//					Array[i][0] = input[j][0];
//					Array[i][1] = input[j][1];
//					input[j][0] = -1;
//					break;
//				}
//			}
//		}
////		for(int i = 0; i < count; i++){
////			System.out.println(Arrays.toString(Array[i]));
////		}
//		int req = 0; 
//		int money = 0;
//		int i = 0;
//		for(i = 0; req < cap; i++){
//			req+= Array[i][1];
//			money+= Array[i][1]*Array[i][0];
//		}
//		if(req == cap) return money;
//		
//		req = req-Array[i-1][1];
//		money = money - Array[i-1][1]*Array[i-1][0];
//		
//		money += (cap-req)*Array[i-1][0];
//		
		return money;
	}

}
