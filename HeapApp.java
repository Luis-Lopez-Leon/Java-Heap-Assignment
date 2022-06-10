import java.util.Random;

//Luis Lopez
//Assignment 4

class HeapApp
   {
   public static void main(String[] args)
      {
	   int nodeArrSize = 10;
	   Node[] NodeArray = new Node[nodeArrSize];
	   Random rand = new Random();
	   int rand1;
	   int[] tallyArray = new int[51];
	   Heap theHeap = new Heap(10);
	   
	   for(int i = 10; i < 51; i++)//populating tallyArray to all zeroes
	      {
	    	  
	    	  tallyArray[i] = 0;
	    	  
	      }
	   
	   for(int i = 0; i < 10; i++)//10 random numbers corresponds to the indices of the tallyArray and is set to 1. if duplicate, find another random num
	      {
		   
		   		rand1 = rand.nextInt(39) + 10;
		   		
		   		tallyArray[rand1]++;
		   		
		   		while(tallyArray[rand1] > 1)//duplicate found, keep choosing a random number until no duplicate is found
		   		{
		   			tallyArray[rand1]--;
		   			rand1 = rand.nextInt(39) + 10;
		   			tallyArray[rand1]++;
		   			
		   		}
	    	  
	      }
	   /*
	   for(int i = 10; i < 51; i++)//testing tallyArray
	      {
	    	  
		   System.out.print(tallyArray[i]);
	    	  
	      }
	   */
	   
	   for(int i = 0; i < nodeArrSize; i++)//Populating Node Array with the random number from the tally array, guarantees no duplicates
	   {
		   
		   Node tempNode;
		   int tempNum;
		   
		   for(int j = 10; j < 51; j++)//tally array
		      {
		    	  
			   
			   
		    	 if(tallyArray[j] > 0)//only populate Node array if the tally greater than 0 which means that index is one of the random numbers we generated.
		    	 {
		    		 
		    		 tempNum = j;
		    		 tempNode = new Node(tempNum);
		    		 NodeArray[i] = tempNode;
		    		 tallyArray[j]--;//set tally back to 0 so we know that number is used and we wont come across it again.
		    		 break;
		    		 
		    	 }
		    	  
		      }
		   
	   }
	   
	   
	   
	 System.out.println();
      
     /*
      for(int i = 0; i < nodeArrSize; i++)//testing NodeArray
      {
    	  
    	  System.out.println("Node" + i + ": " + NodeArray[i].getKey() );
    	  
      }
      */
      
      for(int i = 0; i < nodeArrSize; i++)// Building Heap array out of the Node Array
	   {
      
    	  theHeap.insert(NodeArray[i]);
    	  
	   }
      
      System.out.println("\nDisplaying heapArray and the Tree representation of it:\n");
      
      theHeap.displayHeap();//testing the HeapArray
      
      System.out.println("\n\n\nDisplaying the mapped Binary Tree and subTrees by iterating each Node in the HeapArray after attaching the children to its parents:\n");
      
      theHeap.buildTreeWithHeapArr(theHeap);
      
      
     
      }  // end main()

  }  // end class HeapApp