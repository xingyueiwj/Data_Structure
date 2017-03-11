package test.tree;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class BiTreeInterator {
    BiTreeNode root;
    BiTreeNode current;
    int iteComplete;
    BiTreeInterator(){}
    BiTreeInterator(BiTreeNode tree){
        root = tree;
        current = tree;
        iteComplete = 1;
    }
    public void reset(){}
    public void next(){}
    public boolean endOfBiTree(){
        return iteComplete == 1;
    }
    public Object getData(){
        if (current == null)
            return null;
        else return current.data;
    }
}
