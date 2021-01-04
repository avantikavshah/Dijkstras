package graph;

public class Main {

	public static void main(String[] args) {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node start = new Node ("Start");
		Node end = new Node("End");
		
		a.neighbors.put(b,1);
		b.neighbors.put(end, 5);
		c.neighbors.put(end, 2);
		d.neighbors.put(end, 4);
		start.neighbors.put(a, 1);
		start.neighbors.put(c,3);
		start.neighbors.put(d,2);									
		
		System.out.println("Starting getting shortest path");
		int length = start.getShortestPathLength(end.name);
		System.out.println(length);
	}

}
