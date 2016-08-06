package com.jindal.trees;

public class InsertDeleteIntoBST {

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		BTNode btNode1 = new BTNode(10);
		BTNode btNode2 = new BTNode(9);
		BTNode btNode3 = new BTNode(8);
		BTNode btNode4 = new BTNode(7);
		BTNode btNode5 = new BTNode(6);
		BTNode btNode6 = new BTNode(5);
		BTNode btNode7 = new BTNode(4);
		BTNode btNode8 = new BTNode(3);
		BTNode btNode9 = new BTNode(2);
		BTNode btNode10 = new BTNode(1);

		BTNode btNode11 = new BTNode(11);
		BTNode btNode12 = new BTNode(12);
		BTNode btNode13 = new BTNode(13);
		BTNode btNode14 = new BTNode(14);
		BTNode btNode15 = new BTNode(15);
		BTNode btNode16 = new BTNode(16);

		binarySearchTree.insertNode(btNode10);
		binarySearchTree.insertNode(btNode9);
		binarySearchTree.insertNode(btNode8);
		binarySearchTree.insertNode(btNode7);

		binarySearchTree.insertNode(btNode6);
		binarySearchTree.insertNode(btNode5);
		binarySearchTree.insertNode(btNode4);
		binarySearchTree.insertNode(btNode3);
		binarySearchTree.insertNode(btNode2);
		binarySearchTree.insertNode(btNode1);

		binarySearchTree.insertNode(btNode11);
		binarySearchTree.insertNode(btNode12);
		binarySearchTree.insertNode(btNode13);
		binarySearchTree.insertNode(btNode14);
		binarySearchTree.insertNode(btNode15);
		binarySearchTree.insertNode(btNode16);

		binarySearchTree.doInorderTraversal();
		
		binarySearchTree.deleteNode(16);
		binarySearchTree.deleteNode(8);
		binarySearchTree.deleteNode(10);
		
		binarySearchTree.doInorderTraversal();
	}

}
