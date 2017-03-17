package test.graph;

import test.tree.Visit;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
public class DepthAndBroadTest {
    public static void createGraph(AdjMWGrap g,Object[]v,int n,RowColWeight[]rc,int e)throws Exception{
        for (int i = 0;i<n;i++){
            g.insertVertics(v[i]);
        }
        for (int k = 0;k<e;k++){
            g.insertEdge(rc[k].row, rc[k].col, rc[k].weight);
        }
    }
    public static void main(String[] args){
        final int maxVertics = 100;
        Visit vs = new Visit();
        AdjMWGrap g = new AdjMWGrap(maxVertics);
        Character[]a = {new Character('A'),
                        new Character('B'),
                        new Character('C'),
                        new Character('D'),
                        new Character('E'),};
        RowColWeight[] rcw = {new RowColWeight(0,1,10),
                        new RowColWeight(0,4,20),
                        new RowColWeight(1,3,30),
                        new RowColWeight(2,1,40),
                        new RowColWeight(3,2,50)};
        int n = 5,e = 5;
        try {
            createGraph(g,a,n,rcw,e);
            System.out.print("深度优先搜索序列为:");
            g.depthFirstSearch(vs);
            System.out.println();

            System.out.print("广度优先搜索为:");
            g.broadFirstSearch(vs);
            System.out.println();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
