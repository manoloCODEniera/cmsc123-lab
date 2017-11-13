/**
 * Auto Generated Java Class.
 */

class Queue {
  int[] array;
  int max;
  int size;
  int front;
  int rear;
 
  /* ADD YOUR CODE HERE */
  
  Queue(int max) {
    this.max = max;
    array = new int[this.max];
    size = 0;
    front = 0;
    rear = 0;
  }
  
  public void enqueue(int item) {
    if(this.size == this.max) {
      expandArray();
    }
      array[rear] = item;
      rear = (rear + 1) % max;
      size++;
  }
  
  public int dequeue() {
    int item;
    if(isEmpty()) {
      return -1;
    }
    item = array[front];
    
    
    if(front == rear){
      front = rear =-1;
    }
    if(front==size-1)
      front = 0;
    
    front = (front + 1) % this.max;
    size--;
    return item;
  }
  
  public int peek() {
    if(isEmpty()) {
      return -1;
    }
    return array[front];
  }
  
  public boolean isEmpty() {
    return (size == 0);
  }
  
  public void expandArray() {
    this.max*=2;
    int[] newArray = new int[this.max];
    for(int a = 0; a < this.size; a++){
      newArray[a] = array[front];
      front = (front + 1) % this.max;
    }
    front = 0;
    rear = this.size;
    array = newArray;
  }
  
  public int size() {
    return this.max;
  }

}