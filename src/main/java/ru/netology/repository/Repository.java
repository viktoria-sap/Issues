package ru.netology.repository;

import ru.netology.domain.Issues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Repository {
    private List<Issues> issues = new ArrayList<>();

    public List<Issues> getAll() {
        return issues;
    }

    public Issues getById(int id) {
        for (Issues issue : issues) {
            if (issue.getId() == id) {
                return issue;
            }
        }
        return null;
    }

    public boolean add(Issues issue) {
        //
        return issues.add(issue);
        //
    }

    public boolean remove(Issues issue) {
        //
        return issues.remove(issue);
        //
    }

    public boolean addAll(Collection<? extends Issues> issues) {
        return this.issues.addAll(issues);
    }

    public boolean removeAll(Collection<? extends Issues> issues) {
        return this.issues.removeAll(issues);
    }
}
