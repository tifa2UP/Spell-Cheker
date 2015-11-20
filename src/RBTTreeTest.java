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
        assertEquals("DBACFEHGIJ", makeString(rbt));
        String str=
                "Color: 1, Key:D Parent: \n"+
                        "Color: 1, Key:B Parent: D\n"+
                        "Color: 1, Key:A Parent: B\n"+
                        "Color: 1, Key:C Parent: B\n"+
                        "Color: 1, Key:F Parent: D\n"+
                        "Color: 1, Key:E Parent: F\n"+
                        "Color: 0, Key:H Parent: F\n"+
                        "Color: 1, Key:G Parent: H\n"+
                        "Color: 1, Key:I Parent: H\n"+
                        "Color: 0, Key:J Parent: I\n";
        assertEquals(str, makeStringDetails(rbt));

    }

    public static String makeString(RBTree t)
    {
        class MyVisitor implements RBTree.Visitor {
            String result = "";
            public void visit(RBTree.Node n)
            {
                result = result + n.data;
            }
        };
        MyVisitor v = new MyVisitor();
        t.preOrderVisit(v);
        return v.result;
    }

    public static String makeStringDetails(RBTree t) {
        {
            class MyVisitor implements RBTree.Visitor {
                String result = "";
                public void visit(RBTree.Node n)
                {
                    if(!(n.data).equals(""))
                        result = result +"Color: "+n.red+", Key:"+n.data+" Parent: "+n.parent.data+"\n";

                }
            };
            MyVisitor v = new MyVisitor();
            t.preOrderVisit(v);
            return v.result;
        }
    }





}
