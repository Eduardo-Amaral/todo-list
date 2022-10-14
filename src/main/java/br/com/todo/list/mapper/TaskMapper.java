package br.com.todo.list.mapper;

import br.com.todo.list.DTO.TaskDTO;
import br.com.todo.list.entities.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {
    public abstract Task toTask(TaskDTO taskDTO);
}
