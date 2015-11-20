import static org.junit.Assert.*;

import org.junit.Test;


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
        assertEquals(rbt.print(),"D-B-A-C-F-E-H-G-I-J-");
    }

    @Test
    public void testDictionary(){

    }
}
