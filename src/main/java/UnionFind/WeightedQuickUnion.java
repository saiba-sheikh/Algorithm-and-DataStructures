package UnionFind;
/*
 * THis is an improvement over UnionFind, where we avoid skewing of tree and balance it 
 * thus, assuring no node is too far from root
 * And thus, reducing both the union & find complexity to O(N + Mlog N )
 */
public class WeightedQuickUnion extends QuickUnion{

	@Override
	public void union(int a, int b) {
		//Complexity: O( log N )
		System.out.println("Union : "+ a +" :: "+ b);
		Height aId = findRoot(a);	
		Height bId = findRoot(b);
		if(aId.height > bId.height) {
			nodes[aId.root] = nodes[bId.root];
		}
		else
			nodes[bId.root] = nodes[aId.root];

		System.out.println("Unioned");
	}
	
	
	protected Height findRoot(int a) {
		int height = 1;
		while(nodes[a] != a) {
			a = nodes[a];
			height++;
		}
		return new Height(a, height);
	}
	class Height{
		int root;
		int height;
		Height(int root, int height){
			this.root = root;
			this.height = height;
		}
	}
}
