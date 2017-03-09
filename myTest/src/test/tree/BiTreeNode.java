package test.tree;

/**
 * 二叉树节点类
 * Created by Administrator on 2017/3/9 0009.
 */
public class BiTreeNode {
    private BiTreeNode leftChild;
    private BiTreeNode rightChild;
    public Object data;
    //无参构造
    BiTreeNode(){
        leftChild = null;
        rightChild = null;
    }
    //有参构造
    BiTreeNode(Object item,BiTreeNode left,BiTreeNode right){
        data = item;
        leftChild = left;
        rightChild = right;
    }
    public BiTreeNode getLeft(){
        return leftChild;
    }
    public BiTreeNode getRight(){
        return rightChild;
    }
    public Object getData(){
        return data;
    }
}
