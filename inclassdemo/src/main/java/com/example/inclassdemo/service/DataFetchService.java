package com.example.inclassdemo.service;

import com.example.inclassdemo.model.Entry;

import java.util.List;

public interface DataFetchService {
    List<Entry> getAllEntries(String url);
    List<Entry> getAllEntriesWithSpecificAuth(String url, String auth);
}
