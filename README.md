# TreeTraversal_ICICI

Since we have to create a Binary tree so we will add data in a whay that for each node laftChild.value > root.value and rightChild.value < root.value. 
Now we can approach this problem in two ways:
    1. Inorder Traversal
    2. Storing count of all the value lass than itself in node.

## In-order traversal:
In this approach we will traverse we will traverse our tree in inorde fashion and since it is a binary search tree so we will get our traversal result in sorted fashion. Thus we will check for all the nodes less than given number and return the value.
 
## Storing count of smaller node:
In this approach while creating the tree we will store the count of number of values less than the node in each node, so while traversing the tree for smaller values than given value if a given node have less value than required then instead of going into left child we can just directly take the count from given node and move to the right child which will make our traversal quick and we won't have to go through all the nodes.
   
