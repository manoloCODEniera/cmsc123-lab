class LinkedListIterator<E> implements Iterator<E>{
 
  LinkedList list;
  Node<E> current;
  int cursor;
  
  public LinkedListIterator(LinkedList list){
    
    this.list = list;
    cursor = 0;
    current = list.head;
  }
  
  public boolean hasNext(){
    return (current != null);
  }
  
  public E next() {
      if(!(hasNext()))
        return null;
      
      E item = current.data;
      current = current.next;
      return item;
    }
  
}


