package rizzutih.Exercises;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	Node root = null;
	List<Node> nodes = new ArrayList<Node>();

	public Node add(int data) {
		Node nodeToAdd = getNewNode(data);
		if(root == null){
			root = nodeToAdd;
		}
		traverseAndAddNode(root,nodeToAdd);
		return root;
	}

	private void traverseAndAddNode(Node node, Node nodeToAdd) {
		if(nodeToAdd.data < node.data){
			if(node.leftChild==null){
				node.leftChild =nodeToAdd ;
			}else{
				traverseAndAddNode(node.leftChild,nodeToAdd);
			}
		}else if(nodeToAdd.data > node.data){
			if(node.rightChild==null){
				node.rightChild =nodeToAdd ;
			}else{
				traverseAndAddNode(node.rightChild,nodeToAdd);
			}
		}
	}

	public Node getNewNode(int data) {
		return new Node(data);
	}

	public List<Node> traverse() {
		Node subTree;
		if(root != null){
			subTree = root;
			if(subTree.leftChild != null){
				InOderTraversal(subTree.leftChild);
			}
			nodes.add(root);	System.out.println(root);
			if(subTree.rightChild !=null){
				InOderTraversal(subTree.rightChild);
			}
		}
		return nodes;
	}

	private void InOderTraversal(Node subTree) {
		if(subTree.leftChild !=null){
			InOderTraversal(subTree.leftChild);
		}
		nodes.add(subTree);System.out.println(subTree);
		if(subTree.rightChild !=null){
			InOderTraversal(subTree.rightChild);
		}
	}
}