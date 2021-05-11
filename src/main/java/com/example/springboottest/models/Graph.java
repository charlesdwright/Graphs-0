package com.example.springboottest.models;

public class Graph {

    private long id;
    private String home;
    private Edges[] edges;

    public long getId() {return id; }
    public void setId(long id) { this.id = id; }

    public String getHome() { return home; }
    public void setHome(String home) { this.home = home; }

    public Edges[] getEdges() { return edges; }
    public void setEdges(Edges[] edges) { this.edges = edges; }

}
