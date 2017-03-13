package test.tree;

/**
 * Created by Administrator on 2017/3/12 0012.
 */
public class HaffmanTree {
    static final int maxValue = 10000;
    private int nodeNum;
    public HaffmanTree(int n){
        nodeNum = n;
    }
    public void haffman(int[]weight,HaffNode[]node){
        //构造权值为weight的哈夫曼树haffTree
        int m1,m2,x1,x2;
        int n = nodeNum;
        //哈夫曼树haffTree初始化,n个结点的哈夫曼树共有2n-1个结点
        for (int i = 0;i<2 * n-1;i++){
            HaffNode temp = new HaffNode();
            if (i<n)
                temp.weight = weight[i];
            else
                temp.weight = 0;
            temp.parent = 0;
            temp.flag = 0;
            temp.leftChild = -1;
            temp.rightChild = -1;
            node[i] = temp;
        }
        //构造哈夫曼树hafTree的n-1个非叶子结点
        for (int i = 0;i<n-1;i++){
            m1 = m2 = maxValue;
            x1 = x2 = 0;
            for (int j = 0;j<n+1;j++){
                if (node[j].weight<m1&&node[j].flag==0){
                    m2 = m1;
                    x2 = x1;
                    m1 = node[j].weight;
                    x1 = j;
                }else if (node[j].weight < m2 && node[j].flag==0){
                    m2 = node[j].weight;
                    x2 = j;
                }
            }
            //将找出的两棵树权值最小的子树合并为一颗子树
            node[x1].parent = n+i;
            node[x2].parent = n+i;
            node[x1].flag = 1;
            node[x2].flag = 1;
            node[n+i].weight = node[x1].weight + node[x2].weight;
            node[n+i].leftChild = x1;
            node[n+i].rightChild = x2;
        }
    }
    public void haffmanCode(HaffNode[]node,Code[]haffCode){
        //由哈夫曼树haffTree构造哈夫曼编码haffCode
        int n = nodeNum;
        Code cd = new Code(n);
        int child,parent;
        //求n个叶节点的哈夫曼编码
        for (int i = 0;i<n;i++){
            cd.start = n-1;
            cd.weight = node[i].weight;
            child = i;
            parent = node[child].parent;
            while (parent!=0){
                //由叶结点向上直到根结点循环
                if (node[parent].leftChild==child)
                    cd.bit[cd.start] = 0;
                else
                    cd.bit[cd.start] = 1;
                cd.start--;
                child = parent;
                parent = node[child].parent;
            }
            Code temp = new Code(n);
            //保存叶结点的编码和不等长编码的起始位
            for (int j = cd.start+1;j<n;j++){
                temp.bit[j] = cd.bit[j];
            }
            temp.start = cd.start;
            temp.weight = cd.weight;
            haffCode[i] = temp;
        }
    }
}
