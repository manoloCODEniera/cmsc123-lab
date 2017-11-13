public class LinkedList<E> implements Collection{
  
  
  Node head = null;
  int size = 0;
  
  LinkedList(){}
  
  public void add(E item, int index){
    
    Node newNode = new Node(item, head);
    
    // index out of bounds
    
    if(index > size)
      return;
    
    // empty List or index 0

    if(this.size == 0 || index == 0){
      this.head = newNode;
      this.size++;
      return;
    }
    
    // standard case
    Node current = this.head;
    Node previous = null;
    for(int i = 0; i < index; i++) {
      previous = current;
      current = current.next;
      if(current == null) {
        break;
      } 
    }
    
    newNode.next = current;
    previous.next = newNode;
    size++;
    return;
    
  }
  
  public E remove(int index){
  
    // empty list
    
    if(size == 0)
      return null;
    
    // default case
    
    Node current = this.head;
    Node previous = null;
    for(int i = 0; i < index; i++) {
      previous = current;
      current = current.next;
      if(current == null) {
        break;
      } 
    }
     E item = current.data;
     previous.next = current.next;
     current.next = null;
     this.size--;
     return item;
  }
  
  public E getData(int index) {
    Node current = this.head;
    
    
    
    for(int i = 0; i < index; i++) {
      current = current.next;
      if(current == null) {
        break;
      } 
    }
    E item = current.data;
    return item;
  }
    
  
  public int size(){
    return this.size;
  }
  
  public Iterator iterator(){
    
    return new LinkedListIterator(this);
  }
  
  
  



class Node {
  E data;
  Node next;
  
  Node(E data, Node next) {
    this.data = data;
    this.next = next;
  }
  
  public String toString(){
     return this.data.toString();
  }
  
}}
