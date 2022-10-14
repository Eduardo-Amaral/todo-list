package br.com.todo.list.controllers;

import br.com.todo.list.entities.Task;
import br.com.todo.list.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    @Autowired
    private TaskService taskservice;

    @GetMapping
    public List<Task> findAll(){
        return taskservice.findAll();
    }

    @GetMapping(value ="/{id}")
    public Task findById(@PathVariable Long id){
        return taskservice.findById(id);
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskservice.save(task);
    }

    @DeleteMapping(value ="{id}")
    public void delete(@PathVariable Task id){
        taskservice.remove(id);
    }

    @PutMapping(value = "/{id}")
    public Task update(@RequestBody Task task) {
        return taskservice.save(task);
    }
}
