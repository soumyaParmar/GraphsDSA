/* Detect cycle in an undirected graph
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. */

import java.io.*;
import java.util.*;

class Solution {
	static boolean dfs(int src,int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
		visited[src] = true;
		for(int nbr : adj.get(src)){
			if(visited[nbr]==false){
				boolean check = dfs(nbr,src,adj,visited);
				if(check == true) return true;
			}
			else if(visited[nbr]==true && nbr != parent) return true;
		}
		return false;
	} 
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       //ArrayList<Integer>[] graph = new ArrayList[V];
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++){
			if(visited[i]==false){
				boolean check = dfs(i,-1,adj,visited);
				if(check == true) return true;
			}
		}
		return false;
		
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
