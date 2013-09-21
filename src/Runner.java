import java.util.ArrayList;
import java.util.HashSet;

public class Runner {
	public static void main(String[] args) {
		Node<String> n1 = new Node<String>("Hello");
		Node<String> n2 = new Node<String>("World!");
		Node<String> n3 = new Node<String>("Test 1");
		Node<String> n4 = new Node<String>("Test 2");
		Node<String> n5 = new Node<String>("Test 3");
		Node<String> n6 = new Node<String>("Test 4");
		Node<String> n7 = new Node<String>("Test 5");
		Node<String> n8 = new Node<String>("Test 6");
		Node<String> n9 = new Node<String>("Test 7");
		Node<String> n10 = new Node<String>("Test 8");
		Graph<String> g = new Graph<String>(n1);
		g.add(n2);
		g.add(n3);
		g.add(n4);
		g.add(n5);
		g.add(n6);
		g.setLocation(n2);
		g.add(n4);
		g.setLocation(n3);
		g.add(n10);
		g.add(n6);
		g.add(n8);
		g.setLocation(n8);
		g.add(n9);
		g.setLocation(n5);
		g.add(n4);
		g.add(n7);
		g.setLocation(n10);
		g.add(n9);
		g.setLocation(n1);
		//recursivePrint(g.getCurrent(), new HashSet<Node<String>>());
		ArrayList<Edge<String>> best = new ArrayList<Edge<String>>();
		traceRoute(g.getCurrent(), n8, new ArrayList<Edge<String>>(), best, new HashSet<Node<String>>());
		System.out.println(best);
	}
	private static void recursivePrint(Node<String> cur, HashSet<Node<String>> checked) {
		System.err.println(cur);
		checked.add(cur);
		for(Edge<String> e : cur.getEdges()) {
			Node<String> next = e.getLeft() == cur ? e.getRight() : e.getLeft();
			//System.out.println(next + " ~ " + checked);
			if(!checked.contains(next))
				recursivePrint(next, checked);
		}
	}
	public static void traceRoute(
			  Node<String> root
			, Node<String> dest
			, ArrayList<Edge<String>> path
			, ArrayList<Edge<String>> best
			, HashSet<Node<String>> checked) {
		System.out.println(root);
		System.out.println(path);
		System.out.println(best);
		checked.add(root);
		if(root.equals(dest)) {
			if(path.size() < best.size()) {
				best.clear();
				best.addAll(path);
			}
			checked.remove(root);
			return;
		}
		if(path.size() > best.size() && best.size() != 0) {
			checked.remove(root);
			return;
		}
		for(Edge<String> e : root.getEdges()) {
			if(path.contains(e.getOther(root)))
				continue;
			path.add(e);
			traceRoute(e.getOther(root), dest, path, best, checked);
			path.remove(e);
		}
		path.remove(root);
	}
}
