package com.ca.prism.pollingestor.controller;

import com.ca.prism.pollingestor.model.Vote;
import com.ca.prism.pollingestor.repository.VoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import org.bson.types.ObjectId;

@RestController
@RequestMapping("/votes")
public class VoteController {
    @Autowired
    private VoteRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Vote> getAllVote() {
        return repository.findAll();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Vote getVoteById(@PathVariable("id") ObjectId _id) {
        return repository.findBy_id(_id);
    }
}