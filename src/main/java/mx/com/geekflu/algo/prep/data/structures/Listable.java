package mx.com.geekflu.algo.prep.data.structures;

public interface Listable<T> {
	
	void insert(T data);
	T search(T data);
	boolean remove(T data);
	int size();
	void print();
}
