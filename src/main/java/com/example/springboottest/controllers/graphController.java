package com.example.springboottest.controllers;
import org.springframework.context.annotation.Configuration;
import com.example.springboottest.models.Graph;
import com.example.springboottest.models.createGraph;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

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

    @GetMapping("/getjson/{theInput}")
    public @ResponseBody
    Graph getTheGraph (@PathVariable String theInput){
        log.info("in getMapping: " + theInput);
        createGraph thisGraph = new createGraph();
        return thisGraph.theGraph(theInput);
    }
}