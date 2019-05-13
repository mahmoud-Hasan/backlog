package com.swf.cairo.backlog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swf.cairo.backlog.model.TaskModel;
import com.swf.cairo.backlog.service.TaskService;

@RestController
@RequestMapping("/v1/tasks")
public class TasksController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/getTasks")
	public Map<String,List<TaskModel>> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@PostMapping("/addTask")
	public void addTask(@RequestBody TaskModel task) {
		taskService.saveTask(task);
	}
	
	@PatchMapping("/editTask")
	public void editTask(@RequestBody TaskModel task){
		//for simplicity we use save as the object will sent with it's ID , next stage we use QUery & criteria to update 
		//taskService.editTask(task);
		taskService.saveTask(task);
	}
	
	@DeleteMapping("/deleteTask")
	public void deleteTask(@RequestParam String id) {
		taskService.deleteTask(id);
	}

}
