package UnionFind;

/*
 * This is to further improve the weighted quickUnion
 * So, along with balancing the tree, when we're looking,& trying to find the root of P. 
 * After we find it, we might as well just go back and make every node on that path just point to the root.
 *  That's going to be a constant extra cost. And will flaten the tree
 *  
 *  complexity : c (N + M lg* N)
 *  
 */
public class WeightedQuickUnionWithPathCompression extends WeightedQuickUnion{

	@Override
	protected int findRoot(int a) {
		while(nodes[a] != a) {
			nodes[a] = nodes[nodes[a]];
			a = nodes[a];
		}
		return a;
	}
}
