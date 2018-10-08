package com.ca.prism.pollingestor.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Vote {
    Vote() {

    }
    @Id
    private ObjectId _id;

    private String candidateName;
    private int votes;

    public Vote(ObjectId _id, String candidateName) {
        this._id = _id;
        this.candidateName = candidateName;
        this.votes = 0;
    }
    
    public Vote(ObjectId _id, String candidateName, int votes) {
        this._id = _id;
        this.candidateName = candidateName;
        this.votes = votes;
    }

    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }
    
    public String getCandidateName() { return candidateName; }
    public void setCandidateName(String candidateName) { this.candidateName = candidateName; }
    
    public int getVotes() { return votes; }
    public void setVotes(int votes) { this.votes = votes; }

    @Override
    public String toString() {
        return "{\"_id\":\"" + _id + "\", \"candidateName\":\"" + candidateName + "\", \"votes\":" + votes + "}";
    }
}