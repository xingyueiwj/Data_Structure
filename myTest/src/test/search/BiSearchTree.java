package test.search;


import test.tree.Visit;

/**
 * 二叉排序树操作
 * Created by Administrator on 2017/3/20 0020.
 */
public class BiSearchTree {
    private BiTreeNode root;
    private void inOrder(BiTreeNode t,Visit vs){//中序遍历
        if (t!=null){
            inOrder(t.getLeft(),vs);
            vs.print(new Integer(t.getData()));
            inOrder(t.getRight(),vs);
        }
    }
    private void preOrder(BiTreeNode t,Visit vs){
        if (t!=null){
            vs.print(new Integer(t.getData()));
            preOrder(t.getLeft(),vs);
            preOrder(t.getRight(),vs);
        }
    }
    public BiSearchTree(){
        root = null;
    }
    public void setRoot(BiTreeNode t){
        root = t;
    }
    public BiTreeNode getRoot(){
        return root;
    }
    public void inOrder(Visit vs){
        inOrder(root,vs);
    }
    public void preOrder(Visit vs){
        preOrder(root,vs);
    }
    public BiTreeNode getLeft(BiTreeNode current){
        return current != null?current.getLeft():null;
    }
    public BiTreeNode getRight(BiTreeNode current){
        return current != null?current.getRight():null;
    }
    public BiTreeNode find(int item){
        if (root != null){
            BiTreeNode temp = root;
            while (temp!=null){
                if (temp.getData()==item)return temp;
            }
            if (temp.getData()<item)
                temp = temp.getRight();
            else
                temp = temp.getLeft();
        }
       return null;
    }
    public void insert(BiTreeNode ptr,int item){
        if (item<ptr.getData()){
            if (ptr.getLeft()==null){
                BiTreeNode temp = new BiTreeNode(item);
                temp.setParent(ptr);
                ptr.setLeftChild(temp);
            }else insert(ptr.getLeft(),item);
        }else if (item>ptr.getData()){
            if (ptr.getRight()==null){
                BiTreeNode temp = new BiTreeNode(item);
                temp.setRightChild(temp);
            }else insert(ptr.getRight(),item);
        }
        return;
    }

    public void delete(BiTreeNode ptr,int item){
        if (ptr!=null){
            if (item<ptr.getData())
                delete(ptr.getLeft(),item);
            else if (item>ptr.getData())
                delete(ptr.getRight(),item);
            else if (ptr.getLeft()!=null&&ptr.getRight()!=null){
                BiTreeNode min;
                min = ptr.getRight();
                while (min.getLeft()!=null){
                    min = min.getLeft();
                }
                ptr.setData(min.getData());
                delete(ptr.getRight(),min.getData());
            }else {
                if (ptr.getLeft()==null&&ptr.getRight()!=null){
                    ptr.getParent().setRightChild(ptr.getRight());
                    ptr.getRight().setParent(ptr.getParent());
                }else if (ptr.getRight()==null&&ptr.getLeft()!=null){
                    ptr.getParent().setLeftChild(ptr.getLeft());
                    ptr.getLeft().setParent(ptr.getParent());
                }else {
                    BiTreeNode p = ptr.getParent();
                    if (p.getLeft()==ptr)
                        p.setLeftChild(null);
                    else
                        p.setRightChild(null);
                }
            }
        }
    }
}
