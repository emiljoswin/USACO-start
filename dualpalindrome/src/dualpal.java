
/*
ID: ejoswin2
LANG: JAVA
TASK: dualpal
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;


public class dualpal {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new dualpal().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("dualpal.in"));
		
		String[] in = bin.readLine().trim().split(" ");
//		System.out.println(Arrays.toString(in));
		int count = Integer.parseInt(in[0]);
		int limit = Integer.parseInt(in[1]);
		compute(count,limit);
		
	}

	private void compute(int count, int limit) throws Exception {
		// TODO Auto-generated method stub
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

		int c = 0;
		
		for(int i = limit+1; c < count; i++){
			int no = 0;
			for(int base = 2; base <= 10; base++){
				String inbase  = toBase(i,base);
				if(isPal(inbase)){
					//put i inside the arraylist
					no++;
					if(no == 2){
//						System.out.println(i);
						pout.println(i);
						c++;
						break;
					}
					
				}
			}
		}
		pout.close();
	}

	private boolean isPal(String inbase) {
		// TODO Auto-generated method stub
		int l = inbase.length();
		if(inbase.charAt(0) == '0') return false;
		for(int i = 0; i < l/2; i++){
			if(inbase.charAt(i)!=inbase.charAt(l-i-1)){
				return false;
			}
		}
		return true;
	}

	private String toBase(int i, int base) {
		// TODO Auto-generated method stub
		String baseString = "0123456789";
		String res = "";
		while(i!= 0){
			res += baseString.charAt(i%base);
			i/=base;
		}
		return res;
	}

}
