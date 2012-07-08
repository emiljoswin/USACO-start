import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class calfflacpetr {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new calfflacpetr().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("in"));
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
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("out")));

//		System.out.println(str);
		int l = str.length();
		int j =  0;
		int maxlength = 0;
		int startindex = 0,endindex = 0;
		str = str.toLowerCase();
		String check = "";
		char ch;
		for(int i = 0; i < l; i++){
			ch = str.charAt(i);
			if((ch<65 || ch>90)&&(ch<97 || ch>122))continue;
			check+=ch;
		}
		check = check.trim();
		int k = 0;
		for(int i = 0; i < l-1; i++){
			ch = str.charAt(i);
			if((ch<65 || ch>90)&&(ch<97 || ch>122))continue;
			
			if(check.charAt(k) == check.charAt(k+1)){
				
				for(j = 0; ; j++){
					if((k-j-1< 0) ||  (k + j + 2) >=l) break;
					if(check.charAt(k-j-1) != check.charAt(k+j+2)){
						break;
					}
					if(((j+1)*2 + 2) > maxlength){
//						System.out.print(str.substring(i-j-1, i+j+3) + " " );
//						pout.print(str.substring(i-j-1, i+j+3) + " " );
						
//						maxlength = (j+1)*2+2;
//						System.out.print ( "-" + maxlength + " ");
//						pout.println ( "-" + maxlength + " ");
						startindex = k-j-1;
						endindex = k+j+3;
						System.out.println(k + " " + check.charAt(k) + " " + maxlength);
					}
				}
			}
			else{
			for(j = 0; ; j++){
				if((k-j-1< 0) ||  (k + j + 1) >=l) break;
				if(check.charAt(k-j-1) !=  check.charAt(k+j+1)){
					break;
				}
				if(((j+1)*2 + 1) > maxlength){
//					System.out.print(str.substring(i-j-1, i+j+2) + " " );
//					pout.print(str.substring(i-j-1, i+j+2) + " " );

					maxlength = (j+1)*2+1;
//					System.out.print( "-" + maxlength + " ");
//					pout.println( "-" + maxlength + " ");

					startindex = k-j-1;
					endindex = k+j+2;
					System.out.println(k + " " + check.charAt(k) + " " + maxlength);

				}
			}
			k++;
			}
//			System.out.println();
		}
		System.out.println(maxlength);
		pout.println(maxlength);
		pout.print(str.substring(startindex, endindex) + " " );

		pout.close();
	}

}
