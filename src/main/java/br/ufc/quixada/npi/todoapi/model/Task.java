package br.ufc.quixada.npi.todoapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String title;
    private String description;

    @ManyToOne
    private Project project;

    @NotEmpty
    private String date;

    @NotEmpty
    private String time;

    private boolean checked;
    private String createdAt;

    public Task() {}

    public  Task(int id, String title, String description, Project project, String date, String time, boolean checked, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.project = project;
        this.date = date;
        this.time = time;
        this.checked = checked;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "_id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", project=" + project +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", checked=" + checked +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
