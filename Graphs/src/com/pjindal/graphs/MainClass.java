package com.pjindal.graphs;

public class MainClass {

	public static void main(String[] args) {

		BFS bfs = new BFS(11);
		Pair[] pairs = { new Pair(0, 1), new Pair(0, 2), new Pair(0, 3), new Pair(1, 3), new Pair(1, 2), new Pair(1, 5),
				new Pair(2, 5), new Pair(2, 4), new Pair(2, 7), new Pair(2, 3), new Pair(3, 6), new Pair(6, 7),
				new Pair(3, 9), new Pair(7, 8), new Pair(9, 8), new Pair(9, 10) };
		
		bfs.populateGraph(pairs);
		
		DFS dfs = new  DFS(11);
		dfs.populateGraph(pairs);
		dfs.performDFS();
	}

}
