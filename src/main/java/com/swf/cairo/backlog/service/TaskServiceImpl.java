package com.swf.cairo.backlog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.swf.cairo.backlog.Repo.TasksRepo;
import com.swf.cairo.backlog.model.TaskModel;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TasksRepo taskRepo;
	
	@Value("${status.inprogress}")
	private String inProgress;
	
	@Value("${status.done}")
	private String done;
	
	@Value("${status.todo}")
	private String toDo;
	
	@Override
	public Map<String,List<TaskModel>> getAllTasks() {
		List<TaskModel> tasks = taskRepo.findAll();
		Map<String,List<TaskModel>> tasksMap = new HashMap<String,List<TaskModel>>();
		tasks.forEach(e->{
			
			if(e.getStatus().equals(done)) {
				getTasksCatList(done, tasksMap, e);
			}else if (e.getStatus().equals(inProgress)) {
				getTasksCatList(inProgress, tasksMap, e);
			}else if(e.getStatus().equals(toDo)) {
				getTasksCatList(toDo, tasksMap, e);
			}
			
		});
		
		return tasksMap;
	}

	@Override
	public void saveTask(TaskModel task) {
		
		taskRepo.save(task);		
	}

	@Override
	public void deleteTask(String id) {
		
		taskRepo.deleteById(id);
		
	}

	@Override
	public void editTask(TaskModel task) {
		
		// not working , using Query & criteria instead .
//		taskRepo.updateTaskById(task.get_id(), task);
		
	}
	
	private /*Map<String,List<TaskModel>>*/ void getTasksCatList(String Key ,Map<String,List<TaskModel>> tasksMap ,TaskModel task) {
		List<TaskModel> tasksList = tasksMap.get(Key)!=null?tasksMap.get(Key):new ArrayList<TaskModel>();
		tasksList.add(task);
		tasksMap.put(Key, tasksList);
		//return tasksMap;
	}

}
