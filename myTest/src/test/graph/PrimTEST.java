package test.graph;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
public class PrimTest {
    static final int maxVertices = 100;
    public static void createGraph(AdjMWGrap g,Object[]v,int n,RowColWeight[]rc,int e)throws Exception{
        for (int i = 0;i<n;i++){
            g.insertVertics(v[i]);
        }
        for (int k = 0;k<e;k++){
            g.insertEdge(rc[k].row,rc[k].col,rc[k].weight);
        }
    }
    public static void main(String[]args){
        AdjMWGrap g = new AdjMWGrap(maxVertices);
        Character[]a = {new Character('A'),
                new Character('B'),
                new Character('C'),
                new Character('D'),
                new Character('E'),
                new Character('F'),
                new Character('G')};
        RowColWeight[]rcw = {new RowColWeight(0,1,50),
                new RowColWeight(1,0,50),
                new RowColWeight(0,2,60),
                new RowColWeight(2,0,60),
                new RowColWeight(1,3,65),
                new RowColWeight(3,1,65),
                new RowColWeight(1,4,40),
                new RowColWeight(4,1,40),
                new RowColWeight(2,3,52),
                new RowColWeight(3,2,52),
                new RowColWeight(2,6,45),
                new RowColWeight(6,2,45),
                new RowColWeight(3,4,50),
                new RowColWeight(4,3,50),
                new RowColWeight(3,5,30),
                new RowColWeight(5,3,30),
                new RowColWeight(3,6,42),
                new RowColWeight(6,3,42),
                new RowColWeight(4,5,70),
                new RowColWeight(5,4,70)};
        int n = 7,e = 20;
        try {
            createGraph(g,a,n,rcw,e);
            MinSpanTree[] closeVertex = new MinSpanTree[7];
            Prim.prim(g,closeVertex);
            //输出Prim函数得到的最小生成树的结点序列和权值序列
            System.out.println("初始顶点 = "+closeVertex[0].vertex);
            for (int i = 1;i<n;i++){
                System.out.print("顶点 = "+closeVertex[i].vertex);
                System.out.println("边的权值 = "+closeVertex[i].weight);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
