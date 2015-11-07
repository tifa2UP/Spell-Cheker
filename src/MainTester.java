/**
 * Created by Abdellatif on 11/6/2015.
 */
public class MainTester {

    public static void main(String[] args) {
        //Test add method
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        RBTree tree1 = new RBTree();
        tree1.add(a);
        tree1.add(b);
        tree1.add(d);
        tree1.add(c);
        System.out.println(c.compareTo(a));
        System.out.println(tree1.print());
        System.out.println(tree1.find("C"));


    }
}
