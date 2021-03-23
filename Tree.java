class Tree {
    class Node 
    {
        int key;
        int count;
        Node left, right;
        public Node(int item)
        {
            key = item;
            left = right = null;
            count = 0;
        }
    }
    Node root;
    int small_count=0;
    Tree() 
    { 
        root = null; 
    }
    /* 
    Since we have to create a Binary tree so we will add data in a whay that for each node 
    laftChild.value > root.value and rightChild.value < root.value. 
    
    now we can approach this problem in two ways
    1. inorder Traversal
    2. Storing count of smaller node
    */
    void insert(int key) 
    { 
        root = insertRec(root, key); 
    }
    Node insertRec(Node root, int key)
    {
        if (root == null) 
        {
            root = new Node(key);
            return root;
        }
        
        if (key < root.key){
            root.count = root.count+1;
            root.left = insertRec(root.left, key);
        }else if (key > root.key){
            root.right = insertRec(root.right, key);
        }
        
        return root;
    }
    /*
    In-order traversal: 
    In this approach we will traverse we will traverse our tree in inorde fashion and
    since it is a binary search tree so we will get our traversal result in sorted fashion. 
    Thus we will check for all the nodes less than given number and return the value.
    */
    int getCount(int num) 
    { 
        return viaInorder(root, num);
    }
    int viaInorder(Node root,int val){
        if(root==null) return 0;
        
        if(root.key < val ) 
            return 1 + viaInorder(root.left,val) + viaInorder(root.right, val); 
        else if(root.key < val) 
            return viaInorder(root.right, val); 
        else
            return viaInorder(root.left, val);
    }
    /*Storing count of smaller node:
    In this approach while creating the tree we will store the count of number of values 
    less than the node in each node, so while traversing the tree for smaller values than given 
    value if a given node have less value than required then instead of going into left child 
    we can just directly take the count from given node and move to the right child 
    which will make our traversal quick and we won't have to go through all the nodes
    */
    int getCount2(int num){
        small_count = 0;
        search(num, root);
        return small_count; 
    }
    void search(int num, Node root){
        if (root==null) return;
        if( root.key==num ) {
            small_count += root.count;
            return;
        }
        if (root.key < num){
            small_count += root.count + 1;
            search(num,root.right);
            return;
        }
        search(num, root.left);
        return;
    }
    public static void main(String[] args)
    {
        Tree tree = new Tree();
        // Creating a tree
        tree.insert(6);
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.insert(10);
        tree.insert(8);
        
        // Getting count of smaller values
        System.out.println(tree.getCount(6));
        System.out.println(tree.getCount2(6));
        
    }
}
