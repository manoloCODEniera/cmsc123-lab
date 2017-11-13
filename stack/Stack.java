

class Stack<E> {
  
  
  LinkedList<E> link;
  
  public Stack() {
    link = new LinkedList<>();
  
  }
  

  public void push(E item) {
    int index = link.size();
    
    link.add(item, index);
  }
  

  public E pop() {
    int index = link.size() - 1;
   
    return link.remove(index);
  }
  

  public E peek() {
    
    
    if(isEmpty()) {
      // TODO;
      return null;
    }
    int index = link.size() - 1;
    return link.getData(index);
  }
  
  
  
  public boolean isEmpty() {
    return (link.size() == 0);
  }

  public int size() {
    return link.size();
  }
}