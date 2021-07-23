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
    public ResponseEntity<Workload> create(@RequestBody Workload w) {
        return ResponseEntity.ok(workloadService.save(w));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workload> update(@RequestBody Workload w, @PathVariable final Long id) {
        return workloadService.update(w, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable final Long id) {
        return workloadService.delete(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
