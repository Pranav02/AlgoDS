package com.pjindal.graphs;

import com.pjindal.graphs.Node.EdgeNode;

public class DFS {

	private Node[] adjacenyList;
	private int n;// number of nodes

	boolean visited[];
	boolean completed[];

	public DFS(int n) {
		adjacenyList = new Node[n];
		visited = new boolean[n];
		completed = new boolean[n];
		this.n = n;
	}

	public void populateGraph(Pair[] pairs) {
		for (Pair pair : pairs) {
			int first = pair.getFirst();
			int second = pair.getSecond();

			Node firstNode = adjacenyList[first];
			Node secondNode = adjacenyList[second];

			if (firstNode == null) {
				Node newNode = new Node();
				newNode.setIndex(first);
				firstNode = newNode;
				adjacenyList[first] = newNode;
			}

			if (secondNode == null) {
				Node newNode = new Node();
				newNode.setIndex(second);
				secondNode = newNode;
				adjacenyList[second] = newNode;
			}

			EdgeNode edgeNode = new EdgeNode(second, firstNode.getEdgeNode());
			firstNode.setEdgeNode(edgeNode);

			EdgeNode edgeNode2 = new EdgeNode(first, secondNode.getEdgeNode());
			secondNode.setEdgeNode(edgeNode2);
		}
	}

	public void performDFS() {
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				doDFS(i);
			}
		}

		for (int i = 0; i < n; i++) {
			visited[i] = false;
		}
	}

	private void doDFS(int node) {
		System.out.println(node);
		EdgeNode edgeNode = adjacenyList[node].getEdgeNode();
		while (edgeNode != null) {
			if (!visited[edgeNode.getNodeIndex()]) {
				visited[edgeNode.getNodeIndex()] = true;
				doDFS(edgeNode.getNodeIndex());
			}
			edgeNode = edgeNode.getNextEdgeNode();
		}
		completed[node] = true;
	}

}
