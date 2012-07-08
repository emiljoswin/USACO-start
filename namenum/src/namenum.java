/*
ID: ejoswin2
LANG: JAVA
TASK: namenum
 */

/* Two methods to solve the problem. generate all possible words from the number and search through 5000 words. or select the words and then
 * see if the word satisfies the number. Sticked with the latter. Took a really long time to code (3) hours. Had an error in the program
 * sice I used 'c' instead of 'C'. Anyways problems like this will improve your implementation skill a lot. =) Its my seventh problem in 4 days.
 * Didnt do any program yesterday. Skills are improving but there is a really lot more to go. Anyway I am happy with my progress.
 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;


public class namenum {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new namenum().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("namenum.in"));	
		BufferedReader bdict = new BufferedReader(new FileReader("dict.txt"));

		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		String str  = "";
		String[][] a = new String[8][1000]; 
		int i = 0,j = 0,k = 0,l = 0,m = 0,n = 0,o = 0,p = 0,q = 0;
		char ch;
		while((str = bdict.readLine())!=null){
//			System.out.println(str);
			str = str.trim();
			ch = str.charAt(0);
//			System.out.println(ch);
			if(ch == 'A'|| ch == 'B' || ch == 'C'){
				a[0][i] = str;
				i++;				
				continue;
			}
			if(ch == 'D' || ch == 'E' || ch == 'F'){
				a[1][j] = str.trim();
				j++;
				continue;
			}
			if(ch == 'G' || ch == 'H' || ch == 'I'){
				a[2][k] = str.trim();
				k++;
				continue;
			}
			if(ch == 'J' || ch == 'K' || ch == 'L'){
				a[3][l] = str.trim();
				l++;
				continue;
			}
			if(ch == 'M' || ch == 'N' || ch == 'O'){
				a[4][m] = str.trim();
				m++;
				continue;
			}
			if(ch == 'P' || ch == 'R' || ch == 'S'){
				a[5][n] = str.trim();
				n++;
				continue;
			}
			if(ch == 'T' || ch == 'U' || ch == 'V'){
				a[6][o] = str.trim();
				o++;
				continue;
			}
			if(ch == 'W' || ch == 'X' || ch == 'Y'){
				a[7][p] = str.trim();
				p++;
				continue;
			}
			
//			pout.println(str.trim());
		}
//		System.out.println(Arrays.toString(a[0]));
//		System.out.println(i + " " + j + " " + k + " " + l+ " " + m + " " + n + " " + o + " " + p );
		
		String num = bin.readLine();
		String ans =  compute(num,a);
////		
//		for(int b = 0; b < ans.length; b++){
//			System.out.println(ans[b]);
//		}
		String res[] = ans.trim().split(" ");
//		System.out.println(ans);
		for(int d = 0; d < res.length; d++){
			pout.println(res[d]);
		}
		pout.close();
	}

	private String compute(String num, String[][] a) {
		// TODO Auto-generated method stub
		int[] n = new int[num.length()];
		for(int i = 0; i < num.length(); i++){
			n[i] = num.charAt(i)- 48;
		}
//		System.out.println(Arrays.toString(n));
//		
		String res = "";
		int k = 0;
		int l = n.length;
		boolean none = true;
//		System.out.println(l);
		for(int i = 0; a[n[0]-2][i] != null; i++){
//			System.out.println(a[n[0]-2][i]);

			if(a[n[0]-2][i].length() == l){
//				System.out.println(a[n[0]-2][i].length());
//				System.out.println(a[n[0]-2][i]);
				if(check(a[n[0]-2][i],n))
				{
//					System.out.println(a[n[0]-2][i]);
					res += " " +  a[n[0]-2][i];
					none = false;
				}
			}			
		}		
		if(none) return "NONE";
		return res;
	}

	private boolean check(String string, int[] n) {
		// TODO Auto-generated method stub

		String[] alpha = new String[n.length];
//		System.out.println()
		for(int i = 1; i < n.length ; i++){
			if(n[i] == 2){
				alpha[i] = "ABC";
			}
			else if(n[i] == 3){
				alpha[i] ="DEF";
			}
			else if(n[i] == 4){
				alpha[i] = "GHI";
			}
			else if(n[i] == 5){
				alpha[i] = "JKL";
			}
			else if(n[i] == 6){
				alpha[i] = "MNO";
			}
			else if(n[i] == 7){
				alpha[i] = "PRS";
			}
			else if(n[i] == 8){
				alpha[i] = "TUV";
			}
			else if(n[i] == 9){
				alpha[i] = "WXY";
			}
		}
//		System.out.println(Arrays.toString(alpha));		
//		System.out.println("strig" + string.length());

		boolean flag = true;
		for(int i = 1,j = 1; i < string.length(); i++,j++){
//			System.out.println(string.charAt(i));
//			System.out.println(n[j]);
//			System.out.println(alpha[j]);
			if(string.charAt(i) != alpha[j].charAt(0) && string.charAt(i) != alpha[j].charAt(1) && 
					string.charAt(i) != alpha[j].charAt(2)){
				flag = false;
				break;
			}
		}
		return flag;
	}

}
