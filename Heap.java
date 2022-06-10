import java.util.Stack;
 

//Luis Lopez
//Assignment 4

class Heap
   {
   public Node[] heapArray;
   public int maxSize;           // size of array
   public int currentSize;       // number of nodes in array
// -------------------------------------------------------------
   public Heap(int mx)            // constructor
      {
      maxSize = mx;
      currentSize = 0;
      heapArray = new Node[maxSize];  // create array
      }
// -------------------------------------------------------------
   public boolean isEmpty()
      { return currentSize==0; }
// -------------------------------------------------------------
   public boolean insert(Node tempNode)//we will be sending data of type node directly to the heapArray
      {
      if(currentSize==maxSize)
         return false;
      //Node newNode = new Node(key);
      heapArray[currentSize] = tempNode;
      trickleUp(currentSize++);
      return true;
      }  // end insert()
// -------------------------------------------------------------
// -------------------------------------------------------------
   
   public void buildTreeWithHeapArr(Heap arrayHeap)
   {
	   //Parent = (index - 1)/2
	   //LeftChild = index * 2
	   //RightChild = index * 2 + 1

	   int lastParent;
	   
	   //Finding last parent in the Heap array
	   lastParent = (arrayHeap.currentSize / 2) - 1;//last parent is index 4 (10 / 2 = 5) so 4th element in here.
	   
	   for(int i = lastParent; i >= 0; i--)
	   {
		   
		   int left = 2*(i+1);//add 1 to i for calculations
		   
		   arrayHeap.heapArray[i].leftChild = arrayHeap.heapArray[left-1];//subtract 1 to get the correct index
		   
		   int right = (2*(i+1)) + 1;//add 1 to i for calculations
		   
		   if(right > 10)//ensures we dont go out of bounds for the last parent, from then on, this if statement will never be used.
			   continue;
		   arrayHeap.heapArray[i].rightChild = arrayHeap.heapArray[right-1];//subtract 1 to get the correct index
		   
	   }
	   
	   
	   
	   for(int i = 0; i < 10; i++)//display each Node and its children from the heapArray one node at a time.
	   {
		   
		   displayTree(arrayHeap.heapArray[i]);
		   
	   }
	   
   }
   
   
   
// -------------------------------------------------------------
// -------------------------------------------------------------
   public void displayTree(Node heapRoot)
   {
   Stack globalStack = new Stack();
   globalStack.push(heapRoot);
   int nBlanks = 32;
   boolean isRowEmpty = false;
   System.out.println(
   "......................................................");
   while(isRowEmpty==false)
      {
      Stack localStack = new Stack();
      isRowEmpty = true;

      for(int j=0; j<nBlanks; j++)
         System.out.print(' ');

      while(globalStack.isEmpty()==false)
         {
         Node temp = (Node)globalStack.pop();
         if(temp != null)
            {
            System.out.print(temp.iDataKey);
            localStack.push(temp.leftChild);
            localStack.push(temp.rightChild);

            if(temp.leftChild != null ||
                                temp.rightChild != null)
               isRowEmpty = false;
            }
         else
            {
            System.out.print("--");
            localStack.push(null);
            localStack.push(null);
            }
         for(int j=0; j<nBlanks*2-2; j++)
            System.out.print(' ');
         }  // end while globalStack not empty
      System.out.println();
      nBlanks /= 2;
      while(localStack.isEmpty()==false)
         globalStack.push( localStack.pop() );
      }  // end while isRowEmpty is false
   System.out.println(
   "......................................................");
   }  // end displayTree()
// -------------------------------------------------------------
   
   public void trickleUp(int index)
      {
      int parent = (index-1) / 2;
      Node bottom = heapArray[index];

      while( index > 0 &&
             heapArray[parent].getKey() < bottom.getKey() )
         {
         heapArray[index] = heapArray[parent];  // move it down
         index = parent;
         parent = (parent-1) / 2;
         }  // end while
      heapArray[index] = bottom;
      }  // end trickleUp()
// -------------------------------------------------------------
   public Node remove()           // delete item with max key
      {                           // (assumes non-empty list)
      Node root = heapArray[0];
      heapArray[0] = heapArray[--currentSize];
      trickleDown(0);
      return root;
      }  // end remove()
// -------------------------------------------------------------
   public void trickleDown(int index)
      {
      int largerChild;
      Node top = heapArray[index];       // save root
      while(index < currentSize/2)       // while node has at
         {                               //    least one child,
         int leftChild = 2*index+1;
         int rightChild = leftChild+1;
                                         // find larger child
         if(rightChild < currentSize &&  // (rightChild exists?)
                             heapArray[leftChild].getKey() <
                             heapArray[rightChild].getKey())
            largerChild = rightChild;
         else
            largerChild = leftChild;
                                         // top >= largerChild?
         if( top.getKey() >= heapArray[largerChild].getKey() )
            break;
                                         // shift child up
         heapArray[index] = heapArray[largerChild];
         index = largerChild;            // go down
         }  // end while
      heapArray[index] = top;            // root to index
      }  // end trickleDown()
// -------------------------------------------------------------
   public boolean change(int index, int newValue)
      {
      if(index<0 || index>=currentSize)
         return false;
      int oldValue = heapArray[index].getKey(); // remember old
      heapArray[index].setKey(newValue);  // change to new

      if(oldValue < newValue)             // if raised,
         trickleUp(index);                // trickle it up
      else                                // if lowered,
         trickleDown(index);              // trickle it down
      return true;
      }  // end change()
// -------------------------------------------------------------
   public void displayHeap()
      {
      System.out.print("heapArray: ");    // array format
      for(int m=0; m<currentSize; m++)
         if(heapArray[m] != null)
            System.out.print( heapArray[m].getKey() + " ");
         else
            System.out.print( "-- ");
      System.out.println();
                                          // heap format
      int nBlanks = 32;
      int itemsPerRow = 1;
      int column = 0;
      int j = 0;                          // current item
      String dots = "...............................";
      System.out.println(dots+dots);      // dotted top line

      while(currentSize > 0)              // for each heap item
         {
         if(column == 0)                  // first item in row?
            for(int k=0; k<nBlanks; k++)  // preceding blanks
               System.out.print(' ');
                                          // display item
         System.out.print(heapArray[j].getKey());

         if(++j == currentSize)           // done?
            break;

         if(++column==itemsPerRow)        // end of row?
            {
            nBlanks /= 2;                 // half the blanks
            itemsPerRow *= 2;             // twice the items
            column = 0;                   // start over on
            System.out.println();         //    new row
            }
         else                             // next item on row
            for(int k=0; k<nBlanks*2-2; k++)
               System.out.print(' ');     // interim blanks
         }  // end for
      System.out.println("\n"+dots+dots); // dotted bottom line
      }  // end displayHeap()
// -------------------------------------------------------------
   }  // end class Heap