
//Luis Lopez
//Assignment 4

class Node
   {
   public int iDataKey;     // data item (key)
   public Node rightChild;	 // this node's right child
   public Node leftChild;	 // this node's left child
// -------------------------------------------------------------
   public Node(int key)      // constructor
      {  iDataKey = key;}
// -------------------------------------------------------------
   public int getKey()
      { return iDataKey; }
// -------------------------------------------------------------
   public void setKey(int id)
      { iDataKey = id; }
// -------------------------------------------------------------
   }  // end class Node