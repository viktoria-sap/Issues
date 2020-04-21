package ru.netology.manager;

import ru.netology.domain.Issues;
import ru.netology.repository.Repository;

public class Manager {
    private Repository repository;
    private Issues[] issues = new Issues[0];


    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Issues issue) {
        repository.add(issue);
    }

    public void getAll() {
        repository.getAll();
    }

    public Issues[] findAll() {
        return issues;
    }

    public Issues[] searchByOpen(String search) {
        Issues[] result = new Issues[0];
        for (Issues issue: findAll()) {
            if (issue.matchesOpen(search)) {
                Issues[] tmp = new Issues[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        return result;
    }

    public Issues[] searchByClosed(String search) {
        Issues[] result = new Issues[0];
        for (Issues issue: findAll()) {
            if (issue.matchesClosed(search)) {
                Issues[] tmp = new Issues[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        return result;
    }

    public Issues[] filterBy(String search) {
        Issues[] result = new Issues[0];
        for (Issues issue: findAll()) {
            if (???) {
                Issues[] tmp = new Issues[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        return result;
    }
}
