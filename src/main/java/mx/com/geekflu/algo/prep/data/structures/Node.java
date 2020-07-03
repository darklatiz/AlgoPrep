package mx.com.geekflu.algo.prep.data.structures;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Node<T> {
	private T data;
	private Node<T> next;
	public Node(T data) {
		super();
		this.data = data;
	}
}
