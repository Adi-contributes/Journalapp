package com.journalapp.journalApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journalapp.journalApp.entity.JournalEntry;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private final HashMap<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getJournalEntries() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public void createEntry(@RequestBody JournalEntry journalEntry) {
        journalEntries.put(journalEntry.getId(), journalEntry);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntryById(@PathVariable("id") long id) {
        journalEntries.remove(id);
    }
    @DeleteMapping("/delete")
    public void deleteAllEntries() {
        journalEntries.clear();
    }
    @PutMapping("/update/{id}")
    public void updateEntry(@PathVariable("id") long id, @RequestBody JournalEntry journalEntry) {
        if (journalEntries.containsKey(id)) {
            journalEntries.put(id, journalEntry);
        }
    }
    @GetMapping("/{id}")
    public JournalEntry getEntryById(@PathVariable("id") long id) {
        return journalEntries.get(id);
    }
}
