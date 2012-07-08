/*
ID: ejoswin2
LANG: JAVA
TASK: transform
 */
/* Got in the second try. Since there was a small misunderstanding about the question. The condition 6 was supposed to be checked 
 * at the sixth time only. Instead I checked it first. There were no corner cases. 
 * Good work.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;


public class transform {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new transform().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("transform.in"));
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		
		int n = Integer.parseInt(bin.readLine());
		String[] pattern = new String[n];
		for(int i = 0; i < n;i++){
			pattern[i] = bin.readLine().trim();
		}
		String[] newPattern = new String[n];
		for(int i = 0; i < n;i++){
			newPattern[i] = bin.readLine().trim();
		}
		int res = comptute(pattern,newPattern);
		
		pout.println(res);
		pout.close(); 	
	}

	private int comptute(String[] pattern, String[] newPattern) {
		// TODO Auto-generated method stub
		int len = pattern.length;
		String[] one = ninety(pattern);
		
		if(check(one,newPattern)){
			return 1;
		}	
		String[] two = ninety(one);
		
		if(check(two,newPattern)){
			return 2;
		}
		String[] three = ninety(two);
		if(check(three,newPattern)){
			return 3;
		}
		String[] rot = rotate(pattern);
		if(check(rot,newPattern)){
			return 4;
		}
		
		int ans = afterRotation(rot,newPattern);
		if(ans == 5) return 5;
		if(check(pattern,newPattern)){
			return 6;
		}
		return 7;
	}

	private int afterRotation(String[] rot, String[] newPattern) {
		// TODO Auto-generated method stub
		String[] one = ninety(rot);
		if(check(one,newPattern)){
			return 5;
		}
		String[] two = ninety(one);
		if(check(two,newPattern)){
			return 5;
		}
		String[] three = ninety(two);
		if(check(three,newPattern)){
			return 5;
		}
		return 0;
	}

	private String[] rotate(String[] pattern) {
		// TODO Auto-generated method stub
		int len = pattern.length;
		String[] res = new String[len];
		char[] a = new char[len];
		
		for(int i = 0;  i< len; i++){
			for(int k = 0, l = len-1; l >= 0; k++,l--){
				a[k] = pattern[i].charAt(l);
			}
			res[i] = String.valueOf(a);
//			System.out.println(res[i]);
		}
		return res;
	}

	private boolean check(String[] one, String[] newPattern) {
		// TODO Auto-generated method stub
		
		int len = one.length;
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				if(one[i].charAt(j) != newPattern[i].charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	private String[] ninety(String[] pattern) {
		// TODO Auto-generated method stub
		int len = pattern.length;
		String[] str = new String[len];
		char[] a = new char[len];
		
		for(int k = 0,i = 0; k < len; k++,i++){
			for(int l = len-1, j = 0; l >= 0; l--, j++){
//				System.out.print(pattern[l].charAt(k));
				a[j] = pattern[l].charAt(k);
			}
			str[i] = String.valueOf(a);
//			System.out.println(" " + str[i]);
//			System.out.println();
		}
		return str;
	}

	

}
