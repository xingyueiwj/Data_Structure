package test.graph;

/**
 * 普里姆算法vs克鲁斯卡尔算法
 * Created by Administrator on 2017/3/17 0017.
 */
public class Prim {
    static final int maxWeight = 9999;
    public static void prim(AdjMWGrap g,MinSpanTree[]closeVertex)throws Exception{
        //用普里姆算法建立带权图g的最小生成树closeVertex
        int n = g.getNumOfVertices();
        int minCost;
        int[]lowCost = new int[n];
        int k = 0;
        for (int i = 1;i<n;i++){
            lowCost[i] = g.getWeight(0,1);
        }
        MinSpanTree temp = new MinSpanTree();
        //从结点0出发构造最小生成树
        temp.vertex = g.getValue(0);
        closeVertex[0] = temp;
        lowCost[0] = -1;
        for (int i = 1 ;i<n;i++){
            //寻找当前最小权值得边所对应的弧头结点k
            minCost = maxWeight;//MaxWeight为定义的最大权值
            for (int j = 1;j<n;j++){
                if (lowCost[j]<minCost&&lowCost[j]>0){
                    minCost = lowCost[j];
                    k = j;
                }
            }
            MinSpanTree curr = new MinSpanTree();
            curr.vertex = g.getValue(k);
            curr.weight = minCost;
            closeVertex[i] = curr;
            lowCost[k] = -1;
            //根据加入集合U的结点k修改lowCost中的数值
            for (int j = 1;j<n;j++){
                if (g.getWeight(k,j)<lowCost[j]){
                    lowCost[j] = g.getWeight(k,j);
                }
            }
        }
    }
}
