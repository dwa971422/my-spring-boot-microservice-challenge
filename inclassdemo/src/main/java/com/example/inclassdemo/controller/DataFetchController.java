package com.example.inclassdemo.controller;

import com.example.inclassdemo.model.Entry;
import com.example.inclassdemo.service.DataFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataFetchController {
    private final DataFetchService dataFetchService;
    private final String URL = "https://api.publicapis.org/entries";

    @Autowired
    public DataFetchController(DataFetchService dataFetchService) {
        this.dataFetchService = dataFetchService;
    }

    @GetMapping("/entries")
    public ResponseEntity<List<Entry>> getAllEntries() {
        List<Entry> result = dataFetchService.getAllEntries(URL);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/entries/{auth}")
    public ResponseEntity<List<Entry>> getAllEntriesWithSpecificAuth(@PathVariable("auth") String auth) {
        List<Entry> result = dataFetchService.getAllEntriesWithSpecificAuth(URL, auth);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
