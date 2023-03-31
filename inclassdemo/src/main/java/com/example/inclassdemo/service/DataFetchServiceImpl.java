package com.example.inclassdemo.service;

import com.example.inclassdemo.model.Entry;
import com.example.inclassdemo.model.ResponseEntryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataFetchServiceImpl implements DataFetchService {
    private final RestTemplate restTemplate;

    @Autowired
    public DataFetchServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Entry> getAllEntries(String url) {
        return restTemplate.getForObject(url, ResponseEntryList.class).getEntries();
    }

    @Override
    public List<Entry> getAllEntriesWithSpecificAuth(String url, String auth) {
        return restTemplate.getForObject(url, ResponseEntryList.class).getEntries()
                .stream()
                .filter((entry -> entry.getAuth().equals(auth)))
                .collect(Collectors.toList());
    }
}
