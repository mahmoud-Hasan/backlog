package com.swf.cairo.backlog.Repo;

import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.mapping.PersistentProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.swf.cairo.backlog.model.TaskModel;

@Repository
public interface TasksRepo extends MongoRepository<TaskModel, String>{

//	@Query("{'_id':?0},{$set:{'owner':'lol'}}")
//	WriteResult updateTaskById(String Id,TaskModel model);
	
}
