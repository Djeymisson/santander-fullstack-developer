package com.dio.accesscontrolapi.controller;

import com.dio.accesscontrolapi.model.Workload;
import com.dio.accesscontrolapi.service.WorkloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workload")
public class WorkloadController {

    @Autowired
    WorkloadService workloadService;

    @GetMapping
    public ResponseEntity<List<Workload>> findAll() {
        return ResponseEntity.ok(workloadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workload> findById(@PathVariable final Long id) {
        return workloadService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Workload> create(@RequestBody Workload workload) {
        return ResponseEntity.ok(workloadService.save(workload));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Workload workload, @PathVariable final Long id) {
        return workloadService.update(workload, id)
                .map(w -> ResponseEntity.ok().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final Long id) {
        return workloadService.delete(id) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
