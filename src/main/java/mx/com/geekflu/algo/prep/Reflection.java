package mx.com.geekflu.algo.prep;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Reflection {

	public static void main(String[] args) {
		Class student = Student.class;
		Method[] methods = student.getMethods();

		ArrayList<String> methodList = new ArrayList<>();
		for (Method m : methods) {
			methodList.add(m.getName());
		}
		Collections.sort(methodList);
		for (String name : methodList) {
			System.out.println(name);
		}
		
		BigInteger bi = new BigInteger("4901971054862853523");
		bi.isProbablePrime(1);
	}

}

class Student{
    private String name;
    private String id;
    private String email;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}