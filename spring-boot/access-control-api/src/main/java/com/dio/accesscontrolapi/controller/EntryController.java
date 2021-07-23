package com.dio.accesscontrolapi.controller;

import com.dio.accesscontrolapi.model.Entry;
import com.dio.accesscontrolapi.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {
    @Autowired
    EntryService entryService;

    @GetMapping
    public ResponseEntity<List<Entry>> findAll() {
        return ResponseEntity.ok(entryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entry> findById(@PathVariable final Long id) {
        return entryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Entry> create(@RequestBody Entry w) {
        return ResponseEntity.ok(entryService.save(w));
    }

    @PutMapping
    public ResponseEntity<Entry> update(@RequestBody Entry entry) {
        return entryService.update(entry)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final Long id) {
        return entryService.delete(id) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
