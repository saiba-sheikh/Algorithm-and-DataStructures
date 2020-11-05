package UnionFind;
/*
 * THis is an improvement over UnionFind, where we avoid skewing of tree and balance it 
 * thus, assuring no node is too far from root
 * And thus, reducing both the union & find complexity to O(N + Mlog N )
 */
public class WeightedQuickUnion extends QuickUnion{
	int[] height;
	
	@Override
	public void initilize(int N) {
		height = new int[N + 1];
		nodes =  new int[N + 1];
		for(int i = 0; i <= N; i++) {
			nodes[i] = i; 
			height[i] = 0;
		}
	}
		
	@Override
	public void union(int a, int b) {
		//Complexity: O( log N )
		System.out.println("Union : "+ a +" :: "+ b);
		int aId = findRoot(a);	
		int bId = findRoot(b);
		if(height[aId] < height[bId]) {
			nodes[aId] = nodes[bId];
		}
		else {
			nodes[bId] = nodes[aId];
			height[aId]++;
		}
		System.out.println("Unioned");
	}
	
	
	protected int findRoot(int a) {
		while(nodes[a] != a) {
			a = nodes[a];
		}
		return a;
	}

}
