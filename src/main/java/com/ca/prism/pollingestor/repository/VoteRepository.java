package com.ca.prism.pollingestor.repository;

import java.util.List;
import com.ca.prism.pollingestor.model.Vote;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoteRepository extends MongoRepository<Vote, String> {
  Vote findBy_id(ObjectId _id);
  List<Vote> findByCandidateName(String candidateName);
}