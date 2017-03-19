package test.search;


import test.tree.BitTree;

/**
 * Created by Administrator on 2017/3/19 0019.
 */
public class BiTreeNode {
    private BiTreeNode leftChild;//左孩子结点对象引用
    private BiTreeNode rightChild;//右孩子结点对象引用
    private BiTreeNode parent;//双亲结点对象引用
    private int data;//数据元素

    public BiTreeNode(){
        leftChild = null;
        rightChild = null;
    }
    public BiTreeNode(int item){
        leftChild = null;
        rightChild = null;
        data = item;
    }
    public BiTreeNode(int item,BiTreeNode left, BiTreeNode right){
        data = item;
        leftChild = left;
        rightChild = right;
    }
    public void setParent(BiTreeNode parent){
        this.parent = parent;
    }
    public BiTreeNode getParent(){
        return parent;
    }
    public void setLeftChild(BiTreeNode left){
        leftChild = left;
    }
    public void setRightChild(BiTreeNode right){
        rightChild = right;
    }
    public void setData(int data){
        this.data = data;
    }
    public BiTreeNode getLeft(){
        return leftChild;
    }
    public BiTreeNode getRight(){
        return rightChild;
    }
    public int getData(){
        return data;
    }
}
