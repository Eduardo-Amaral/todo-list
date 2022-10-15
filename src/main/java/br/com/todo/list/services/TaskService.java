package br.com.todo.list.services;


import br.com.todo.list.DTO.TaskPostRequestBody;
import br.com.todo.list.entities.Task;
import br.com.todo.list.mapper.TaskMapper;
import br.com.todo.list.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public Page<TaskPostRequestBody> findAll(Pageable pageable) {
        Page<Task> result = taskRepository.findAll(pageable);
        Page<TaskPostRequestBody> page = result.map(x -> new TaskPostRequestBody(x));
        return page;}

    @Transactional(readOnly = true)
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task not found")
        );
    }

    public Task save(TaskPostRequestBody taskPostRequestBody) {
        return taskRepository.save(TaskMapper.INSTANCE.toTask(taskPostRequestBody));
    }

    public void remove(Long id) {
        taskRepository.delete(findById(id));
    }

    public void replace(TaskPostRequestBody taskPutRequestBody) {
        Task savedTask = findById(taskPutRequestBody.getId());
        Task task = TaskMapper.INSTANCE.toTask(taskPutRequestBody);
        task.setId(savedTask.getId());
        taskRepository.save(task);
    }
}
