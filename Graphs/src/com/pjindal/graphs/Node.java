package com.pjindal.graphs;

public class Node {
	private EdgeNode edgeNode;
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}

	public EdgeNode getEdgeNode() {
		return edgeNode;
	}

	public void setEdgeNode(EdgeNode edgeNode) {
		this.edgeNode = edgeNode;
	}

	@Override
	public String toString() {
		return "Node [edgeNode=" + edgeNode + ", index=" + index + "]";
	}

	public static class EdgeNode {
		private int nodeIndex;
		private EdgeNode nextEdgeNode;

		public EdgeNode() {
			// TODO Auto-generated constructor stub
		}

		public EdgeNode(int nodeIndex, EdgeNode nextEdgeNode) {
			this.nodeIndex = nodeIndex;
			this.nextEdgeNode = nextEdgeNode;
		}

		public int getNodeIndex() {
			return nodeIndex;
		}

		public void setNodeIndex(int nodeIndex) {
			this.nodeIndex = nodeIndex;
		}

		public EdgeNode getNextEdgeNode() {
			return nextEdgeNode;
		}

		public void setNextEdgeNode(EdgeNode nextEdgeNode) {
			this.nextEdgeNode = nextEdgeNode;
		}

		@Override
		public String toString() {
			return "EdgeNode [nodeIndex=" + nodeIndex + ", nextEdgeNode=" + nextEdgeNode + "]";
		}

	}
}
