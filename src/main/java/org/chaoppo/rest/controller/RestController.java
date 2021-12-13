package org.chaoppo.rest.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static final String DEFAULT_VERSION = "v1";
    private static final String KEY = "response";
    private static Gson gson = new Gson();

    @GetMapping(path="/hello")
    public Map<?, ?> getVersion() {
        Map<String, String> response = new HashMap<String, String>();
        response.put(KEY, String.format("Hello World API requested. API [%s]!", DEFAULT_VERSION));
        return response;
    }

    @GetMapping(path="/")
    public Map<?, ?> home() {
        return getVersion();
    }

    @GetMapping(path="/hello/{name}")
    public Map<?, ?> getVersion(@PathVariable String name) {
        Map<String, String> response = new HashMap<String, String>();
        response.put(KEY, String.format("Hello World API requested by [%s]. API [%s]!", name, DEFAULT_VERSION));
        return response;
    }

    @GetMapping(path="/{name}")
    public Map<?, ?> home(@PathVariable String name) {
        return getVersion(name);
    }
}
