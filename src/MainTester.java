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
        String e = "E";
        RBTree tree1 = new RBTree();
        tree1.add(b);
        System.out.println(tree1.print());
        tree1.add(a);
        System.out.println(tree1.print());
        tree1.add(d);
        System.out.println(tree1.print());
        tree1.add(c);
        System.out.println(tree1.print());
        tree1.add(e);
        System.out.println(tree1.print());
        System.out.println("=====================");
        tree1.preOrderPrint();
        System.out.println("The data structure is functional!!");
//        tree1.add(a);
//        tree1.add(e);



        
    }
}
