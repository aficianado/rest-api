package org.chaoppo.rest.controller;

import com.google.gson.Gson;
import org.chaoppo.rest.jpa.Rider;
import org.chaoppo.rest.jpa.RiderRepository;
import org.chaoppo.rest.jpa.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/rider")
public class RiderRestController {

    private static Gson gson = new Gson();

    @Autowired
    private RiderRepository repo;

    @GetMapping(path="/{id}")
    public Map<String, String> getUser(@PathVariable int id) {

        Optional<Rider> r = repo.findById(id);

        Map<String, String> response = new HashMap<String, String>();
        if(r.isPresent()) {
            response.put("response", gson.toJson(r.get()));
        } else {
            response.put("response", String.format("No record found for id []!", id));
        }
        return response;
    }

    @GetMapping(path="/")
    public List<Rider> getAllUsers() {
        return repo.findAll();
    }

    @PutMapping(path="/")
    public Map<String, String> saveRider(@RequestBody Rider rider) {
        repo.save(rider);
        Map<String, String> response = new HashMap<String, String>();
        response.put("response", rider.getId().toString());
        return response;
    }

    @PostMapping(path="/")
    public Map<String, String> updateRider(@RequestBody Rider rider) {
        Optional<Rider> r = repo.findById(rider.getId());
        Map<String, String> response = new HashMap<String, String>();
        if(r.isPresent()) {
            response.put("response", gson.toJson(r.get()));
        } else {
            response.put("response", String.format("No record found for id []! Hence inserted new Record []", rider.getId(), gson.toJson(r)));
        }
        return response;
    }

}
