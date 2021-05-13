package com.example.graphs0.utils;

import com.example.graphs0.models.Edges;
import com.example.graphs0.models.Graph;
import com.example.graphs0.models.Matrix;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import static com.example.graphs0.utils.utils.getKeyFromValue;
import static com.example.graphs0.utils.utils.parseNodes;

@Slf4j
public class graphOps {

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

    public Matrix adjMatrix(Graph theGraph){
        log.info("in graphOps.adjMatrix..." + theGraph.getHome());

        //extract edges from theGraph
        Edges[] theEdges=theGraph.getEdges();
        HashMap<Integer, String> nodes = parseNodes(theEdges);

        //initialize the matrix
        Matrix theMatrix=new Matrix(nodes.size(), nodes.size());
        theMatrix.setCols(nodes.values().toArray(new String[0]));
        theMatrix.setRows(nodes.values().toArray(new String[0]));

        //mapping vertices to matrix entries
        for (int i = 0; i < theEdges.length; i++) {
            log.info("i: "+i);
            int row = (int)getKeyFromValue(nodes,theEdges[i].getStart());
            int col = (int)getKeyFromValue(nodes,theEdges[i].getEnd());

            log.info("\n");
            log.info("Back in adjMatrix @ row " + i);

            theMatrix.setMatrix(row,col,1);
        }
        return theMatrix;
    }

    public Graph fromJson(String json) throws IOException {
        //deserialize json to graph object
        ObjectMapper mapper = new ObjectMapper();

        Graph theGraph = mapper.readValue(json, Graph.class);
        log.info("in fromJson..." + theGraph.getHome());
        return theGraph;
    }

    public void blah(String theURL){
        //TODO create a response page see tutorial
        //theURL="http://localhost:8080" + theURL ;
        log.info("in blah, the URL: " +theURL);
        RestTemplate restTemplate=new RestTemplate();
        Graph response =
                restTemplate.getForObject(theURL, Graph.class);
        log.info("in blah..." + response.getHome());

    }
}
