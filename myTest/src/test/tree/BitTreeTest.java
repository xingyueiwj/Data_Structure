package test.tree;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class BitTreeTest {
    public static void main(String[] args){
        BitTree g = new BitTree(new Character('G'),null,null);
        BitTree d = new BitTree(new Character('D'),null,g);
        BitTree b = new BitTree(new Character('B'),d,null);
        BitTree e = new BitTree(new Character('E'),null,null);
        BitTree f = new BitTree(new Character('F'),null,null);
        BitTree c = new BitTree(new Character('C'),e,f);
        BitTree a = new BitTree(new Character('A'),b,c);
        Visit vs = new Visit();
        System.out.print("前序遍历结点序列为:");
        a.preOrder(vs);
        System.out.println();

        System.out.print("中序遍历结点序列为:");
        a.inOrder(vs);
        System.out.println();

        System.out.print("后序遍历结点序列为:");
        a.postOrder(vs);
        System.out.println();
    }
}
