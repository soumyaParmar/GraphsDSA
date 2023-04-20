/* Path between 2 vertices
Given an undirected graph of with N vertices and V edges, Your task is to find out if the path exist between 2 vertices in this graph, return true, else false. */


import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        int U=sc.nextInt();
        int V=sc.nextInt();
        Solution ob = new Solution();
        if (ob.check(N, M, Edges,U,V)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        sc.close();
    }

}

class Solution {
	boolean dfs(int src, int dest, ArrayList<Integer>[] graph, boolean[] visited){
        if(src == dest) return true;
		
		visited[src] = true;
		for(int nbr : graph[src]){
			if(visited[nbr]==false){
				boolean check = dfs(nbr ,dest, graph, visited);
				if(check == true) return true;
			}
		}
		return false;
	}
    
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges,int U,int V) {
        ArrayList<Integer> [] graph = new ArrayList[N+1];
		for(int i=0;i<=N;i++){
			graph[i] = new ArrayList<>();
		}
		for(List<Integer> edge : Edges){
			int u = edge.get(0);
			int v = edge.get(1);

			graph[u].add(v);
			graph[v].add(u);
		}
		boolean[] visited = new boolean[N+1];
		return dfs(U,V,graph,visited);
       
    }
}
