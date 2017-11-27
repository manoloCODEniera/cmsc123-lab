import java.util.*;

class HashTable {
  class HashNode {
    String key;
    int value;
    HashNode next;
  
    HashNode(String key, int value) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }
  
  int MAX_SIZE; 
  int size; 
  HashNode[] hashTable; 
  
 
  HashTable() {
    MAX_SIZE = 30;
    hashTable = new HashNode[MAX_SIZE];
    

    for (int i = 0; i < MAX_SIZE; i++)
      hashTable[i] = null;
  }
  

  
  
  
  
  public void put(String key, int value) {
    int hash = (getHash(key) % MAX_SIZE);
    
    if(hashTable[hash] == null) {
      hashTable[hash] = new HashNode(key, value);
    }
    else {
      HashNode newNode = hashTable[hash];
      while(newNode.next != null && newNode.key != key) {
        newNode = newNode.next;
      }
      if(newNode.key == key) {
        newNode.value = value;
      }
      else {
        newNode.next = new HashNode(key, value);
      }
    }
    size++;
  }
  

  public Integer get(String key) {
    int hash = (getHash(key) % MAX_SIZE);
    
    if(hashTable[hash] == null) {
      return null;
    }
    
    HashNode newNode = hashTable[hash];
    while(newNode.next != null && newNode.key != key) {
      newNode = newNode.next;
    }
    if(newNode.key == null) {
      return null;
    }
    return newNode.value;
  }
  

  
  
  
  
  
  
  public Integer remove(String key) {
    int hash = (getHash(key) % MAX_SIZE);
    
    if(hashTable[hash] == null) {
      return null;
    }
    
    HashNode previous = null;
    HashNode newNode = hashTable[hash];
      
    while(newNode.next != null && newNode.key != key) {
      previous = newNode;
      newNode.next = newNode;
    }
    if(newNode.key == null) {
      return null;
    }
    
    if(previous == null)
      hashTable[hash] = newNode.next;
    else
      previous.next = newNode.next;
    
    size--;
    return newNode.value;
  }
  
 
  
  
  public boolean contains(String key) {
    int hash = (getHash(key) % MAX_SIZE);
    
    if(hashTable[hash] == null) {
      return false;
    }
    HashNode newNode = hashTable[hash];
    while(newNode.next != null && newNode.key != key) {
      newNode.next = newNode;
    }
    if(newNode.key == null) {
      return false;
    }
    return true;
  }
  

  
  
  
  
  
  public List<Integer> values() {
    
    List<Integer> list = new ArrayList<>();
    
    for (int i = 0; i < MAX_SIZE; i++) {
      HashNode newNode = hashTable[i];
      while (newNode != null) {
        list.add(newNode.value);
        newNode = newNode.next;
      } 
    }
    return list;
  }
  

  
  
  
  public List<String> keys() {
    
    List<String> list = new ArrayList<>();
    
    
    for (int i = 0; i < MAX_SIZE; i++) {
      
      HashNode newNode = hashTable[i];
      while (newNode != null) {
        list.add(newNode.key);
        newNode = newNode.next;
      } 
    }
    return list;
  }
  
  
  
  // function which gives the hash value of the String
  public int getHash(String key) {
    int hashCode = key.hashCode();
    int hashValue = hashCode % MAX_SIZE;
    return hashValue;
  }
  
  
  
  
  // function which prints the hash table
  public void display() {
    for (int i = 0; i < MAX_SIZE; i++) {
      System.out.println("\nHash Index "+ (i + 1) +" : ");
      HashNode newNode = hashTable[i];
      while (newNode != null) {
        System.out.print(newNode.value +" ");
        newNode = newNode.next;
      } 
    }
  }
  
  // function which returns the number of ELEMENTS IN ALL BUCKETS in the hash table
  public int getSize() {
    return size;
  }
}