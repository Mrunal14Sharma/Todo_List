package com.app.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.todo.entities.Task;
import com.app.todo.services.TaskService;


@Controller
public class TaskController {

	private final TaskService taskservice;
	
	public TaskController(TaskService taskservice) {
		this.taskservice=taskservice;
	}
	@GetMapping
	public String getTasks(Model model) {
		List<Task> tasks = taskservice.getAllTasks();
		model.addAttribute("tasks",tasks);
		return "tasks";
	}
	@PostMapping
	public String createTask(@RequestParam String title) {
		taskservice.createTask(title);
		return "redirect:/";
	}
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable Long id) {
		taskservice.deleteTask(id);
		return "redirect:/";
	}
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable Long id) {
		taskservice.toggleTask(id);
		return "redirect:/";
	}
}
