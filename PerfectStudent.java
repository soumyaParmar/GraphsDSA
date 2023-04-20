/* Perfect Students
You are given a number n (representing the number of students). Each student will have an
id from 0 to n - 1. You are given a number k (representing the number of clubs).

In the next k lines, two numbers are given separated by a space. 
The numbers are ids of students belonging to same club. You have to find in how many ways can we select a pair 
of students such that both students are from different clubs. */

import java.io.*;
import java.util.*;
  class Edge {                   
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
class Solution{
	static void dfs(int src, ArrayList<Edge>[] graph, ArrayList<Integer> l, boolean[] visited){   
		visited[src] = true;                            
		l.add(src);                                    
		for(Edge e : graph[src]){                       
			if(visited[e.nbr]==false){                    
				dfs(e.nbr,graph,l,visited);
			}
		}
	}
    public static int perfectStudents(int v,  ArrayList<Edge>[] graph){
       ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
		boolean[] visited = new boolean[v];
		for(int i=0;i<v;i++){
			if(visited[i]==false){
			    ArrayList<Integer> temp1 = new ArrayList<>();
			    dfs(i,graph,temp1,visited);
				temp.add(temp1);
			}
		}
		int ans = 0;
		for(int i=0;i<temp.size();i++){
			for(int j=i+1;j<temp.size();j++){
				int count = temp.get(i).size() * temp.get(j).size();
				ans += count;
			}
		}
		return ans;
   }
}
public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      int vtces = n;
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = k;
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }
      System.out.println(Solution.perfectStudents(n, graph));
   }

}
