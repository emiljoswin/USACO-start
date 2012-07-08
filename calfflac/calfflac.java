/*
ID: ejoswin2
LANG: JAVA
TASK: calfflac  
*/
import java.util.*;
import java.io.*;

public class calfflac {
  StringBuilder originStr = new StringBuilder(20000);
  StringBuilder strList = new StringBuilder(20000);
  ArrayList<Integer> indexList = new ArrayList<Integer>(20000);
  int startIndex;
  int lastIndex;
  int max;
 
  public calfflac() throws IOException {
    Scanner in = new Scanner(new File("calfflac.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
   
    while(in.hasNext()) {
      originStr.append(in.nextLine());
      originStr.append('\n');
    }
   
    int i;
    char c;
    for(i=0 ; i<originStr.length() ; i++) {
      c = originStr.charAt(i);
      if(c>='A' && c<='Z') {
        strList.append((char)(c+32));
        indexList.add(i);
      }
      if(c>='a' && c<='z') {
        strList.append(c);
        indexList.add(i);
      } 
    }
   
    // Find max palindrome.
    for(i=0 ; i<strList.length()-1 ; i++) {
      if(strList.charAt(i) == strList.charAt(i+1))
        calculate(i-1, i+2);
      if(i+2 < strList.length() && strList.charAt(i) == strList.charAt(i+2))
        calculate(i-1, i+3);
    }
   
    out.println(max);
    out.println(originStr.substring(indexList.get(startIndex), indexList.get(lastIndex)+1));
   
    out.close();
    System.exit(0);
  }
 
  public void calculate(int j, int k) {
    int count = 0;
   
    while(j>=0 && k<strList.length()) {
      if(strList.charAt(j) != strList.charAt(k))
        break;
      j--; k++;
    }
   
    count = k-1 - (j+1) + 1;
    if(count > max) {
      startIndex = j+1;
      lastIndex = k-1;
      max = count;
    }
  }

  public static void main(String[] args) throws IOException {
    new calfflac();
  }
}
