package rizzutih.Exercises;

public class Node {
	

	public int data;
	public Node leftChild;
	public Node rightChild;
	
	public Node(int data){
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}
