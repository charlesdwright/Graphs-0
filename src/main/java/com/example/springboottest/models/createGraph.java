package com.example.springboottest.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
@Slf4j
public class createGraph {

    public Graph theGraph(String theInput){
        log.info("in theGraph..." + theInput);

        Graph theGraph =new Graph();
        theGraph.setId(0);
        String[] theEdges = theInput.split(";");
        Edges[] edgesArray = new Edges[theEdges.length];

        for (int i = 0; i < theEdges.length; i++) {
            edgesArray[i]=new Edges();

            String start = theEdges[i].split(",")[0].trim();
            String end = theEdges[i].split(",")[1].trim();

            edgesArray[i].setId(i);
            edgesArray[i].setStart(start);
            edgesArray[i].setEnd(end);
        }

        theGraph.setEdges(edgesArray);
        //defaults "home" to first node in list
        theGraph.setHome(edgesArray[0].getStart());
/*
    //write to file
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("writeGraph.JSON"), theGraph);

        }catch (IOException e) { e.printStackTrace(); }
*/
        return theGraph;
    }
}
