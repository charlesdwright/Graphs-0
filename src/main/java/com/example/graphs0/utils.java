package com.example.graphs0;

import com.example.graphs0.models.Edges;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class utils{

    public static HashMap<Integer, String> parseNodes(Edges[] edges) {
        //build a vector of unique nodes from a list of
        //edges (nodes in [source, destination] form).
        //used later to build the adjacency matrix.

        String[] start = new String[edges.length];
        String[] end = new String[edges.length];

        HashMap<Integer, String> nodes = new HashMap<Integer, String>();
        int key = nodes.size();
        log.info("...in utils.parseNodes");
        for (int i = 0; i < edges.length; i++) {
            start[i] = edges[i].getStart(); //split(",")[0].trim();
            end[i] = edges[i].getEnd(); //(",")[1].trim();

            log.info(start[i] + ", " + end[i]);

            if (!nodes.containsValue(start[i])) {
                key = nodes.size();
                log.info("src[i]: key=" + key + " !contains " + start[i] + "; putting " + start[i]);
                nodes.put(key, start[i]);
            }
            if (!nodes.containsValue(end[i])) {
                key = nodes.size();
                log.info("dest[i]: key=" + key + " !contains " + end[i] + "; putting " + end[i]);
                nodes.put(key, end[i]);
            }
        }
        return nodes;
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        //https://stackoverflow.com/a/27999980

        log.info("\n" + "...in getKeyFromValue");
        log.info("Looking for: "+String.valueOf(value));

        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                log.info("Found "+String.valueOf(hm.get(o)) + " at index " + o +"!");
                return o;
            }
        }
        return null;
    }
}
