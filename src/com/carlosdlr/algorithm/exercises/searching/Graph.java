package com.carlosdlr.algorithm.exercises.searching;

import java.util.*;

public class Graph
{
    //number of vertices in the graph
    int vertices;
    //adjacency list
    //key denotes the node
    //value denotes the arraylist of all the adjacent nodes
    Map<Integer, ArrayList<Integer>> adj;

    Graph(int v)
    {
        this.vertices = v;
        adj = new HashMap<>();
        //initialize the map with empty arrayList
        for(int i=0; i<v; i++)
        {
            adj.put(i, new ArrayList<Integer>());
        }
    }

    public void addEdge(int a, int b)
    {
        //adding edge from a to b
        this.adj.get(a).add(b);
    }
}