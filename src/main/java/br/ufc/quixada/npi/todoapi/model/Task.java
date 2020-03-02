package br.ufc.quixada.npi.todoapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String _id;

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

    public  Task(String _id, String title, String description, Project project, String date, String time, boolean checked, String createdAt) {
        this._id = _id;
        this.title = title;
        this.description = description;
        this.project = project;
        this.date = date;
        this.time = time;
        this.checked = checked;
        this.createdAt = createdAt;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
                "_id='" + _id + '\'' +
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
