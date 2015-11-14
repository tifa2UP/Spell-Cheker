/**
 * Created by Abdellatif on 10/24/2015.
 */

import java.util.Comparator;

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
     * Returns a String that represent the contents of the whole tree using pre-order traversal
     * Separated by a "-"
     */
    public String print(){
        return print(root);
    }

    /**
     * prints out a subtree of a given node using pre-order traversal
     * @param n the root node of a given subtree
     */
    public String print(Node n){
        // a base case when the node is empty
        if (n == null){
            return "";
        }
        // a base case for the recursive call when the node is a leaf
        else if (n.left == null && n.right == null){
            return n.data.toString() + "-";
        }
        // prints out the root then traverse and print out the left subtree then the right subtree
        else {
            return (String) n.data.toString() + "-" + print(n.left) + print(n.right);
        }
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
        if ( n == null){
            return false;
        }
        //checks if the the current node is holding the object
        else if (n.data.equals(object)){
            return true;
        }

        else{
            //if the object is not the same as the node search each of its children
            if (object.compareTo(n.data) < 0){
                if (n.left  == null){
                    return false;
                }
                find(n.left,object);
            }
            else{
                if (n.right  == null){
                    return false;
                }
                find(n.right,object);
            }
        }
        return false;
    }

    /**
     * returns the node that holds the given object in a RBTree
     * @param object the object to look for
     * @return the node that contains the object
     */
    public Node findNode(Comparable object){
        return findNode(root,object);
    }

    /**
     *
     * @param n the node to start searching from
     * @param object the object to look for
     * @return the node that contains the object
     */
    private Node findNode(Node n, Comparable object){
        //return null if the tree is empty
        if ( n == null){
            return null;
        }
        //checks if the the current node is holding the object
        else if (n.data.equals(object)){
            return n;
        }

        else{
            //if the object is not the same as the node search each of its children
            if (object.compareTo(n.data) < 0){
                if (n.left  == null){
                    return null;
                }
                find(n.left,object);
            }
            else{
                if (n.right  == null){
                    return null;
                }
                find(n.right,object);
            }
        }
        return null;
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
        newNode.red = true;

        //adds the object to the root if the tree is empty
        if (root == null){
            // the RBTree root should always have a black color
            newNode.red = false;
            root = newNode;
            return;
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
        fixTree();
    }

    /**
     * Fixes the RBTree
     */
    public void fixTree(){
        //do nothing if the tree is already fixed
        if (isFixed()){
            return;
        }
        //else fix the tree
        else{
            
        }
    }

    /**
     * Checks if the RBTree is fixed
     * @return true if the tree is fixed and false otherwise
     */
    public boolean isFixed(){
        return false;
    }

    // ===============================================
    // Since the remove method isn't applicable in a
    // dictionary application I've commented it out
    // ===============================================

//    /**
//     * removes a given object data from the RBTree
//     * @param object the object to remove
//     */
//    public void remove(Comparable object){
//        //Finds the node with the data to remove
//        Node n = findNode(object);
//
//        if (n == null){
//            //if the node doesn't exist exit the function
//            return;
//        }
//        //Case 1: The node has no children
//        if (n.left == null && n.right == null){
//            //remove the node
//            n = null;
//        }
//        //Case 2: The node has only a left child
//        else if (n.left != null && n.right == null){
//            n = n.left;
//        }
//        //Case 3: The node has only a right child
//        else if (n.left == null && n.right != null){
//            n = n.right;
//        }
//        //Case 4: the node has two children
//        else{
//            //replace the node with the successor
//            Comparable temp = n.data;
//            Node successor = successor(n);
//            n.data = successor.data;
//            successor.data = temp;
//            //delete the successor
//            remove(temp);
//        }
//
//    }

    /**
     * Finds the successor of a given node
     * @param n
     * @return return null if the successor doesn't exist
     */
    public Node successor(Node n){
        Node successor = n.right;
        while (successor.left != null){
            successor = successor.left;
        }
        return successor;
    }
    // ===============================================================

    // The node inner class
    class Node{
        //Specifies the right and left children of the node
        public Node right;
        public Node left;
        //Specifies the comparable object the node is holding
        public Comparable data;
        //Specifies the color of the Node, true for red false for black
        public boolean red;
    }
}

