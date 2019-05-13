package com.swf.cairo.backlog.service;

import java.util.List;
import java.util.Map;

import com.swf.cairo.backlog.model.TaskModel;

public interface TaskService {

	Map<String,List<TaskModel>> getAllTasks();
	void saveTask(TaskModel task);
	void deleteTask(String id);
	void editTask(TaskModel task);
}
