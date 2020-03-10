package mx.com.geekflu.algo.prep.data.structures;

public class LinkedList<T> implements Listable<T> {
	private Node<T> head;
	private int size;

	@Override
	public void insert(T data) {
		Node<T> n = new Node<>(data);
		if (head == null) {
			head = n;
		} else {
			Node<T> last = head;
			while (last.getNext() != null) {
				last = last.getNext();
			}
			last.setNext(n);
		}
		size++;
	}

	@Override
	public T search(T data) {
		return null;
	}

	@Override
	public boolean remove(T data) {
		if (head != null) {

		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.insert("gusanos");
		list.insert("anzuelo");
		list.insert("hilo");
		list.insert("botas");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.print();
		System.out.println();
		System.out.println("List size: " + list.size());
	}

	@Override
	public void print() {
		Node<T> last = this.head;
		while (last != null) {
			System.out.print(last.getData() + " ");
			last = last.getNext();
		}
	}
}
