/*
ID: ejoswin2
LANG: JAVA
TASK: test
*/

import java.io.*;
import java.util.*;

class test{
    public static void main(String[] args)throws Exception{
	BufferedReader bin = new BufferedReader(new FileReader("test.in"));
	PrintWriter pout = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));

	StringTokenizer token = new StringTokenizer(bin.readLine());
	int n = Integer.parseInt(token.nextToken());
	int m = Integer.parseInt(token.nextToken());
	pout.println(m+n);
	pout.close();
	System.exit(0);
    }
}