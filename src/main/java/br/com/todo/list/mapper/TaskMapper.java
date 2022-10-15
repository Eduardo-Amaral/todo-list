package br.com.todo.list.mapper;

import br.com.todo.list.DTO.TaskPostRequestBody;
import br.com.todo.list.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {

    public static final TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);
    public abstract Task toTask(TaskPostRequestBody taskPostRequestBody);
}
