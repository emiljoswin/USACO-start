import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
ID: ejoswin2
LANG: JAVA
TASK: packrec
 */
/*
 * Implementing arraylist took a lot of time. Always the entire arraylist was getting reinitialized. Was quite tiring but learned a good
 * lesson that you must always have a "new" object to enter into the arraylist. Else the arraylist gets reinintialized. 
 */
public class packrec {
	ArrayList<int[]> result = new ArrayList<int[]>();

	/**
	 * @param args
	 * @throws Exception 
	 */
	int globalMinArea = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new packrec().go();
	}

	private void go() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bin = new BufferedReader(new FileReader("packrec.in"));
		int[][] rectangle = new int[4][2];
		String[] str ;
		int count = 4;
		while(count-- > 0 ){
			str = bin.readLine().trim().split(" ");
			rectangle[count][0] = Integer.parseInt(str[0]);
			rectangle[count][1] = Integer.parseInt(str[1]);					
		}
		for(int i = 0; i < 4; i++){
//			System.out.println(Arrays.toString(rectangle[i]));	
			Arrays.sort(rectangle[i]);
		}
		fun(rectangle);
		getRequiredArea();
	}
	private void getRequiredArea() throws Exception {
		// TODO Auto-generated method stub
		PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("packrec.out")));

		int[][] R = result.toArray(new int[result.size()][3]);
		int count = 0;
		for(int i = 0; i < R.length; i++){
			if(R[i][0] == globalMinArea){
				count++;
			}
		}
		int[][] res = new int[count][3];
		for(int i = 0, j = 0; i < R.length; i++){
			if(R[i][0] == globalMinArea){
				res[j] = R[i];
				j++;
			}
		}
		for(int i = 0; i < count; i++){
			Arrays.sort(res[i],1,3);
		}
		Arrays.sort(res, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				if(a[1]> b[1]) return 1;
				else return -1;
			}
		});

//		System.out.println("final");
		int[] temp = new int[3];
		temp = res[0];
//		System.out.println(Arrays.toString(temp));
	
//		for(int i = 0; i < count;i++){
//			System.out.println(Arrays.toString(res[i]));		
//		}
		
		pout.println(temp[0]);
		pout.println(temp[1] + " " + temp[2]);
		for(int i = 0; i < count; i++){
			if(res[i][1] == temp[1] && res[i][2] == temp[2]){
				continue;
			}
			else{
				temp = res[i];
//				System.out.println(Arrays.toString(temp));
				pout.println(temp[1] + " " + temp[2]);
			}
		}
		pout.close();
	}

	private void showList(){
//		System.out.println("Printing the arraylist...");
//		System.out.println("size" + result.size());
		int[][] R = result.toArray(new int[result.size()][]);
		for(int i = 0; i < R.length; i++){
			System.out.println(Arrays.toString(R[i]));
		}		
	}
	
	private void fun(int[][] rectangle) {
		// TODO Auto-generated method stub

		int h = 0,w = 0;
		int listIndex = 0;
		int[][] rect = new int[4][2];
		int[][] rectPermut = new int[4][2];
		int[] res = new int[3];
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(i == j) continue;
				for(int k = 0; k < 4; k++){
					if(k == i || k == j) continue;
					for(int l = 0; l < 4; l++){
						if(l == k || l == i || l ==j) continue;
						rectPermut = permut(rectangle,i,j,k,l);
						for(int q = 0; q < 16; q++){//16 different type of flips for every 24 configurations
							rect = flip(rectPermut,q);
							//one
							res = new int[3];
							w = rect[i][0] + rect[j][0] + rect[k][0] + rect[l][0];
							h = max(rect[i][1],max(rect[j][1],max(rect[k][1],rect[l][1])));
							res[0] = h*w;
							res[1] = h;
							res[2] = w;
							if(res[0] <= globalMinArea) { globalMinArea = res[0];
//								System.out.println("1. "+Arrays.toString(res));
								result.add(listIndex,res);
								listIndex++;
//								showList();
//								int[][] A = result.toArray(new int[result.size()][]);
//								for(int a = 0; a < A.length; a++){
//									System.out.println(Arrays.toString(A[a]));
//								}
							}
							//two
							res = new int[3];
							w = rect[l][0]+max(max(rect[i][0],rect[j][0]),rect[k][0]);
							h = max(rect[l][1],rect[i][1]+rect[j][1]+rect[k][1]);
							res[0] = h*w;
							res[1] = h;
							res[2] = w;
							if(res[0] <= globalMinArea){ globalMinArea = res[0];
//								System.out.println("2. "+Arrays.toString(res));
								result.add(listIndex,res);
								listIndex++;
//								showList();
//								int[][] A = result.toArray(new int[result.size()][]);
//								for(int a = 0; a < A.length; a++){
//									System.out.println(Arrays.toString(A[a]));
//								}
							}
							//three
							res = new int[3];
							w = max(rect[i][0]+rect[j][0], rect[k][0]) + rect[l][0];
							h = max(rect[l][1], rect[k][1]+max(rect[i][1],rect[j][1]));
							res[0] = h*w;
							res[1] = h;
							res[2] = w;
							if((h*w) <= globalMinArea){ globalMinArea = (h*w);
//								System.out.println("3. "+Arrays.toString(res));
								result.add(listIndex,res);
								listIndex++;
//								showList();
//								int[][] A = result.toArray(new int[result.size()][]);
//								for(int a = 0; a < A.length; a++){
//									System.out.println(Arrays.toString(A[a]));
//								}

							}
//							four
							res = new int[3];
							w = rect[i][0]+rect[k][0]+max(rect[j][0],rect[l][0]);
							h = max(rect[i][1],max(rect[k][1],rect[j][1]+rect[l][1]));
							res[0] = h*w;
							res[1] = h;
							res[2] = w;
							if(res[0] <= globalMinArea) {globalMinArea = res[0];
//								System.out.println("4. "+Arrays.toString(res));
								result.add(listIndex,res);
								listIndex++;
//								showList();
//								int[][] A = result.toArray(new int[result.size()][]);
//								for(int a = 0; a < A.length; a++){
//									System.out.println(Arrays.toString(A[a]));
//								}

							}
							//five
							res = new int[3];
//							int t = 0;
//							h = max(max((rect[i][1]+rect[k][1]),(rect[i][1]+rect[l][1])),max((rect[k][1]+rect[j][1]),(rect[i][1]+rect[j][1])));
//
//							if(rect[i][0] == rect[k][0]){
//								t = rect[i][0];
//							}else{
//								if(rect[i][0] > rect[k][0]) t = rect[i][0];
//								else t = rect[k][0];
//							}
//							int u = 0;
//							if(rect[k][0] > rect[i][0]){
//								w = max(rect[k][0]+rect[l][0],rect[i][0]+rect[j][0]);
//								System.out.println("Hi" + w + " " + h);
//								if(w == 24){
//								System.out.println(rect[i][0] + " " + rect[i][1]);
//								System.out.println(rect[j][0] + " " + rect[j][1]);
//								System.out.println(rect[k][0] + " " + rect[k][1]);
//								System.out.println(rect[l][0] + " " + rect[l][1]);
//								}
//							}else{
//							if(rect[j][0] < rect[l][0]){
//								u = rect[l][0] + rect[l][0] - rect[j][0];
//							}
//							else{
//								u = rect[j][0] + rect[j][0]-rect[l][0];
//							}
//							w = t+u;
//							}
							w = max(rect[i][1]+rect[j][1],rect[k][1]+rect[l][1]);
							if(rect[i][0]>rect[j][0]){
								if(rect[k][1]>rect[i][1]){
									h = max(rect[i][0]+rect[k][0],rect[i][0]+rect[l][0]-(rect[i][0] - rect[j][0]));
								}
								else h = max(rect[i][0]+rect[k][0] , rect[i][0]+rect[l][0]);
							}
							else{
								if(rect[k][1]>rect[i][1]){
									h = max(rect[j][0]+rect[l][0], rect[j][0]+rect[k][0]);
								}
								else if(rect[k][1]+rect[l][1]>rect[i][1]){
									h = max(rect[j][0]+rect[l][0],rect[j][0]+rect[k][0]-(rect[j][0]-rect[i][0]));
								}
								else{
									h = max(rect[j][0]+rect[l][0], rect[j][0]+rect[k][0]-(rect[j][0]-rect[i][0]));
								}
							}
//							if(h*w == 36){
//								System.out.println("hi " + h + " " + w) ;
//								System.out.println(rect[i][0] + " " +rect[i][1]);
//								System.out.println(rect[j][0] + " " +rect[j][1]);
//								System.out.println(rect[k][0] + " " +rect[k][1]);
//								System.out.println(rect[l][0] + " " +rect[l][1]);
//							}
							res[0] = h*w;
							res[1] = h;
							res[2] = w;
							if(res[0] <= globalMinArea) {globalMinArea = res[0];

//								System.out.println(h + " " +w);
//								System.out.println("5. "+Arrays.toString(res));
								result.add(listIndex,res);
								listIndex++;
//								showList();
//								int[][] A = result.toArray(new int[result.size()][]);
//								for(int a = 0; a < A.length; a++){
//									System.out.println(Arrays.toString(A[a]));
//								}
							}
							//six
							res = new int[3];
							w = rect[i][0] + rect[j][0] + max(rect[k][0],rect[l][0]);
							h = max(rect[i][1],max(rect[j][1],rect[k][1]+rect[l][1]));
							res[0] = h*w;
							res[1] = h;
							res[2] = w;
							if(res[0] <= globalMinArea){ globalMinArea = res[0]; 
//								System.out.println("6. "+Arrays.toString(res));
								result.add(listIndex,res);
								listIndex++;
//								showList();
//								int[] s = result.get(3);
//								System.out.println(Arrays.toString(s));
//								int[][] A = result.toArray(new int[result.size()][]);
//								for(int a = 0; a < A.length; a++){
//									System.out.println(Arrays.toString(A[a]));
//								}
							}
						}
					}
				}
			}
		}
	}


	
	private int funOne(int i, int j) {
		// TODO Auto-generated method stub
		if(i == j) return i;
		else return i+j;
	}

	private int max(int i, int j) {
		// TODO Auto-generated method stub
		return i>j ? i:j;
	}
	
	private int[][] permut(int[][] rectangle, int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		int[][] resultRectangle = new int[4][2];
		resultRectangle[0] = rectangle[i];
		resultRectangle[1] = rectangle[j];
		resultRectangle[2] = rectangle[k];
		resultRectangle[3] = rectangle[l];
		return resultRectangle;
	}
	
	private int[][] flip(int[][] rectangle, int flipcount) {
		// TODO Auto-generated method stub
		int ha = rectangle[0][0],hb = rectangle[1][0],hc = rectangle[2][0],hd = rectangle[3][0];
		int wa = rectangle[0][1],wb = rectangle[1][1], wc = rectangle[2][1],wd = rectangle[3][1];
		if((flipcount&1) == 1){
			ha = rectangle[0][1];
			wa = rectangle[0][0];
		}
		if((flipcount&2) ==2){
			hb = rectangle[1][1];
			wb = rectangle[1][0];
		}
		if((flipcount&4) == 4){
			hc = rectangle[2][1];
			wc = rectangle[2][0];
		}
		if((flipcount&8) == 8){
			hd = rectangle[3][1];
			wd = rectangle[3][0];
		}
		int[][]rect = {{ha,wa},{hb,wb},{hc,wc},{hd,wd}};
		return rect;
	}

}

