package UnionFind.examples;
/* Question Courtesy : Leet Code : 864
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N),
 * with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an 
 * edge that already existed.
 * The resulting graph is given as a 2D-array of edges. 
 * Each element of edges is a pair [u, v] with u < v, 
 * that represents an undirected edge connecting nodes u and v.
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. 
 * If there are multiple answers, return the answer that occurs last in the given 2D-array. 
 * The answer edge [u, v] should be in the same format, with u < v.
 */
public class RedundentConnection {
	int[] connections ;
    int [] height;
    public int[] findRedundantConnection(int[][] edges) {
        connections = new int[edges.length + 1];
        height = new int[edges.length + 1];
        
        for(int i = 0; i < connections.length; i++){
            connections[i] = i;
            height[i] = 0;
        }
        int[] res = new int[2];    
        for(int i = 0; i < edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            int sHead = getHead(connections, start);
            int eHead = getHead(connections, end);
            if( sHead == eHead ){
                res[0] = start;
                res[1] = end;
            }else if(height[ sHead ] < height[ eHead ]){
                connections[sHead] = eHead;
            }else{
                connections[eHead] = sHead;
                height[sHead]++;
            }
        }
        return res;
    }
    
    private int getHead(int[] tree, int node){
        while(tree[node] != node){
            node = tree[node];
            tree[node] = tree[tree[node]];
        }
        return node;
    }
}
