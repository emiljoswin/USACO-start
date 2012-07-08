import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


/*
ID: ejoswin2
LANG: JAVA
TASK: barn1
 */

public class barn1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new barn1().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		String str = bin.readLine().trim();
		String[] in = str.split(" ");
		int M = Integer.parseInt(in[0]);
		int S = Integer.parseInt(in[1]);
		int C = Integer.parseInt(in[2]);
		int i = 0;
		int[] stall = new int[C];
		while(i< C){
			str = bin.readLine().trim();
			stall[i] = Integer.parseInt(str);
			i++;
		}
		int res = compute(stall,M,C);
		pout.println(res);
		pout.close();
	}

	private int compute(int[] stall, int m, int c) {
		// TODO Auto-generated method stub
		Arrays.sort(stall);
		int total = stall[c-1]-stall[0] + 1;
		int[] diff = new int[c-1];
		for(int i = 1; i < c; i++){
			diff[i-1] = stall[i] - stall[i-1]; 
		}
		Arrays.sort(diff);
//		System.out.println(Arrays.toString(diff));
//		System.out.println(diff[16]);
		for(int i = 0; i < m-1 && i < c-1 ; i++){
//			System.out.println(diff[c-1-i-1]);
			total = total - diff[c-1-i-1]+1;
		}
//		System.out.println(total);
		return total;
	}

}
