package br.com.todo.list.DTO;

import br.com.todo.list.entities.Task;
import lombok.Data;

@Data
public class TaskPostRequestBody {
    private Long id;
    private String title;
    private String description;
    private boolean status;

    public TaskPostRequestBody() {
    }

    public TaskPostRequestBody(Long id, String title, String description, boolean status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;

    }

    public TaskPostRequestBody(Task task) {
        id = task.getId();
        title = task.getTitle();
        description = task.getDescription();
        status = task.isStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
