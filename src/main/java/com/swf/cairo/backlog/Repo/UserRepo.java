package com.swf.cairo.backlog.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.swf.cairo.backlog.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
	@Query("{'username':?0}")
	User findByUsername(String userName);
}
