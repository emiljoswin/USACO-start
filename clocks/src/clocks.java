import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
/* 
 ID: ejoswin2
 LANG: JAVA
 TASK: clocks
 */

public class clocks {

	/**
	 * @param args
	 * @throws Exception 
	 */
	int[] in = new int[9];
    ArrayList<Integer> al = new ArrayList<Integer>();
    int[] res = new int[20];
    int resi = -1;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new clocks().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("clocks.in"));
		int j = 0;
		for(int i = 0; i < 3; i++){
			String str = bin.readLine().trim();
//			System.out.println(str);
			String[] s = str.split(" ");
			in[j++] = Integer.parseInt(s[0]);
			in[j++] = Integer.parseInt(s[1]);
			in[j++] = Integer.parseInt(s[2]);
		}
		for(int i = 0; i < 9; i++){
			in[i] = (12-in[i])/3;
		}
		System.out.println(Arrays.toString(in));
//		                  a,b,c,d,e,f,g,h,i
		int[][] moves = {{1,1,0,1,1,0,0,0,0}, 
						 {1,1,1,0,0,0,0,0,0},
						 {0,1,1,0,1,1,0,0,0},
						 {1,0,0,1,0,0,1,0,0},
						 {0,1,0,1,1,1,0,1,0},
						 {0,0,1,0,0,1,0,0,1},
						 {0,0,0,1,1,0,1,1,0},
						 {0,0,0,0,0,0,1,1,1},
						 {0,0,0,0,1,1,0,1,1}
		                  };
						
		compute(moves);
//		System.out.println(Arrays.toString(in));
		
	}

	private void compute(int[][] moves) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(res));
		if(allDone()){
//			System.out.println("c/omplete");
			printRes();
			System.exit(0);
		}

		for(int i = 0;i < 9; i++){
			boolean check = applyMove(i,moves);
			System.out.println(Arrays.toString(in) + " " + i );
			System.out.println("adding " + i);
			res[++resi] = i;
			if(valid()){
//				System.out.println("valid");
				compute(moves);
			}
//			else{
			{
//				System.out.print("invalid ");
				if(resi>=0){
					int element = res[resi];
					System.out.println("removing" + element);
					removeMove(element,moves);
					resi--;
				}
			}

		}
	}

	private void printRes() throws IOException {
		// TODO Auto-generated method stub
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("clocks.out")));
		pout.print(res[0]+1);
		for(int i = 1; res[i]!= 0; i++){
			pout.print(" " +(res[i]+1));
		}
		pout.println();
		pout.close();
	}

	private void removeMove(int element, int[][] moves) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 9;i++){
			in[i] = in[i]+ moves[element][i];
		}
	}

	private boolean valid() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 9; i++){
			if(in[i]<0) return false;
		}
		return true;
	}

	private boolean applyMove(int i, int[][] moves) {
		// TODO Auto-generated method stub
		int[] temp = in;
		for(int j = 0; j < 9; j++){
			temp[j] = temp[j] - moves[i][j];
//			if(temp[j] < 0){
//				return false;
//			}
		}
		in = temp;
		return true;
	}

	private boolean allDone() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 9; i++){
			if(in[i]!= 0){
				return false;
			}
		}
		return true;
	}

}
