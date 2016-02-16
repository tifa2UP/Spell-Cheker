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
    //TODO: do not allow duplicates
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


    public void add(Comparable object) {
        //create a new node with the given object
        Node newNode = new Node();
        newNode.data = object;
        newNode.right = null;
        newNode.left = null;
        newNode.red = true;
        Node parent = root;
        Node currentNode = root;

        if (root == null){
            root = newNode;
        }
        else{
            while (currentNode != null) {
                parent = currentNode;
                if (object.compareTo(currentNode.data) < 0) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }
            newNode.parent = parent;
            if (parent == null){
                root = newNode;
            }
            else if(object.compareTo(parent.data) < 0){
                parent.left = newNode;
            }
            else{
                parent.right = newNode;
            }
            fixTree(newNode);
        }

    }

    public Node getSibling(Node node){
        if (node == null || node.parent == null){
            return null;
        }
        else if (node == node.parent.left){
            return node.parent.right;
        }
        else {
            return node.parent.left;
        }
    }

    public Node getAunt(Node node){
        if (node == null || node.parent == null || node.parent.parent == null){
            return null;
        }
        else if (node.parent == node.parent.parent.left){
            return node.parent.parent.right;
        }
        else{
            return node.parent.parent.left;
        }
    }

    public Node getGrandparent(Node node){
        if (node == null || node.parent == null || node.parent.parent == null){
            return null;
        }
        else{
            return node.parent.parent;
        }
    }

    public void preOrderPrint(){
        preOrderPrint(root);
        System.out.println();
    }
    public void preOrderPrint(Node n){
        if (n == null){
            return;
        }
        System.out.print(n.data + "-");
        preOrderPrint(n.left);
        preOrderPrint(n.right);
    }

    /**
     * After many errors and trials I decided not to act smart and use the book's implementation
     *
     */
    public void fixTree(Node node)
    {
        Node y;
        while(node.parent.red == false)
        {
            if(node.parent == getGrandparent(node).left){
                y = getGrandparent(node).right;
                if(y.red == false){
                    node.parent.red = true;
                    y.red = true;
                    getGrandparent(node).red = false;
                    node = getGrandparent(node);
                }else
                {
                    if(node == node.parent.right)
                    {
                        node = node.parent;
                       rotateLeft(node);
                    }
                    node.parent.red = true;
                   getGrandparent(node).red = false;
                    rotateRight(getGrandparent(node));

                }
            }else{
                y = getGrandparent(node).left;
                if(y.red == false){
                    node.parent.red  = true;
                    y.red = true;
                    getGrandparent(node).red = false;
                    node = getGrandparent(node);
                }else
                {
                    if(node == node.parent.left)
                    {
                        node = node.parent;
                       rotateRight(node);
                    }
                    node.parent.red  = true;
                    getGrandparent(node).red = false;
                    rotateLeft(getGrandparent(node));
                }
            }
        }

        root.red = true;
    }


    private void rotateLeft(Node node){
      Node y;
        if (node.right == null){
             y = null;
        }
        else {
             y = node.right;
        }
        node.right = y.left;
        if (y.left != null){
            y.left.parent = node;
        }
        y.parent = node.parent;
        if (node.parent == null){
            root = y;
        }
        else if (node == node.parent.left){
            node.parent.left = y;
        }
        else{
            node.parent.right = y;
            y.left = node;
            node.parent = y;
        }
    }

    public void rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.red = x.right.red;
        x.right.red = true;
    }

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
    public void preOrderVisit(Visitor v)
    {
        preOrderVisit(root, v);
    }


    private static void preOrderVisit(Node n, Visitor v)
    {
        if (n == null) return;
        v.visit(n);
        preOrderVisit(n.left, v);
        preOrderVisit(n.right, v);
    }
    public static interface Visitor
    {
        /**
         This method is called at each node.
         @param n the visited node
         */
        void visit(Node n);
    }

    // ===============================================================

    // The node inner class
    class Node{
        //Specifies the parent of the node
        public Node parent;
        //Specifies the right and left children of the node
        public Node right;
        public Node left;
        //Specifies the comparable object the node is holding
        public Comparable data;
        //Specifies the color of the Node, true for red false for black
        public boolean red;
    }
}

