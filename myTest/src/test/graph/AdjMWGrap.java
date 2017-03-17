package test.graph;

import test.array.SeqList;
import test.queue.SeqQueue;
import test.tree.Visit;

/**
 * 邻接矩阵图类
 * Created by Administrator on 2017/3/14 0014.
 */
public class AdjMWGrap {
    static final int maxWeight = 10000;
    private SeqList verices;//存储结点的顺序表
    private int[][]edge;//存储边的二维数组
    private int numOfEdge;//边的个数
    public AdjMWGrap(int maxV){//构造函数,maxV为结点个数
        verices = new SeqList(maxV);//创建顺序表vertices
        edge = new int[maxV][maxV];//创建二维数组edge
        for (int i = 0;i<maxV;i++){
            for (int j = 0;j<maxV;j++){
                if (i==j)edge[i][j] = 0;
                else edge[i][j] = maxWeight;
            }
        }
        numOfEdge = 0;
    }
    public int getNumOfVertices(){
        return verices.size;//返回结点的个数
    }
    public int getNumOfEdges(){
        return numOfEdge;//返回边的个数
    }
    public Object getValue(int v)throws Exception{
        return verices.getData(v);
    }
    public int getWeight(int v1,int v2)throws Exception{
        //返回边<v1,v2>的权值
        if (v1<0||v1>=verices.size||v2<0||v2>=verices.size){
            throw new Exception("参数v1或v2越界出错!");
        }
        return edge[v1][v2];
    }
    public void insertVertics(Object vertex)throws Exception{
        //插入结点
        verices.insert(verices.size,vertex);
    }
    public void insertEdge(int v1,int v2,int weight)throws Exception{
        //插入边<v1,v2>,权值为weight
        if (v1<0||v1>=verices.size||v2<0||v2>=verices.size)
            throw new Exception("参数v1或v2越界出错!");
        edge[v1][v2] = weight;
        numOfEdge++;
    }
    public void deleteEdge(int v1,int v2)throws Exception{
        //删除边<v1,v2>
        if (v1<0||v1>verices.size||v2<0||v2>verices.size)
            throw new Exception("参数v1或v2越界出错!");
        if (edge[v1][v2] == maxWeight||v1==v2){
            throw new Exception("该边不存在!");
        }
        edge[v1][v2] = maxWeight;
        numOfEdge--;
    }
    public int getFirstNeighbor(int v)throws Exception{
        //取结点v的第一个邻接结点,若存在返回该结点的下标序号,否则返回-1
        if (v<0||v>=verices.size)
            throw new Exception("参数v越界出错!");
        for (int col = 0;col<verices.size;col++){
            if (edge[v][col]>0&&edge[v][col]<maxWeight)
                return col;
        }
            return -1;
    }
    public int getNextNeighbor(int v1,int v2)throws Exception{
        //取结点v的第一个邻接结点,若存在返回该结点的下标序号,否则返回-1
        if (v1<0||v1>=verices.size||v2<0||v2>=verices.size)
            throw new Exception("参数v1或v2越界出错!");
        for (int col = v2+1;col<verices.size;col++){
            if (edge[v1][col]>0&&edge[v1][col]<maxWeight)
                return col;
        }
        return -1;
    }
    //图的遍历算法
    private void depthFirstSearch(int v,boolean []visited,Visit vs)throws Exception{
        //连通图以v为初始结点序号,访问操作为vs的深度优先遍历
        //数组visited标记了相应结点是否已访问过,0表示未访问,1表示已访问
        vs.print(getValue(v));//访问该结点
        visited[v] = true;//置为已访问标记
        int w = getFirstNeighbor(v);//取第一个邻接结点
        while (w!=-1){//当邻接结点存在时循环
            if (!visited[w])//如果没有访问过
                depthFirstSearch(w,visited,vs);//以w为初始结点递归
            w = getNextNeighbor(v,w);//取下一个邻接结点
        }
    }
    private void broadFirstSearch(int v,boolean[]visited,Visit vs)throws Exception{
        //连通图以v为初始结点序号,访问操作为vs的广度优先遍历
        //数组visited标记了相应结点是否已访问过,0表示未访问,1表示已访问
        int u,w;
        SeqQueue queue = new SeqQueue();//创建顺序队列queue
        vs.print(getValue(v));//访问结点v
        visited[v] = true;//置为已访问过标记
        queue.append(new Integer(v));//结点v入队列
        while (queue.notEmpty()){//队列非空时循环
            u = ((Integer)queue.delete()).intValue();//出队列
            w = getFirstNeighbor(u);//取结点u的第一个邻接结点
            while (w!=-1){//当邻接结点存在时循环
                if (!visited[w]){//若该结点没有访问过
                    vs.print(getValue(w));//访问结点w
                    visited[w] = true;//置已访问标记
                    queue.append(new Integer(w));//结点w入队列
                }
                //取结点u的邻接结点w的下一个邻接结点
                w = getNextNeighbor(u,w);
            }
        }
    }

    public void depthFirstSearch(Visit vs)throws Exception{
        //非连通图的深度优先遍历
        boolean[]visited = new boolean[getNumOfVertices()];
        for (int i = 0;i<getNumOfVertices();i++){
            visited[i] = false;//置所有结点都没有访问过
        }
        for (int i = 0;i<getNumOfVertices();i++){//循环每个结点
            if (!visited[i]){//如果该结点未访问
                depthFirstSearch(i,visited,vs);//以结点i为初始结点深度优先遍历
            }
        }
    }

    public void broadFirstSearch(Visit vs)throws Exception{
        //非连通图的广度优先遍历
        boolean[]visited = new boolean[getNumOfVertices()];
        for (int i = 0;i<getNumOfVertices();i++)
            visited[i] = false;//置所有结点都没有访问过
        for (int i = 0;i<getNumOfVertices();i++){
            if (!visited[i])//如果该结点没有访问过
                broadFirstSearch(i,visited,vs);//以结点i为初始结点广度优先遍历
        }
    }
}
