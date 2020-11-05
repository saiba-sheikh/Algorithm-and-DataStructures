package UnionFind;

import java.util.Scanner;

public class DriverProgram {
	UnionFindAlgorithm algorithm;

public DriverProgram(UnionFindAlgorithm algorithm) {
	this.algorithm = algorithm;
}

public void run()
{
	/*
	 * Ignore code duplication in driver program
	 */
	Scanner sn = new Scanner(System.in);
	int N = sn.nextInt();
	algorithm.initilize(N);
	int M = sn.nextInt();
	for(int i = 0;i < M; i++) {
		String str = sn.next();
		String[] input = str.split(",");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		algorithm.union(a, b);
	}
	algorithm.print();
	String str = sn.next();
	String[] input = str.split(",");
	int a = Integer.parseInt(input[0]);
	int b = Integer.parseInt(input[1]);
	System.out.println(algorithm.find(a, b));
	sn.close();	
}
}
