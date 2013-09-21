import java.util.ArrayList;

public class Node<T> {
	private ArrayList<Edge<T>> edges;
	private T value;
	public Node() {
		this(null, new ArrayList<Edge<T>>());
	}
	public Node(T val) {
		this(val, new ArrayList<Edge<T>>());
	}
	public Node(T val, ArrayList<Edge<T>> edges) {
		this.edges = edges;
		this.value = val;
	}
	public T getValue() { return value; }
	public ArrayList<Edge<T>> getEdges() { return edges; }
	public void add(Edge<T> toAdd) {
		edges.add(toAdd);
	}
	public String toString() {
		return value.toString();
	}
}