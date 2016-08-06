package com.pjindal.graphs;

import java.util.LinkedList;
import java.util.Queue;

import com.pjindal.graphs.Node.EdgeNode;

public class BFS {

	private Node[] adjacenyList;
	private int n;// number of nodes
	private Queue<Integer> queue;

	boolean visited[];
	boolean completed[];

	public BFS(int n) {
		adjacenyList = new Node[n];
		queue = new LinkedList<Integer>();
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

	void performBFS(int node) {
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				doBFS(i);
			}
		}

		for (int i = 0; i < n; i++) {
			visited[i] = false;
		}
	}

	void doBFS(int node) {
		System.out.println(node);
		visited[node] = true;
		EdgeNode edgeNode = adjacenyList[node].getEdgeNode();
		while (edgeNode != null) {
			if (!visited[edgeNode.getNodeIndex()]) {
				queue.add(edgeNode.getNodeIndex());
				visited[edgeNode.getNodeIndex()] = true;
			}
			edgeNode = edgeNode.getNextEdgeNode();
		}
		completed[node] = true;
		if (!queue.isEmpty()) {
			doBFS(queue.poll());
		}

	}

}
