package test.tree;

import test.queue.LinQueue;
import test.stack.LinStack;

/**
 * Created by Administrator on 2017/3/9 0009.
 */
public class Traverse {
    public static void preOrder(BiTreeNode t,Visit vs){
        //前序遍历二叉树t,访问节点操作为vs.print
        if(t!=null){
            vs.print(t.data);
            preOrder(t.getLeft(),vs);
            preOrder(t.getRight(),vs);
        }
    }
    public static void inOrder(BiTreeNode t,Visit vs){
        //中序遍历二叉树,访问节点操作为vs.print
        if(t!=null){
            inOrder(t.getLeft(),vs);
            vs.print(t.data);
            inOrder(t.getRight(),vs);
        }
    }
    public static void postOrder(BiTreeNode t,Visit vs){
        //后序遍历二叉树,访问操作为vs.print
        if(t!=null){
            postOrder(t.getLeft(),vs);
            postOrder(t.getRight(),vs);
            vs.print(t.data);
        }
    }
    public static void levelOrder(BiTreeNode t,Visit vs) throws Exception{
        //层级遍历二叉树t,访问结点操作为vs.print
        LinQueue q = new LinQueue();//创建链式队列类对象
        if(t==null)return;
        BiTreeNode curr;
        q.append(t);//根节点入队列
        while (q.notEmpty()){
            curr = (BiTreeNode)q.delete();//出队列
            vs.print(curr.data);
            if (curr.getLeft()!=null)
                q.append(curr.getLeft());
            if (curr.getRight()!=null)
                q.append(curr.getRight());
        }
    }
    public static void printBiTree(BiTreeNode root,int level){
        //二叉树root第level层结点数据元素值得横向输出
        if(root!=null){
            printBiTree(root.getRight(), level + 1);
            if (level!=0){
                //走过6*(level-1)个空格
                for (int i=0;i<6*(level-1);i++){
                    System.out.print(" ");
                }
                System.out.print("---");
            }
            System.out.println(root.data);
            printBiTree(root.getLeft(),level+1);
        }
    }
    //自调用递归,简称回溯
    public static BiTreeNode search(BiTreeNode t,Object x){
        BiTreeNode temp;
        if (t==null)return null;
        if (t.data.equals(x))return t;
        if (t.getLeft()!=null){
            temp = search(t.getLeft(),x);
            if (temp!=null)return temp;
        }
        if (t.getRight()!=null){
            temp = search(t.getRight(),x);
            if (temp!=null)return temp;
        }
        return null;//没有找到则返回null;
    }
    public static BiTreeNode getTreeNode(Object item,BiTreeNode left,BiTreeNode right){
        //构造二叉树
        BiTreeNode temp = new BiTreeNode(item,left,right);
        return temp;
    }
    public static BiTreeNode makeTree(){
        //构造不带头结点的二叉链存储结构
        BiTreeNode b,c,d,e,f,g;
        g = getTreeNode(new Character('G'),null,null);
        d = getTreeNode(new Character('D'),null,g);
        b = getTreeNode(new Character('B'),d,null);
        e = getTreeNode(new Character('E'),null,null);
        f = getTreeNode(new Character('F'),null,null);
        c = getTreeNode(new Character('C'),e,f);
        return getTreeNode(new Character('A'),b,c);
    }
    public static void main(String[]args){
        BiTreeNode root1;
        BiTreeNode temp;
        Visit vs = new Visit();
        root1 = makeTree();
        System.out.print("二叉树为:");
        printBiTree(root1,0);
        System.out.println();

        System.out.println("前序遍历结点序列为:");
        Traverse.preOrder(root1,vs);
        System.out.println();

        System.out.println("中序遍历结点序列为:");
        Traverse.inOrder(root1, vs);
        System.out.println();

        System.out.println("后序遍历结点序列为:");
        Traverse.postOrder(root1, vs);
        System.out.println();

        System.out.print("层序遍历结点序列为:");
        try {
            Traverse.levelOrder(root1,vs);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println();
        temp = search(root1,new Character('C'));
        if (temp!=null)
            System.out.println("查找到的结点数据值为:" + temp.data);
        else
            System.out.println("查找失败");
    }
    //非递归的二叉树前序遍历算法,设计借助堆栈的循环结构算法
    public static void preOrderNoRecur(BiTreeNode root)throws Exception{
        LinStack s = new LinStack();
        if (root == null)return;
            BiTreeNode curr;
            s.push(root);
        while (s.notEmpty()){
            curr = (BiTreeNode)s.pop();
            System.out.print(""+curr.data);
            if (curr.getRight()!=null)
                s.push(curr.getRight());
            if (curr.getLeft()!=null)
                s.push(curr.getLeft());
        }
    }
}
