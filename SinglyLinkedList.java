package edu.cmu.andrew.mssahu;

public class SinglyLinkedList {
	private ObjectNode head_ptr;
	private ObjectNode tail_ptr;
	private ObjectNode iter;
	private int countNodes;

	public static void main(String[] args) {

		SinglyLinkedList s = new SinglyLinkedList();
		s.addAtFrontNode("c");
		s.addAtEndNode("x");
		s.addAtFrontNode("b");
		s.addAtEndNode("y");
		s.addAtFrontNode("a");
		s.addAtEndNode("z");
		s.reset();
		System.out.println("The String is: ");
		while (s.hasNext()) {
			System.out.print(s.next());
		}
		System.out.println();
		System.out.println("Number of nodes is: ");
		System.out.println(s.countNodes());
		System.out.println("The object at position 3 (String starts from position 0: ");
		Object check = s.getObjectAt(3);
		System.out.println(check.toString());

	}
	
	/*	Constructor Method to initialise the list
	 *    Big-theta value =(1),where n=length of the list 
	 */

	public SinglyLinkedList() {
		head_ptr = null;
		tail_ptr = null;
		countNodes = 0;
		iter = null;
	}
	
	/*	Method to add a node at the tail of the list
	 *    Big-theta value =(1),where n=length of the list 
	 */

	public void addAtEndNode(Object data) {
		ObjectNode head = new ObjectNode(data, null);
		countNodes++;
		if (head_ptr == null) {
			head_ptr = head;
			tail_ptr = head_ptr;
		}

		else {
			tail_ptr.setLink(head);
			tail_ptr = head;
		}
	}
	
	/*	Method to add a node at the front of the list
	 *    Big-theta value =(1),where n=length of the list 
	 */

	public void addAtFrontNode(Object data) {
		ObjectNode head = new ObjectNode(data, null);
		countNodes++;
		if (head_ptr == null) {
			head_ptr = head;
			tail_ptr = head_ptr;
		} else {
			head.setLink(head_ptr);
			head_ptr = head;
		}
	}

	/*	Overridden Method toString to display the list
	 *    Big-theta value =(n),where n=length of the list 
	 */
	public String toString() {
		ObjectNode cursor = head_ptr;
		String display = "";
		for (cursor = head_ptr.link; cursor != null; cursor = cursor.link) {
			display = cursor.data.toString();
			System.out.print(display);
		}
		return display;
	}

	/*	Method to get the object at a particular position of the node
	 *    Big-theta value =(n),where n=position
	 */
	public Object getObjectAt(int i) {
		
		ObjectNode o = null;
		int count = 0;
		if (i < countNodes()) {
			o = head_ptr;
			if (i == 0) {
				return o.getData();
			} else {
				while (count != i) {
					o = o.link;
					count++;
				}
			}
		}
		return o.getData();
	}

	/*	Method to set the iterator at the head pointer of the list
	 *    Big-theta value =(1) 
	 */
	public void reset() {
		iter = head_ptr;
	}

	/*	Returns the boolean value based on whether the next node exists
	 *    Big-theta value =(n) 
	 */
	public boolean hasNext() {
		boolean b = iter != null;
		return b;
	}

	/*
	 * Method to return the Object of the next node
	 */
	public Object next() {
		Object nextNodeData;

		if (iter == null)
			iter = head_ptr;

		nextNodeData = iter.data;
		iter = iter.link;
		return nextNodeData;

	}

	/*
	 * Method that returns the size of the list
	 */
	public int countNodes() {
		return countNodes;
	}

	/*
	 * Method that returns the last node of the list
	 */
	public ObjectNode getLast() {
		return tail_ptr;
	}
}
