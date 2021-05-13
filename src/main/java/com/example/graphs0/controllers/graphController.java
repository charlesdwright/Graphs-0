package com.example.graphs0.controllers;
import com.example.graphs0.models.Matrix;
import com.example.graphs0.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.graphs0.models.Graph;
import com.example.graphs0.models.graphOps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/graph")
public class graphController {

    //======================================================================
    //this was a small miracle
    //https://stackoverflow.com/a/51479162/15867360
    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void configurePathMatch(PathMatchConfigurer configurer) {
            UrlPathHelper urlPathHelper = new UrlPathHelper();
            urlPathHelper.setRemoveSemicolonContent(false);
            configurer.setUrlPathHelper(urlPathHelper);
        }
    }


//======================================================================
    @GetMapping("/jsonify/{raw}")
    public @ResponseBody Graph getTheGraph(@PathVariable String raw) {
        log.info("in /jsonify/getTheGraph: " );
        graphOps thisGraph = new graphOps();
        return thisGraph.theGraph(raw);
    }

    @GetMapping("/matrix/{raw}")
    public @ResponseBody Matrix getTheMatrix(@PathVariable String raw) {
        log.info("in /matrix/getTheGraph: " );
        graphOps ops = new graphOps();
        return ops.adjMatrix(ops.theGraph(raw));
    }

}
