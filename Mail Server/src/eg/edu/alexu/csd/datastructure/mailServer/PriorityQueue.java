package eg.edu.alexu.csd.datastructure.mailServer;

//import eg.edu.alexu.csd.datastructure.linkedList.csX22.Double_Linked_list;

public class PriorityQueue implements IPriorityQueue{
	
	private class Point{
		Object item;
		int key;
		Point(Object item, int key){
			this.item=item;
			this.key=key;
		}
	}
	private class Node {
		Point element;
		Node next;
		Node (Point element){
			this.element=element;
			this.next=null;
		}
	}
	private Node head/*,tail*/;
	private int size ;
	public PriorityQueue () {
		this.head=null;
		//this.tail=null;
		this.size=0;
	}
	
	@Override
	public void insert(Object item, int key) {
		Node extra = new Node (new Point(item,key));
		if (isEmpty()) {
			head = extra ;
			//tail=extra;
			//tail.next=null;
		}
		else {
			Node temp=head;
			Node pointer=null;
			while (temp!=null&&key>=temp.element.key) {
				pointer=temp;
				temp = temp.next;
			}
			if (pointer==null) this.head=extra;
			else
			pointer.next=extra;
			extra.next=temp;
			//if (temp==null) tail=tail.next;
		}
		this.size++;
	}

	@Override
	public Object removeMin() {
		if (isEmpty())throw new RuntimeException("the queue is empty");
		Point temp = this.head.element;
		this.head=this.head.next;
		this.size--;
		return temp.item;
	}

	@Override
	public Object min() {
		if (isEmpty())throw new RuntimeException("the queue is empty");
		return this.head.element.item;
	}

	@Override
	public boolean isEmpty() {
		return this.head==null;
	}

	@Override
	public int size() {
		return this.size;
	}

	/*Double_Linked_list d = new Double_Linked_list();
	private class Point {
		Object item;
		int key;
		Point(Object item, int key){
			this.item=item;
			this.key=key;
		}
	}
	
	@Override
	public void insert(Object item, int key) {
		Point extra = new Point (item,key);
		if (isEmpty()) {
			d.add(extra);
		}
		else {
			int i=0;
			Point temp = (Point) d.get(i);
			while (i<d.size()&&key<temp.key) {
				i++;
				 temp = (Point) d.get(i);
			}
			d.add(i,extra);
		}
	}

	@Override
	public Object removeMin() {
		if (isEmpty()) {
			throw new RuntimeException("the queue is empty");
		}
		Point temp = (Point) d.get(size()-1);
		d.remove(size()-1);
		return temp.item;
	}

	@Override
	public Object min() {
		Point temp = (Point) d.get(size()-1);
		return temp.item;
	}

	@Override
	public boolean isEmpty() {
		return d.size()==0;
	}

	@Override
	public int size() {
		return d.size();
	}*/

}
