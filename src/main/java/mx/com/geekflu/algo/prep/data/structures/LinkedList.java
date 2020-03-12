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
	public boolean remove(T data) {
		boolean deleted = false;
		if (head != null) {
			Node<T> current = head;
			Node<T> prev = head;
			while (current != null) {
				if (current.getData().equals(data)) {
					//We are on head and head has the data to be removed
					if(current == prev) {
						head = current.getNext();
					}else {
						// link to next node
						prev.setNext(current.getNext());
						// remove current node
						current.setNext(null);
					}
					current = null;
					deleted = true;
					size--;
					break;
				}
				prev = current;
				current = current.getNext();
			}
		}
		return deleted;
	}

	@Override
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		Listable<String> list = new LinkedList<>();
		list.insert("gusanos");
		list.insert("anzuelo");
		list.insert("hilo");
		list.insert("botas");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.insert("dinosaurios");
		list.print();
		System.out.println("");
		System.out.println("Reverse");
		list.printReverse();
		System.out.println("");
		System.out.println("Was dinosaurios removed from list? " +list.remove("dinosaurios"));
		System.out.println("Was dinosaurios removed from list? " +list.remove("dinosaurios"));
		System.out.println("Was dinosaurios removed from list? " +list.remove("dinosaurios"));
		System.out.println("Was dinosaurios removed from list? " +list.remove("dinosaurios"));
		list.print();
		System.out.println();
		System.out.println("List size: " + list.size());
		System.out.println("Was dinosaurios gusanos from list? " +list.remove("gusanos"));
		list.print();
		System.out.println("");
		
		System.out.println("Reverse");
		list.printReverse();
		
		
	}

	@Override
	public void print() {
		Node<T> last = this.head;
		while (last != null) {
			System.out.print(last.getData() + " ");
			last = last.getNext();
		}
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + ", size=" + size + "]";
	}

	@Override
	public void printReverse() {
		printReverse(this.head);
	}

	private void printReverse(Node<T> node) {
		if(node == null) return;
		printReverse(node.getNext());
		System.out.print(node.getData() + " ");
	}

	public Node<T> getHead() {
		return head;
	}

	@Override
	public Node<T> head() {
		return this.head;
	}
	
	

}
