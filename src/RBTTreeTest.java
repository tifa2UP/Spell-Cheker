import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RBTTreeTest {

    @Test
    public void test() {
        RBTree rbt = new RBTree();
        rbt.add("D");
        rbt.add("B");
        rbt.add("A");
        rbt.add("C");
        rbt.add("F");
        rbt.add("E");
        rbt.add("H");
        rbt.add("G");
        rbt.add("I");
        rbt.add("J");

        //DBACFEHGIJ
        System.out.println(rbt.print());
        System.out.println(rbt.find("D"));
        System.out.println(rbt.find("Abdellatif"));
        assertEquals(rbt.print(),"D-B-A-C-F-E-H-G-I-J-");

    }

//    @Test
//    public void testDictionary() throws FileNotFoundException{
//        RBTree dictionaryTree = new RBTree();
//        File dictionary = new File("dictionary.txt");
//        Scanner input = new Scanner(dictionary);
//        while (input.hasNext()){
////            System.out.println(input.next());
//        dictionaryTree.add(input.next());
//        }
////        dictionaryTree.preOrderPrint();
//        assertEquals(dictionaryTree.find("ijaaz"), false);
//        assertEquals(dictionaryTree.find("aerospace"), true);
//        //add a bunch of tests
//    }
}
