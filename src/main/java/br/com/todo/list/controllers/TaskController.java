package br.com.todo.list.controllers;

import br.com.todo.list.DTO.TaskPostRequestBody;
import br.com.todo.list.entities.Task;
import br.com.todo.list.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    @Autowired
    private TaskService taskservice;

    @GetMapping
    public Page<TaskPostRequestBody> findAll(Pageable pageable){
        return taskservice.findAll(pageable);
    }

    @GetMapping(value ="/{id}")
    public Task findById(@PathVariable Long id){
        return taskservice.findById(id);
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody TaskPostRequestBody animePostRequestBody) {
        return new ResponseEntity<>(taskservice.save(animePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(value ="{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        taskservice.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody TaskPostRequestBody taskPutRequestBody) {
        taskservice.replace(taskPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
