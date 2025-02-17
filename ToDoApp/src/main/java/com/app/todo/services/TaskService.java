package com.app.todo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todo.entities.Task;
import com.app.todo.repositary.TaskRepositary;


@Service
public class TaskService {
	
	private final TaskRepositary taskrepositary;
	
	

	public TaskService(TaskRepositary taskrepositary) {
		this.taskrepositary = taskrepositary;
	}



	public List<Task> getAllTasks() {
		return taskrepositary.findAll();
	}



	public void createTask(String title) {
		Task task = new Task();
		task.setTitle(title);
		task.setCompleted(false);
		taskrepositary.save(task);
		
	}



	public void deleteTask(Long id) {
		taskrepositary.deleteById(id);
	}



	public void toggleTask(Long id) {
		Task task = taskrepositary.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Task Id"));
		
		task.setCompleted(!task.isCompleted());
		
		taskrepositary.save(task);
	}

}
