/* Count components
You are given an undirected graph with N vertices. You have to find the number of connected components in the graph.

A set of vertices forms a connected component in an undirected graph if any vertex from the set of vertices can reach any other vertex by traversing edges. */

import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            String S[] = read.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<N; j++)
                temp.add(Integer.parseInt(S[j]));
            adj.add(temp);
        }

        Solution ob = new Solution();
        System.out.println(ob.components(adj,N));
    }
}

class Solution {
	void dfs(ArrayList<ArrayList<Integer>> adj,int src, boolean visited[]){
		visited[src]=true;
		int n = adj.size();
		for(int nbr = 0; nbr < n ; nbr++){
			if(visited[nbr]==false && adj.get(src).get(nbr)==1){
				dfs(adj,nbr,visited);
			}
		}
	}
    int components(ArrayList<ArrayList<Integer>> adj, int vertices) {
        boolean[] visited = new boolean[vertices];
		int count = 0;
		for(int i=0;i<vertices;i++){
			if(visited[i]==false){
				dfs(adj,i,visited);
				count++;
			}
		}
		return count;
    }
};
