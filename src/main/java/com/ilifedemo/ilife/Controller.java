package com.ilifedemo.ilife;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dash")
public class Controller {

    private final DashRepository dashRepository;

    public Controller(DashRepository dashRepository) {
        this.dashRepository = dashRepository;
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Dash> getDashs() {
        return dashRepository.findAll();
    }

    @GetMapping("/{id}")
    public Dash getDash(@PathVariable Long id) {
        return dashRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity<Dash> createDash(@RequestBody Dash dash) throws URISyntaxException {
        Dash savedDash = dashRepository.save(dash);
        return ResponseEntity.created(new URI("/dash/" + savedDash.getId())).body(savedDash);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dash> updateClient(@PathVariable Long id, @RequestBody Dash dash) {
        Dash currentDash = dashRepository.findById(id).orElseThrow(RuntimeException::new);
        currentDash.setPrestarts(dash.getPrestarts());
        currentDash.setComparisons(dash.getComparisons());
        currentDash.setProspects(dash.getProspects());
        currentDash.setAgentid(dash.getAgentid());
        currentDash.setAppsubmitted(dash.getAgentid());
        currentDash = dashRepository.save(dash);

        return ResponseEntity.ok(currentDash);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDash(@PathVariable Long id) {
        dashRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}