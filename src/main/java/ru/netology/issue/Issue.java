package ru.netology.issue;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.user.Assignee;
import ru.netology.user.Author;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class Issue {
    private int id;
    private String name;
    private Author author;
    private Set<Label> label = new HashSet<>();
    private Status status;
    private Set<Tag> tagsSet = new HashSet<>();
    private Set<Assignee> assigneesSet = new HashSet<>();
    private Date createDate;
    private Date updateDate;
    private Date commentDate;

    public Issue(int id, String name, Author author, Label label, Assignee assignee, Tag tag, Status status, Date createDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.label.add(label);
        this.assigneesSet.add(assignee);
        this.tagsSet.add(tag);
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Issue(int id, String name, Author author, Label label, Assignee assignee, Status status, Date createDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.label.add(label);
        this.assigneesSet.add(assignee);
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public void setStatus(Status status) {
        this.status = status;
        updateDate = new Date();
    }

}
