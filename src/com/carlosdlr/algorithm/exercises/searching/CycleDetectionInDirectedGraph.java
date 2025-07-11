package com.carlosdlr.algorithm.exercises.searching;

import java.util.*;

public class CycleDetectionInDirectedGraph
{
    private static Graph graph;

    public boolean isCyclic()
    {
        //@visited array to keep track of visited nodes
        boolean[] visited = new boolean[graph.vertices];
        Arrays.fill(visited, false);
        //@recStack recursion stack, to check which all nodes are present
        //on the stack
        Set<Integer> recStack = new HashSet<>();
        System.out.println(graph.vertices);
        //loop through all the vertices in the graph
        for(int i=0;i<graph.vertices;i++)
        {
            if(helper(i, visited, recStack))
                return true;
        }
        return false;
    }
    //@v : current vertex
    public boolean helper(int v, boolean[] visited, Set<Integer> recStack)
    {
        System.out.println("v: "+v+" set: "+recStack);
        //if we have not visited the vertex v yet
        //then visit the vertex v and all its adjacent vertices
        if(!visited[v])
        {
            //mark the vertex v to be visited
            visited[v] = true;
            //add v in the recursion stack
            recStack.add(v);
            //for all adjacent vertices
            for(int i : graph.adj.get(v))
            {
                //if the adjacent node is not visited yet
                if(!visited[i])
                {
                    if(helper(i, visited, recStack))
                        return true;
                }
                //if the node is already present on the recursion stack
                //then there is cycle add return true
                else if(recStack.contains(i))
                    return true;
            }
        }
        //remove the node from the recursion stack
        recStack.remove(v);
        return false;
    }

    public static void main(String args[])
    {
        graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        //graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        CycleDetectionInDirectedGraph c = new CycleDetectionInDirectedGraph();
        System.out.println(c.isCyclic());
    }
}