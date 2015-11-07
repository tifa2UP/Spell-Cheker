/**
 * Created by Abdellatif on 10/24/2015.
 */

/**
 * Red Black trees data structure implementation and methods
 */
public class RBTree {

    private Node root;

    /**
     * Constructs an empty RBTree
     */
    public RBTree(){
        root = null;
    }

    /**
     * Constructs a RBTree with a given root data
     * @param data the Comparable object that the root will be holding
     */
    public RBTree(Comparable data){
        root.data = data;
    }

    //returns the root of the tree
    public Node getRoot(){
        return root;
    }

    //sets the root of the tree.
    public void setRoot(Node root){
        this.root = root;
    }

    /**
     * Checks if the RBTree is empty
     */
    public boolean isEmpty(){
        boolean empty = false;
        //a tree is empty if the root is null and doesn't have any children
        if (root.data == null && root.right == null && root.left == null){
            empty = true;
        }
        return empty;
    }


    /**
     * Prints out the whole tree using pre-order traversal
     */
    public void print(){
        print(root);
    }

    /**
     * prints out a subtree of a given node using pre-order traversal
     * @param n the root node of a given subtree
     */
    public void print(Node n){
        // a base case when the node is empty
        if (n == null){
            return;
        }
        // a base case for the recursive call when the node is a leaf
        if (n.left == null && n.right == null){
            System.out.println(n.data);
            return;
        }
        // prints out the root
        System.out.println(n.data);
        // traverse and print out the left subtree
        print(n.left);
        //traverse and print out the right subtree
        print(n.right);
    }

    /**
     * Checks if an object is saved in the RBTree
     * @param object the to look for
     * @return true if the object exists, false if it doesn't
     */
    public boolean find(Comparable object){
        return find(root, object);
    }

    /**
     * Checks if an object exists in a subtree of a given root n
     * @param n the root of the subtree
     * @param object the object to look for
     * @return true if the object exists, false if it doesn't
     */
    public boolean find(Node n, Comparable object){
        //return false if the tree is empty
        if ( root == null){
            return false;
        }
        //checks if the the current node is holding the object
        if (n.data.equals(object)){
            return true;
        }
        else if(n.right == null && n.left == null){
            //there are no more nodes to search, the item doesn't exist
        }
        else{
            //if the object is not the same as the node search each of its children
            find(n.left,object);
            find(n.right,object);
        }
        return false;
    }

    /**
     * Add an object to the RBTree
     * @param object the object to add
     */
    public void add(Comparable object){
        //create a new node with the given object
        Node newNode = new Node();
        newNode.data = object;
        newNode.right = null;
        newNode.left = null;

        //adds the object to the root if the tree is empty
        if (root == null){
            root = newNode;
        }
        //if the object exists do not add it
        if (find(object)){
            return;
        }



        //initiates a node to start the search
        Node node = root;
        /** Finds the location for the new node and then adds it
        Create an infinite loop that breaks when the suitable position for the new object is found
        This algorithm is created such that the loop MUST break
         */
        while(true){
            //if the object is smaller than the node search the left subtree
            if (object.compareTo(node.data) < 0){
                if (node.left == null){
                    node.left = newNode;
                    break;
                }
                else {
                    node = node.left;
                }
            }
            //else, the object is greater than the node, search the right subtree
            else {
                if (node.right == null){
                    node.right = newNode;
                    break;
                }
                node = node.right;
            }

        }
    }

    /**
     *
     * @param object
     */
    public void remove(Comparable object){

    }

    // ===============================================================

    // The node inner class
    class Node{
        //Specifies the right and left children of the node
        public Node right;
        public Node left;
        //Specifies the comparable object the node is holding
        public Comparable data;
    }
}

