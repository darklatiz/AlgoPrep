package mx.com.geekflu.algo.prep.recursion;

import java.math.BigInteger;
import java.util.HashMap;

public class Recursion {
	
	private HashMap<Integer, BigInteger> FIBS_CALCULATED = new HashMap<>(); 
	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger ONE = new BigInteger("1");
	public Recursion() {
	}
	
	public BigInteger fibonacci(int n) {
		
		if(FIBS_CALCULATED.containsKey(n)) {
			return FIBS_CALCULATED.get(n);
		}
		
		BigInteger value = BigInteger.valueOf(0);
		
		if(n < 0) {
			value = ZERO;
		}else if(n == 1 || n == 2) {
			value = ONE;
		}else {
			value = fibonacci(n - 1).add(fibonacci(n - 2));
		}
		
		FIBS_CALCULATED.put(n, value);
		return value;
	}
	
	
	public static void main(String[] args) {
		Recursion r =new Recursion();
		for(int i = 1; i < 50; i++ ) {
			System.out.println("Fibnonacci(" + i + "):  "+ r.fibonacci(i));
//			System.out.println(r.fibonacci(i+1).divide(r.fibonacci(i)));
		}
	}

}
