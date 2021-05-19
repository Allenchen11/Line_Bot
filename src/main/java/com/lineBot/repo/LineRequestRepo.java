package com.lineBot.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lineBot.model.LineRequestVo;

public interface LineRequestRepo extends MongoRepository<LineRequestVo, String> {

}
