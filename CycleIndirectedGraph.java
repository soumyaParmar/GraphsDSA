/* Detect cycle in a directed graph
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not. */


import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	boolean dfs(int src, ArrayList<Integer>[] adj,boolean[] visited, boolean[] path){
		visited[src] = true;
		path[src] = true;
		for(int nbr : adj[src]){
			if(visited[nbr]==false){
				boolean check = dfs(nbr,adj,visited,path);
				if(check == true) return true;
			}
			else if(visited[nbr] && path[nbr]) return true;
		}
		path[src] = false;
		return false;
	}
public boolean isCyclic(int V, ArrayList<Integer>[] adj) {
    boolean[] visited = new boolean[V];
	boolean[] path = new boolean[V];
	for(int i=0;i<V;i++){
		boolean check = dfs(i,adj,visited,path);
		if(check == true) return true;
	}
	return false;
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
