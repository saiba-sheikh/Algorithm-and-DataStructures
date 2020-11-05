package UnionFind;

/*
 * This is an optimization over Eager/QuickFind, thus optimizing the union operation
 * Here the node relation/connections is represented as tree.
 * Example. 3,4 are connected then 3 is leaf node of 4. Similarly if 3, 7 are connected then we can say 4 is leaf of 7 thus connecting 3,4 and 7.
 * 
 * We will be using data structure similar to QuickFind: Array
 * And each index will point to its root, if no connection will hold value of itself
 * 
 * Cons:
 * 	Trees can grow huge in size thus or can be skewed, increasing the number of hops in find operation
 */
public class QuickUnion extends UnionFindAlgorithm{


	public void union(int a, int b) {
		//Worst case Complexity: O( N )
		System.out.println("Union : "+ a +" :: "+ b);
		int aId = findRoot(a);	
		int bId = findRoot(b);
		nodes[aId] = bId;
		System.out.println("Unioned");
	}

	private int findRoot(int a) {
		while(nodes[a] != a)
			a = nodes[a];
		return a;
	}


	public boolean find(int a, int b) {
		//Worst case Complexity: O( N )
		return findRoot(a) == findRoot(b);
	}

	public static void main(String[] args) {
		DriverProgram tester = new DriverProgram(new QuickUnion());
		tester.run();
	}
}
