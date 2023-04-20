/* 
DFS Implementation
Given a connected undirected graph consisting of n vertices and e edges. All the edges are given in form of a
2-D matrix edges of size e * 2, where there is an undirected edge between edges[i][0] and edges[i][1] for all i ∈ {0, e-1}.

Perform a Depth First Traversal of the graph.

Note: When traversing the vertices of a graph, if vertex u is connected to a set of neighboring vertices {n1, n2, n3, ...},
then the traversal should proceed in the order of n1, n2, n3, ....; where n1 < n2 < n3 < ...

For example if vertex u has neighbours {3, 1, 4} then first traverse neighbouring node 1, then 3, and lastly 4 as 1 < 3 < 4. */

import java.util.*;

class Solution {
	public static void dfs(int src, ArrayList<Integer> [] graph, boolean[] visited){
		System.out.print(src + " ");
		visited[src] = true;
		Collections.sort(graph[src]);
		for(int nbr : graph[src]){
			if(visited[nbr] == false){
				dfs(nbr,graph,visited);
			}
		}
	}
    public static void DFSTraversal(List<List<Integer>> edges, int vertices) {
        ArrayList<Integer>[] graph = new ArrayList[vertices];
		for(int i = 0; i < vertices; i++){
			graph[i] = new ArrayList<>();
		}

		for(List<Integer> edge : edges){
			int v = edge.get(0);
			int u = edge.get(1);
			
			graph[u].add(v);
			graph[v].add(u);	
		}
		boolean[] visited = new boolean[vertices];
		dfs(0,graph,visited);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}
