package UnionFind;

/*
 * 
 * This algorithm aims to find the connected components in given network/connections
 * This is a basic algorithm for union find
 * Also known as Quick-Find
 * 
 * Cons:
 * In cases where there N nodes & N union op then union's complexity will be O( n2 )
 * */
public class EagerAlgorithm extends UnionFindAlgorithm{
/*
 * Problem statement: Given pair of nodes in range, find if query nodes are reachable.
 * Input: N : total number of nodes
 * M: number of lines with input of connected nodes
 * n1,m1
 * n2,m2,...nM,mM - Pair of connected components
 * 
 * q1,q2 : - query nodes to check if q1 is reachable from q2 or vice versa
 */

	@Override
	public void initilize(int n) {
		nodes = new int[n];
		for(int i =0;i<n; i++) {
			nodes[i] = i+1;
		}
	}
	public void union(int m,int n) {
		System.out.println("Union : "+ m +" :: "+ n);
		if(nodes[m-1] != nodes[n-1]) {
			updateLink(nodes[m-1],nodes[n-1] );
		}
	}

	public boolean find(int a, int b) {
		/*
		 * Complexity : O(1)
		 */
		return nodes[a] == nodes[b];
	}
	private void updateLink(int val, int newVal) {
		/*
		 * Complexity: O ( n )
		 */
		for(int i = 0;i< nodes.length; i++) {
			if(nodes[i] == val) {
				nodes[i] = newVal;
			}
		}
	}
	
	public static void main(String[] args) {
		DriverProgram tester = new DriverProgram(new EagerAlgorithm());
		tester.run();
	}

	
}