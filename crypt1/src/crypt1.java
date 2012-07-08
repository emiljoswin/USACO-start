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
TASK: crypt1
*/

public class crypt1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new crypt1().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		int count = Integer.parseInt(bin.readLine().trim());
		String string = bin.readLine().trim();
		String[] str = string.split(" ");
		int numbers[] = new int[10];
		int n;
		for(int i = 0; i < count; i++){
			n = Integer.parseInt(str[i]);
			numbers[n] = n;
		}
//		System.out.println(Arrays.toString(numbers));
		int res = compute(numbers);
//		System.out.println(res);
		pout.println(res);
		pout.close();
	}

	private int compute(int[] numbers) {
		// TODO Auto-generated method stub
		int temp = 0, res = 0, jj, t,count = 0;
		for(int i = 111; i <= 999; i++){
			for(int j = 11; j <= 99; j++){
				if(check(i,numbers) && check(j,numbers)){
					temp = i*j;
					if(temp > 9999) continue;
//					count++;
//					System.out.println(count + " " + temp + " " + i + " " + j);
					jj = j;
					if(check(temp,numbers)){//check product
//						count++;
//						System.out.println(count + " " + temp + " " + i + " " + j);
						t = i*(jj%10);
						if((t <= 999) && check(t,numbers)){//check first partial product
//							count++;
//							System.out.println(count + " " + temp + " " + i + " " + j);
							jj/=10;
							t = i * (jj %10);
							if((t <= 999) && check(t , numbers)){
//								count++;
//								System.out.println(count + " " + temp + " " + i + " " + j);
								res++;
//								System.out.println(temp + " " + i + " " + j);
							}
//							else{
//								System.out.println(temp + " " + t );
//								
//							}
						}
//						else{
//							System.out.println(temp + " " + t +" " + i + " " + (jj%10));
//							
//						}
					}
				}
			}
		}
		return res;
	}

	private boolean check(int temp, int[] numbers) {
		// TODO Auto-generated method stub
		int t = 0;
		if(temp == 0) return false;
		
		while (temp > 0){
			t = temp%10;
			temp/=10;
			if(numbers[t] == 0){
				return false;
			}
		}
		return true;
	}

}
