package com.jindal.trees;

public class BinarySearchTree {

	private BTNode root;

	public BTNode getRoot() {
		return root;
	}

	public void setRoot(BTNode root) {
		this.root = root;
	}

	public void insertNode(BTNode node) {
		this.root = insert(node, this.root, null);
	}

	public void deleteNode(int key) {
		this.root = deleteNode(key, this.root);
	}

	private BTNode deleteNode(int key, BTNode root) {
		if (root == null) {
			return null;
		}
		if (key == root.getKey()) {
			return actualDeleteNode(root);

		}
		if (key < root.getKey()) {
			root.setLeft(deleteNode(key, root.getLeft()));
		} else {
			root.setRight(deleteNode(key, root.getRight()));
		}

		root.setHeight(1 + root.maxChildHeight());

		int hd = root.getHeightDifference();

		if (hd > 1 && root.getLeft() != null && root.getLeft().getHeightDifference() >= 0) { // left-left
			root = rightRotate(root);
		} else if (hd > 1 && root.getLeft() != null && root.getLeft().getHeightDifference() < 0) { // left-right
			root.setLeft(leftRotate(root.getLeft()));
			root = rightRotate(root);
		} else if (hd < -1 && root.getLeft() != null && root.getLeft().getHeightDifference() <= 0) { // right-right
			root = leftRotate(root);
		} else if (hd < -1 && root.getLeft() != null && root.getLeft().getHeightDifference() > 0) { // right-left
			root.setRight(rightRotate(root.getRight()));
			root = leftRotate(root);
		}
		return root;

	}

	private BTNode actualDeleteNode(BTNode node) {
		if (node.getLeft() == null || node.getRight() == null) {
			BTNode replaceBy = node.getLeft() == null ? node.getRight() : node.getLeft();
			replaceZWithX(node, replaceBy);
			return replaceBy;
		}

		BTNode replaceBy = leftMin(node.getRight());

		if (replaceBy != node.getRight()) {
			replaceZWithX(replaceBy, replaceBy.getRight());
			replaceBy.setRight(node.getRight());
			replaceBy.getRight().setParent(replaceBy);
		}
		replaceZWithX(node, replaceBy);
		replaceBy.setLeft(node.getLeft());
		replaceBy.getLeft().setParent(replaceBy);
		return replaceBy;
	}

	private BTNode rightMax(BTNode root) {
		if (root == null) {
			return null;
		}
		if (root.getRight() == null) {
			return root;
		}
		return rightMax(root.getRight());
	}

	/**
	 * 
	 * @param z
	 * @param x
	 * 
	 *            z = has either left or right child(only one child) x = either
	 *            left or right child.
	 */
	private void replaceZWithX(BTNode z, BTNode x) {
		BTNode zParent = z.getParent();
		if (zParent != null) {
			if (zParent.getLeft() == z) {
				zParent.setLeft(x);
			} else {
				zParent.setRight(x);
			}
		}
		if (x != null) {
			x.setParent(zParent);
		}
	}

	private BTNode leftMin(BTNode node) {
		if (node == null) {
			return null;
		}
		if (node.getLeft() == null) {
			return node;
		}
		return leftMin(node.getLeft());
	}

	private BTNode insert(BTNode node, BTNode root, BTNode parent) {
		if (root == null) {
			node.setParent(parent);
			return node;
		}
		if (node.getKey() <= root.getKey()) {
			root.setLeft(insert(node, root.getLeft(), root));
		} else {
			root.setRight(insert(node, root.getRight(), root));
		}
		root.setHeight(1 + root.maxChildHeight());

		int hd = root.getHeightDifference();

		if (hd > 1) {// left heavy
			if (node.getKey() < root.getLeft().getKey()) {// left-left
															// heavy
				return rightRotate(root);
			} else if (node.getKey() > root.getLeft().getKey()) {
				root.setLeft(leftRotate(root.getLeft()));
				return rightRotate(root);
			}
		} else if (hd < -1) {// right heavy
			if (node.getKey() > root.getRight().getKey()) { // right-right
															// heavy
				return leftRotate(root);
			} else if (node.getKey() < root.getRight().getKey()) { // right-left
																	// heavy
				root.setRight(rightRotate(root.getRight()));
				return leftRotate(root);
			}
		}
		return root;
	}

	private BTNode rightRotate(BTNode root) {
		BTNode rootLeft = root.getLeft();
		BTNode T = rootLeft.getRight();

		BTNode rootParent = root.getParent();

		rootLeft.setParent(root.getParent());
		root.setParent(rootLeft);

		if (rootParent != null) {
			if (rootParent.getLeft() == root) {
				rootParent.setLeft(rootLeft);
			} else {
				rootParent.setRight(rootLeft);
			}
		}

		root.setLeft(T);
		rootLeft.setRight(root);

		root.setHeight(root.maxChildHeight() + 1);
		rootLeft.setHeight(rootLeft.maxChildHeight() + 1);

		return rootLeft;
	}

	private BTNode leftRotate(BTNode root) {
		BTNode rootRight = root.getRight();
		BTNode T = rootRight.getLeft();

		BTNode rootParent = root.getParent();

		rootRight.setParent(root.getParent());
		root.setParent(rootRight);

		if (rootParent != null) {
			if (rootParent.getLeft() == root) {
				rootParent.setLeft(rootRight);
			} else {
				rootParent.setRight(rootRight);
			}
		}

		root.setRight(T);
		rootRight.setLeft(root);

		root.setHeight(root.maxChildHeight() + 1);
		rootRight.setHeight(rootRight.maxChildHeight() + 1);

		return rootRight;
	}

	public void doInorderTraversal() {
		traverseInorder(this.root);
	}

	public void doPreorderTraversal() {
		traversePreorder(this.root);
	}

	public void doPostorderTraversal() {
		traversePostorder(this.root);
	}

	private void traverseInorder(BTNode node) {
		if (node == null) {
			return;
		}
		traverseInorder(node.getLeft());
		System.out.println(node.getKey());
		traverseInorder(node.getRight());
	}

	private void traversePreorder(BTNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.getKey());
		traverseInorder(node.getLeft());
		traverseInorder(node.getRight());
	}

	private void traversePostorder(BTNode node) {
		if (node == null) {
			return;
		}
		traverseInorder(node.getLeft());
		traverseInorder(node.getRight());
		System.out.println(node.getKey());
	}
}
