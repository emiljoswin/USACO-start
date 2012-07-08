import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*
ID: ejoswin2
LANG: JAVA
TASK: calfflac
 */
/*
 * the problem for which i spend the longest time of all. The issue was at first with printing back the original string.
 * Then there was TLE. I knew how to get past it, but it was not easy to code. So leaving a problem in between for now. 
 */
public class calfflac {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new calfflac().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("calfflac.in"));
		String str1 = bin.readLine();
		String str = "";
		while(str1 != null){
			str+= str1.trim() + '~';
			str1 = bin.readLine();
		}
		
		compute(str);
	}

	private void compute(String str) throws Exception {
		// TODO Auto-generated method stub
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
//		System.out.println(str);
		int maxLength = 0, l = str.length();
		
		String res = "",temp = "";
		String nextPal = Character.toString(str.charAt(0));// the first longest palidrome is the first alphabet.
		String check = "";
		char ch;
		temp = str;
		str = str.toLowerCase();
		for(int i = 0; i < l; i++){
			ch = str.charAt(i);
			if((ch<65 || ch>90)&&(ch<97 || ch>122))continue;
			check+=ch;
		}
		check = check.trim();
//		System.out.println(check);

//		System.out.println(check);
		int k = 0;
		String ans = "";
		int t = 0;
		int localmax = 0;
//		for(int i = 0; i < check.length()-1; i++){
//			if(check.charAt(i) == check.charAt(i+1)){
////				System.out.println(check.charAt(i));
//				localmax++;
//				continue;
//			}
//			if(localmax > maxLength){
//				maxLength = localmax;
//			}
//			localmax = 0;
//
//		}
		
//		System.out.println(check.length() + " " +  str.length());
//		System.out.println(check);
//		System.out.println(str);
		maxLength = 0;//maxlength++
//		System.out.println(maxLength);
		int i = 0;
		for(k = 0, i = 0;i < l; i++){
			ch = str.charAt(i);
			if((ch<65 || ch>90)&&(ch<97 || ch>122)){
//				System.out.println(ch + " " + i);
				continue;
			}
			
			String str2 = getNexttPal(check, k, maxLength);
//			if(str.charAt(i)!=check.charAt(k)){
//				System.out.println("difference " + str.charAt(i) + " " + i + check.charAt(k) + " " + k);
//			}
			k++;
			if(str2 == null){
				continue;
			}
			
//			System.out.println(str2);
//			System.out.println(str2.length());
//			pout.println(str2);
//			pout.println(str2.length());
			
			if(str2.length() > maxLength){
				maxLength = str2.length();
//				System.out.println(" Max " + maxLength);
				res = map(temp,i,maxLength);
			}
			
		}
		pout.println(maxLength);
		pout.println(res);
		pout.close();
	}
	private String map(String temp, int i, int maxLength) {
		// TODO Auto-generated method stub
//			System.out.println("map");
//			System.out.println(temp);
			
		String ret = "";
		int left = 0, right = 0;
		if(maxLength%2==0){
			left = maxLength/2;
			right =maxLength/2-1;
		}else{
			left = maxLength/2;
			right = maxLength/2;
		}
		
		int count = 0;
		char ch;
		for(int j = i-1; left>0;j--,count++){
			ch = temp.charAt(j);
			if((ch<65 || ch>90)&&(ch<97 || ch>122))continue;
			left--;
		}
		for(int j = i-count; j < i; j++){
		ch = temp.charAt(j);
		if(ch == '~'){
			ret+='\n';
			continue;
		}
		ret += Character.toString(ch);
		}
		
		for(int j1 = i; right>=0; j1++){
			ch = temp.charAt(j1);
			if(ch == '~'){
				ret+='\n';
				continue;
			}
			ret += Character.toString(ch);

			if((ch<65 || ch>90)&&(ch<97 || ch>122))continue;
			right--;
			
		}
//		System.out.println(ret);
		return ret;
	}

	private String getNexttPal(String str, int i, int maxLength) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(str + " " + i);
//		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("check.out")));

		int a = maxLength;
//		maxLength++;
//		System.out.println("maxlength " + maxLength);
		int left = 0, right = 0, l = str.length();
		String res = "";
		while(true){
//			System.out.println("res" + res.length());
//			System.out.println(left + right);
			if(maxLength%2 == 1){
				left = i-maxLength/2;
				right = i + maxLength/2 + 1;
				if(left < 0 || right > l)break;
				String next = str.substring(left, right);
//				pout.println(next);
				if(isPal(next)){
					res = next;
				}
				maxLength++;
			}
			else{
				left = i - maxLength/2;
				right = i + maxLength/2;
				if(left < 0 || right > l)break;
				String next = str.substring(left, right);
				if(isPal(next)){
					res = next;
				}
				maxLength++;
			}
			
		}
//		pout.close();
//		System.out.println("res " +res);
//		System.out.println(res + " " + (maxLength-1) + " " + i);
		if(res.length()<=a) return null;
		return res;
	}

	private boolean isPal(String next) {
		// TODO Auto-generated method stub
		int l = next.length();
		for(int i = 0; i < l/2; i++){
			if(next.charAt(i)!= next.charAt(l-i-1)){
				return false;
			}
		}
		return true;
	}

}
