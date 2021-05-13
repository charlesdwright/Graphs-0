package com.example.graphs0.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static com.example.graphs0.utils.getKeyFromValue;
import static com.example.graphs0.utils.parseNodes;

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

        Matrix theMatrix=new Matrix();
        Edges[] theEdges=theGraph.getEdges();
        HashMap<Integer, String> nodes = parseNodes(theEdges);
        theMatrix.setCols(nodes.values().toArray(new String[0]));
        theMatrix.setRows(nodes.values().toArray(new String[0]));

        int a[][] = new int[nodes.size()][nodes.size()];

        for (int i = 0; i < theEdges.length; i++) {
            log.info("i: "+i);
            int row = (int)getKeyFromValue(nodes,theEdges[i].getStart());
            int col = (int)getKeyFromValue(nodes,theEdges[i].getEnd());
            log.info("\n"+"Back in adjMatrix @ row " + i);

            a[row][col]=1;
        }

        theMatrix.setMatrix(a);
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
