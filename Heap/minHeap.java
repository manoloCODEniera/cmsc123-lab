public class minHeap {
 public int size;
 public int [] array;
 public int position;
 
 
 public minHeap(int size){
  this.size=size;
  array = new int [size+1];
  position = 0;
 }
 
 //inserts the value into the heap
 void add(int value){
   
   if(position==0){  
     array[1]= value; position = 2;
   }
   else{
     array[position] = value;
     
     bubbleUp();
     position++;
     
   }
   
 
 
 }
 
 void bubbleUp(){
   
  int tempPosition = position;
  
  while(tempPosition > 0 && array[tempPosition/2] > array[tempPosition]){
   
    int y = array[tempPosition];
    array[tempPosition] = array[tempPosition/2];
    array[tempPosition/2] = y;
    tempPosition /= 2;
   
  }
 
 }
 
 
 //removes the smallest value in the heap and returns it
 int remove(){
   
   if(position < 2){
     System.out.println("Empty heap");
     return -1;
   }
   
   int min = array[1];
   array[1] = array[position-1];
   array[position-1] = 0;
   position--;
   sinkDown(1);
 return min;
 }
 
 public void sinkDown(int k){
   
  int a = array[k];
  int smallest =k;
  
  if(2*k < position && array[smallest] > array[2*k]){
   smallest = 2*k;
  }
  
  if(2*k+1 < position && array[smallest] > array[2*k+1]){
   smallest = 2*k+1;
  }
  
  if(smallest!=k){
   swap(k,smallest);
   sinkDown(smallest);
  }
    
 }
 public void swap(int a, int b){
   
  int temp = array[a];
  array[a] = array[b];
  array[b] = temp;
 }
 
 
 
 // prints the values in preorder traversal
 void preorder(){
   
    int index = 1;
    preorder(index);
    System.out.println();
 } 
 
 
 
 //prints the values in inorder traversal
 void inorder(){
   
    int index = 1;
    inorder(index);
    System.out.println();
  
 }
 
 //prints the values in postorder traversal
 void postorder(){
   
    int index = 1;
    postorder(index);
    System.out.println();
 }
 
  protected void preorder(int index) {
    if(index > size) {
      return;
    }
    if(array[index]!=0)
    System.out.print(array[index] + " ");
    preorder(index*2);
    preorder(index*2+1);
  }
  

  protected void inorder(int index) {
    if(index > size) {
      return;
    }
    inorder(index*2);
    if(array[index]!=0)
    System.out.print(array[index] + " ");
    inorder(index*2+1);
  }
  

  protected void postorder(int index) {
    if(index > size) {
      return;
    }
    postorder(index*2);
    postorder(index*2+1);
    if(array[index]!=0)
    System.out.print(array[index] + " ");
  }
 
 public String toString(){
   
      String out = "";
      
      for(int k = 1; k <= size; k++)
        out += array[k]+" ";
      return out;
 }

 
 public static void main(String args[]){
   
   minHeap heap = new minHeap(5);
   
   heap.add(1);
   heap.add(2);
   heap.add(3);
   heap.add(4);
   heap.add(5);
   
   heap.preorder();
   
   heap.inorder();
   
   heap.postorder();
   
   heap.toString();

 }
 
  
}