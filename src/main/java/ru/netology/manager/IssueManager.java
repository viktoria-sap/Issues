package ru.netology.manager;

import ru.netology.issue.Issue;
import ru.netology.issue.Label;
import ru.netology.issue.Status;
import ru.netology.comparator.DateComparator;
import ru.netology.repository.IssueRepository;
import ru.netology.comparator.UpdateComparator;
import ru.netology.user.Assignee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static ru.netology.issue.Status.CLOSED;

public class IssueManager {
    private IssueRepository repository;

    public IssueManager(IssueRepository issues) {
        this.repository = issues;
    }

    public void add(Issue issue) {
        repository.add(issue);
    }

    public List<Issue> showOpen() {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getStatus().equals(Status.OPEN)) {
                temp.add(issue);

            }
        }
        return temp;
    }

    public List<Issue> showClosed() {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getStatus().equals(CLOSED)) {
                temp.add(issue);

            }
        }
        return temp;
    }

    public List<Issue> findMatch(Predicate<Issue> predicate) {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (predicate.test(issue)) {
                temp.add(issue);
            }
        }
        return temp;
    }

    public List<Issue> filterByAssignee(Assignee assignee) {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getAssigneesSet().contains(assignee)) {
                temp.add(issue);
            }
        }
        return temp;
    }

    public List<Issue> filterByLabel(Label label) {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getLabel().contains(label)) {
                temp.add(issue);
            }
        }
        return temp;
    }

    public List<Issue> sortByTime(DateComparator comparator) {
        List<Issue> issuesAll = repository.getAll();
        issuesAll.sort(comparator);
        return issuesAll;
    }

    public List<Issue> sortByUpdate(UpdateComparator comparator) {
        List<Issue> issuesAll = repository.getAll();
        issuesAll.sort(comparator);
        return issuesAll;
    }

    public Issue findById(int issueId) {
        for (Issue issue : repository.getAll()) {
            if (issue.getId() == issueId) {
                return issue;
            }
        }
        return null;
    }
}
