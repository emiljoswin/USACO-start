import java.util.ArrayList;
import java.util.Arrays;


public class test {
	ArrayList<int[]> list = new ArrayList<int[]>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test().go();
	}
	private void go() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++){
			insert(i);
			show();
		}
	}
	private void show() {
		// TODO Auto-generated method stub
		System.out.println("printing..");
		int[][] A = list.toArray(new int[list.size()][]);
		for(int i = 0; i < A.length; i++){
			System.out.println(Arrays.toString(A[i]));
		}
	}
	private void insert(int i) {
		// TODO Auto-generated method stub
		int[] array = new int[3];
		array[0] = i;
		array[1] = i;
		array[2] = i;
		list.add(array);
	}

}
