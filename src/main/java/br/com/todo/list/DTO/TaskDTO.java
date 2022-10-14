package br.com.todo.list.DTO;

import lombok.Data;

@Data
public class TaskDTO {
    private String title;
    private String description;
    private boolean status;

    protected TaskDTO() {
    }

    public TaskDTO(Long id, String title, String description, boolean status) {
        this.title = title;
        this.description = description;
        this.status = status;
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
