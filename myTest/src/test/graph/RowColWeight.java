package test.graph;

/**
 * Created by Administrator on 2017/3/14 0014.
 */
public class RowColWeight {
    int row;//行下标
    int col;//列下标
    int weight;//权值
    public RowColWeight(int r,int c,int w){
        row = r;
        col = c;
        weight = w;
    }
    public static void createGraph(AdjMWGrap g,Object []v,int n,RowColWeight[]rc,int e)throws Exception {
        //static成员函数,用所给参数创建AdjMWGraph类对象g
        //v为结点的数据元素集合,n为结点个数,rc为边的集合,e为边的个数
        for (int i = 0; i < n; i++)
            g.insertVertics(v[i]);
        for (int k = 0; k < e; k++)
            g.insertEdge(rc[k].row, rc[k].col, rc[k].weight);
    }
}
