package org.chaoppo.rest.controller;

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

    @Autowired
    private RiderRepository repo;

    @GetMapping(path="/{id}")
    public Rider getUser(@PathVariable int id) {
        return repo.findById(id).get();
    }

    @GetMapping(path="/")
    public List<Rider> getAllUsers() {
        return repo.findAll();
    }

    @PostMapping(path="/")
    public Map<String, String> saveRider(@RequestBody Rider rider) {
        repo.save(rider);
        Map<String, String> response = new HashMap<String, String>();
        response.put("msg", rider.getId().toString());
        return response;
    }


}
