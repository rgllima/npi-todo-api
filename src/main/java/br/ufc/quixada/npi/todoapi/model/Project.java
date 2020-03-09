package br.ufc.quixada.npi.todoapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;
    
    private String description;
    private String color;
    private String createdAt;

    public Project() {
        tasks = new ArrayList<>();
    }

    public Project(int id, String title, String description, String color, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.color = color;
        this.createdAt = createdAt;
        tasks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
