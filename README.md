# Java-Heaps-Assignment
Spring 2022 Data Structures &amp; Algorithms Assignment 4

Download the code provided by the textbook in order to complete this program.


An experimental Algorithm for mapping a Heap Array into a Binary Tree
You are asked to write a program that maps a Heap that is stored in an array to a Binary Tree.
The following is the list of steps to take:

1. Instantiate an array of 10 Node objects. You will find the class Node in the book. You
need the Node class with the integer key attribute as well as the left and the right child.

2. Each Node object need to have an integer attribute that you randomly create in the range
10 - 50. Make sure you do not have any duplicates. Modify the Node class if needed.

3. Use the code in the book to build a Heap out of this array. Make sure you modify the
book’s code properly. The Heap will be built based on the integer key attribute of the Node.

4. Our algorithm approaches the task of mapping this Heap Array into a Binary Tree in a
bottom up fashion. This means that we will start with the last parent, find its possible children,
attach them to the parent and move to the next parent (which will be the one before last, etc)
in line and do the same.

Following this algorithm the original parent nodes that are the occupants of our Heap Array may
grow into subtrees as we connect them with their possible children.

When you are done with this step of the algorithm, in order to show your work, iterate through
the array and display its contents. Keep in mind that each cell will have a subtree or a single node
which can be considered a one-node subtree. Use the display method in the book that is used to
display trees, that method needs to have access to the root of a given tree, you can pass the node
in each cell of this array as the root, and have this method display it as a tree/subtree/possibly a
single node. Feel free to make any changes in the display method in the book if there is a need.

Would you be done building the tree when you reach to the first element of the array?

Now you must provide answers to the following questions in a report file similar to what we
used to have in some previous assignments. Questions are numbered and appear in italics:

Q1. When you are done with this algorithm, what do you find in the first element of the Heap
Array?

Q2. Discuss this mapping algorithm in terms of:
1. Running time in Big O notation
2. Memory cost

Q3. Discuss the advantages and disadvantages of this algorithm. Be specific. 
