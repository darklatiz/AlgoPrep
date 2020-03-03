package mx.com.geekflu.algo.prep;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetNames {
	
	/*
5
john tom
john mary
john tom
mary anna
mary anna


2
a bc
ab c
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		String[] pair_left = new String[t];
		String[] pair_right = new String[t];

		for (int i = 0; i < t; i++) {
			pair_left[i] = s.next();
			pair_right[i] = s.next();
		}

//Write your code here
		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < t; i++) {
			hs.add(pair_left[i] + " " + pair_right[i]);
			System.out.println(hs.size());
		}
	}
}
