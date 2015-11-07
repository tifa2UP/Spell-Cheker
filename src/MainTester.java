/**
 * Created by Abdellatif on 11/6/2015.
 */
public class MainTester {

    public static void main(String[] args) {
        //Test add method
        String a = "1";
        String b = "12";
        RBTree tree1 = new RBTree();
        tree1.add(a);
        tree1.add(b);
        tree1.print();
    }
}
