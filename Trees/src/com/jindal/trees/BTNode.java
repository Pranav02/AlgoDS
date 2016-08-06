package com.jindal.trees;

public class BTNode {

	private BTNode left;
	private BTNode right;
	private BTNode parent;
	private int key;
	private int height;

	public BTNode() {
		// TODO Auto-generated constructor stub
	}

	public BTNode(Integer key) {
		this.key = key;
		height = 1;

	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

	public BTNode getParent() {
		return parent;
	}

	public void setParent(BTNode parent) {
		this.parent = parent;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeightDifference() {
		int hd = 0;
		if (left != null) {
			hd = hd + left.height;
		}

		if (right != null) {
			hd = hd - right.height;
		}
		return hd;
	}

	public int maxChildHeight() {
		int maxHeight = 0;
		if (left != null) {
			maxHeight = left.getHeight();
		}
		if (right != null && right.getHeight() > maxHeight) {
			maxHeight = right.getHeight();
		}
		return maxHeight;
	}

}
