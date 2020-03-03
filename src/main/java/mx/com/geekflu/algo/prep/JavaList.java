package mx.com.geekflu.algo.prep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> l = new ArrayList<>();
		int j = 0;
        int i = scan.nextInt();
        while(j++ < i) {
        	l.add(scan.nextInt());
        }
        j = 0;
        int numQ = scan.nextInt();
        //it is needed
        scan.nextLine();
        while(j++ < numQ) {
        	String action = scan.nextLine();
        	if(action.equalsIgnoreCase("")) action = scan.nextLine();
        	int pos = scan.nextInt();
        	if(action.equalsIgnoreCase("insert")) {
        		int val = scan.nextInt();
        		l.add(pos, val);
        	}else if(action.equalsIgnoreCase("Delete")) {
        		l.remove(pos);
        	}
        }
        for(Integer in : l) {
        	System.out.print(in);
        	System.out.print(" ");
        }
	}
	
}
