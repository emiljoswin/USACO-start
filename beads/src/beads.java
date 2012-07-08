 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.FileNotFoundException;
 import java.io.FileReader;
 import java.io.FileWriter;
 import java.io.PrintWriter;

  /*
   ID: ejoswin2
   LANG: JAVA
   TASK: beads
  */

   /*
   * Overlooked what happens if the first string after split is a white.
   * Need to lookup until a non white is seen when moving right and left
   * Then we need to compare the colour. =)
   * Good experience 
   */




public class beads {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new beads().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("beads.in"));
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		
		int count = Integer.parseInt(bin.readLine());
		String beads = bin.readLine();
		int ans = compute(beads);

		pout.println(ans);
		pout.close();
	}

	private int compute(String beads) {
		// TODO Auto-generated method stub
		int length = beads.length();
		int maxbeads = 0;
		for(int i = 0; i < length; i++){
			int left = 0;
			int right = 0;
			left = computeLeft(beads,i);
			if(left == length){ maxbeads = left; break;}
			right = computeRigtht(beads,i);
			if(right == length){ maxbeads = right; break;}
			if((left+right) > maxbeads) maxbeads = left+right;
			if(maxbeads == length) break;
			

		}			
		return maxbeads;
	}

	private int computeLeft(String beads, int i) {
		// TODO Auto-generated method stub
		int l = beads.length();

		int j = i;
		int count = 0;
		char ch = beads.charAt(i);
		for(; j >=0; j--){
			if(ch == 'w'){//Didnt notice this kind of case before
				ch = beads.charAt(j);
				count++;
			}
			else if(beads.charAt(j) == ch || beads.charAt(j)== 'w'){
				count++;
			}
			else break;
		}
		if(j < 0) j = l-1;
		for(; j > i; j--){
			if(beads.charAt(j) == ch || beads.charAt(j)== 'w'){
				count++;
			}
			else break;
		}
		
		return count;
	}

	private int computeRigtht(String beads, int i) {
		// TODO Auto-generated method stub
		int l = beads.length();
		int j = 0;
		if(i == l-1) j = 0;
		else j = i+1;
		int k = j;
		int count = 0;
		int ch = beads.charAt(j);
		for(; j <l; j++){
			if(ch == 'w'){
				ch = beads.charAt(j);
				count++;
			}
			else if(beads.charAt(j)== ch || beads.charAt(j)=='w'){
				count++;
			}
			else break;
		}
		if(j == l) j = 0;
		for(; j < k-1; j++){
			if(beads.charAt(j) == ch || beads.charAt(j)== 'w'){
				count++;
			}
			else break;
		}
		
		
		return count;
	}

}
