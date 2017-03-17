package test.graph;

/**
 * 狄克斯特拉算法vs佛洛依德算法
 * Created by Administrator on 2017/3/18 0018.
 */
public class Dijkstra {
    static final int maxWeight = 9999;
    public static void dijkstra(AdjMWGrap g,int v0,int[] distance,int path[])throws Exception{
        //带权图g从下标为v0的结点到其他结点的最短距离distance
        //和相应的目标结点的前一结点下标path
        int n = g.getNumOfVertices();
        int[] s = new int[n];
        int minDis,u = 0;
        //初始化
        for (int i = 0;i<n;i++){
            distance[i] = g.getWeight(v0,i);
            s[i] = 0;//初始都标记为0
            if (i!=v0&&distance[i]<maxWeight)
                path[i] = v0;
            else
                path[i] = -1;
        }
        s[v0] = 1;
        //在当前还未找到最短路径的结点集中选取具有最短距离的结点u
        for (int i = 1;i<n;i++){
            minDis = maxWeight;
            for (int j = 0;j<n;j++) {
                if (s[j] == 0 && distance[j] < minDis) {
                    u = j;
                    minDis = distance[j];
                }
            }
                //当已不存在路径时算法结束,此语句对非连通图是必须的
                if (minDis==maxWeight)return;
                s[u] = 1;//标记结点u已从集合T加入到集合S中
                //修改从v0到其他结点的最短距离和最短路径
                for (int j = 0;j<n;j++){
                    if (s[j]==0&&g.getWeight(u,j)<maxWeight&&distance[u]+g.getWeight(u,j)<distance[j]){
                        distance[j] = distance[u]+g.getWeight(u,j);
                        path[j] = u;
                    }
                }
        }
    }
}
