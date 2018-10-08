package com.ca.prism.pollingestor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import com.ca.prism.pollingestor.model.Vote;
import com.ca.prism.pollingestor.repository.VoteRepository;
import com.ca.prism.pollingestor.util.Producer;

import org.bson.types.ObjectId;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    private VoteRepository repository;

    @RequestMapping(value = "/poll", method = RequestMethod.POST)
    public ResponseEntity<?> castVote(@RequestBody Vote vote, UriComponentsBuilder ucBuilder) throws Exception {

        List<Vote> dbVotes = repository.findByCandidateName(vote.getCandidateName());
        if(dbVotes != null && dbVotes.size() > 0) {
            vote.setVotes(dbVotes.get(0).getVotes() + 1);
            dbVotes.get(0).setVotes(dbVotes.get(0).getVotes() + 1);
            repository.save(dbVotes.get(0));
        } else {

            ObjectId _id = ObjectId.get();
            vote.set_id(_id);
            vote.setVotes(1);
            repository.save(vote);

            System.out.println("Saved Vote to db with _id " + _id);
        }

        System.out.println("Creating Vote : {}" + vote.toString());
        Producer producer = new Producer();
        producer.postKafkaMessage("votes", vote.toString());

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}