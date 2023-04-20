/* Possible Bipartition
We want to split a group of n people (labeled from 1 to n) into two groups of any size. 
Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi,
return true if it is possible to split everyone into two groups in this way. */

import java.util.*;

class Solution {
   boolean bfs(int src , ArrayList<Integer>[] graph, boolean[] visited,int[] path){
	   Queue<Integer> q = new LinkedList<>();
	   visited[src] = true;
	   path[src] = 0;
	   q.add(src);
	   while(q.size() > 0){
		    int size = q.size();
		   for(int i = 0; i < size ; i++){
			   int temp = q.remove();
			   for(int nbr : graph[temp]){
				   if(visited[nbr] == false){
					   q.add(nbr);
					   visited[nbr] = true;
					   path[nbr] = 1 - path[temp];
				   }
				   else if(visited[nbr] == true && path[temp] == path[nbr]) return false;
			   }
		   }
	   }
	   return true;
   }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[n];
		for(int i=0;i<n;i++){
			graph[i] = new ArrayList<>();
		}
		for(int[] e : dislikes){
			int u = e[0];
			int v = e[1];

			graph[u-1].add(v-1);
			graph[v-1].add(u-1);
		}
		boolean[] visited = new boolean[n];
		int[] path = new int[n];
		for(int i=0;i<n;i++){
			if(visited[i] == false){
				boolean check = bfs(i,graph,visited,path);
				if(check == false) return false;
			}
		}
		return true;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}
