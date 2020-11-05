package UnionFind;

import java.util.Arrays;

public abstract class UnionFindAlgorithm {
	int[] nodes;
	
	abstract void union(int a,int b);
	
	public void print() {
		System.out.println(Arrays.toString(nodes));
	}
	
	abstract boolean find(int a, int b);
	

	public void initilize(int N) {
		//Complexity : O(N)
		nodes = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			nodes[i] = i; 
		}
		
	}
}
