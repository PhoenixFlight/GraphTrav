public class Graph<T> {
	private Node<T> current;
	public Graph() {
		current = new Node<T>();
	}
	public Graph(T val) {
		current = new Node<T>(val);
	}
	public Graph(Node<T> root) {
		current = root;
	}
	public void setLocation(Node<T> n) { current = n; }
	public Node<T> getCurrent() { return current; }
	public void add(Node<T> newNode) { new Edge<T>(current, newNode); }
}
