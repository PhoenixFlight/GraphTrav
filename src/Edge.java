
public class Edge<T> {
	private Node<T> left, right;
	public Edge() {
		this(null, null);
	}
	public Edge(Node<T> n1, Node<T> n2) {
		left = n1;
		right = n2;
		n1.add(this);
		n2.add(this);
	}
	public Node<T> getLeft() { return left; }
	public Node<T> getRight() { return right; }
	public Node<T> getOther(Node<T> given) { return given.equals(left) ? right : left; }
	public String toString() {
		return left + " <---> " + right;
	}
}