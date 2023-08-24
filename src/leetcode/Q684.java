package leetcode;

public class Q684 {
    // 并查集——找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树
    public static void main(String[] args) {
        int[] res = new Q684().findRedundantConnection(new int[][]{{1,2}, {1,3}, {2,3}});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        int N = edges.length;
        DSU dsu = new DSU(N);
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            if (dsu.find(u) == dsu.find(v)) {
                res[0] = u;
                res[1] = v;
                break;
            }
            dsu.union(u, v);
        }
        return res;
    }

    // 并查集
    class DSU{
        // 初始化一个包含N个节点的数组，每个数组的头节点（父节点）为自己
        int[] parent;
        public DSU(int N){
            parent = new int[N+1];
            for(int i=0;i<N;i++){
                parent[i] = i;
            }
        }

        // 查找某个节点的头节点
        public int find(int x){
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        // 联通任意两个节点，即让他们的头节点相连
        public void union(int x,int y){
            parent[find(x)] = find(y);
        }
    }


}
