package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Node implements Comparable<Node> {
	String name;
	HashMap<Node, Integer> neighbors = new HashMap<>();
	int cost;
	public Node(String n) {
		name = n;
		cost = -1; 
	}
	
	@Override
	public int compareTo(Node n) {
		if (n.cost > this.cost){
			return -1;
		}
		else if (n.cost < this.cost) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Node)) {
			return false;
		}
		Node n = (Node) o;
		return n.name.equals(this.name);
	}
	
	
	
		
	
	public String toString() {
		return "Node: " + name;	
	}
	
	public int getShortestPathLength(String endNodeName) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		this.cost = 0;
		q.add(this);
		while (!q.isEmpty()) {
			Node n = q.remove();
			if(n.name.equals(endNodeName)) {
				return n.cost;
			}
			for (Map.Entry<Node,Integer> neighborPair : n.neighbors.entrySet()) {
				Node neighbor = neighborPair.getKey();
				int newCost = n.cost + neighborPair.getValue();
				if (neighbor.cost == -1 || newCost < neighbor.cost) {
					  neighbor.cost = newCost;
				}
				if (!q.contains(neighbor)) {
					q.add(neighbor);
				}
			}
		}
		
		return -1;
	}
}



	
