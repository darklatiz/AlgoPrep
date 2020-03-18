package mx.com.geekflu.algo.prep.data.structures;

public class LinkedList<T extends Comparable<T>> implements Listable<T> {
	private Node<T> head;
	private int size;
	
	public LinkedList() {
	}
	
	public LinkedList(Node<T> head) {
		this.head = head;
	}
	
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
		
		Listable<Integer> list1 = new LinkedList<>();
		Listable<Integer> list2 = new LinkedList<>();
		list1.insert(-13);
		list1.insert(-1);
		list1.insert(2);
		list1.insert(100);
		
		list2.insert(-12);
		list2.insert(8);
		list2.insert(12);
		list2.insert(90);
		list2.insert(121);
		
		Listable<Integer> merged = list1.merge(list1.head(), list2.head());
		System.out.println("");
		merged.print();
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

	@Override
	public Node<T> head() {
		return this.head;
	}

	@Override
	public Listable<T> merge(Node<T> list1, Node<T> list2) {
		Node<Integer> fake = new Node<>(100);
		Node<T> last = (Node<T>) fake;
		
		while(list1 != null && list2 != null) {
			if(list1.getData().compareTo(list2.getData()) < 0) {
				last.setNext(list1);
				last = list1;
				list1 = list1.getNext();
			}else {
				last.setNext(list2);
				last = list2;
				list2 = list2.getNext();
			}
		}
		
		if(list1 != null) {
			last.setNext(list1);
		}
		if(list2 != null) {
			last.setNext(list2);
		}
		Listable<T> nl = new LinkedList<>((Node<T>) fake.getNext());
		
		return nl;
	}
	
	

}
