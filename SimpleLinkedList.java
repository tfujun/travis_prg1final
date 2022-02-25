public class SimpleLinkedList {
	
	// Variables...
private Node head;
private Node next;
private String data;
private int listSize;


	public SimpleLinkedList() {
		// Construct an empty linked list.
		this.head = null;
		this.next = null;
	}
	
	public void add(String data) {
		// Append a node with the specified data to the end of the linked list.
		Node newNode = new Node(data);
		if(head == null){
			this.head = newNode;
			this.next = newNode;
			listSize++;
		}
		else if(this.head.getNext() == null){
			this.head.setNext(new Node(data));
			this.next = this.head.getNext();
			listSize++;
		}
		else{
			this.next.setNext(new Node(data));
			this.next = this.next.getNext();
			listSize++;
		}
		
		
	}
	
	public void add(int position, String data) {
		// Add a node with the specified data to the linked list at the specified position.
        // If the specified position is out of bounds, do nothing.\
		Node tempNode = new Node();
		Node tempNodeNext = new Node();
		if((position > listSize) || (position < 0)){
			return;
		}
		else{
			Node newNode = new Node(data);
			if(position == 0){
				newNode.setNext(this.head);
				this.head = newNode;
				listSize++;
				return;
			}
			if(position > 0){
				tempNode = head;
				for(int i = 0;i < (position-1); i++){
					tempNode = tempNode.getNext();
				}
				newNode.setNext(tempNode.getNext());
				tempNode.setNext(newNode);
				listSize++;
				return;
			}
			
			
		}
	}
	
	public String get(int position) {
		// Return the data of the node at the specified position.
		// If the specified position is out of bounds, do nothing.
		if((position >= listSize) || (position <0)){
			return null;
		}
		else{
			Node tempNode = head;
			if(position == 0){
				return tempNode.getData();
			}
			else{
				for(int i = 0; i < (position); i++){
					tempNode = tempNode.getNext();
				}
				return tempNode.getData();
			}
		}
	}
	
	public String remove(int position) {
		// Remove the node at the specified position, return what its data was.
        // If the specified position is out of bounds, return null.
		Node tempNode = new Node();
		if((position <0) || (position >= listSize)){
			return null;
		}
		else{
			if(position == 0){
				tempNode = this.head;
				this.head = this.head.getNext();
				listSize--;
				return tempNode.getData();
			}
			else if(position > 0){
				tempNode = this.head;
				for(int i = 0; i < (position-1); i++){
					tempNode = tempNode.getNext();
				}
				Node removedNode = tempNode.getNext();
				tempNode.setNext(removedNode.getNext());
				listSize--;
				return removedNode.getData();
			}
		}
		return null;
	}
	
	public String set(int position, String data) {
		// Change the data in the node at the specified position to the specified data, return what its data was.
        // If the specified position is out of bounds, return null.
		Node tempNode = this.head;

		if((position <0) || (position >= listSize)){
			return null;
		}
		else{
			Node newNode = new Node(data);
			if(position == 0){
				Node returnNode = head;
				Node tempNext = head.getNext();
				head = newNode;
				head.setNext(tempNext);
				return returnNode.getData();
			}
			else if(position > 0){
				for(int i = 0; i < (position-1); i++){
					tempNode = tempNode.getNext();
				}
				Node holder = tempNode.getNext();
				Node tempNext = holder.getNext();
				tempNode.setNext(newNode);
				newNode.setNext(tempNext);
				
				
				return holder.getData();
			}
		}
		return "hello";
	}
	
	public int size() {
		// Return the number of elements in the linked list.
		return listSize;
	}
	
	public boolean isEmpty() {
		// Is the linked list empty?
		if(head == null){
			return true;
		}
		else{
			return false;
		}
	}
}

