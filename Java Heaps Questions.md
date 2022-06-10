Q1. When you are done with this algorithm, what do you find in the first element of the Heap
Array?

The first element of the Heap is the root of the Binary Tree and also the Maximum number.

Q2. Discuss this mapping algorithm in terms of:
1. Running time in Big O notation
In this mapping algorithm, the mapping’s running time is O(n/2) because we had to iterate half of the heapArray we created to find all the parents and use calculations of left and right children to attach them.
2. Memory cost

I would say that the memory cost of this mapping algorithm is similar to the running time.
But if we’re talking about the whole program’s memory cost, then it would be a lot more costly because of how many arrays I used to set everything up for building the heapArray. 

Q3. Discuss the advantages and disadvantages of this algorithm. Be specific.
Advantages

-	After building the heapArray, its very fast and efficient to map it into a Binary Tree, we knew exact index locations after a simple calculation so attaching the children to its parents was easy.
Disadvantages
-	Setting up the heapArray is very inefficient, at least from the steps I took to build it. It took me using TallyArray to ensure no duplicates are randomly generated and then had to traverse through that array several times to finally populate the Node array that I can use to make a heapArray.
