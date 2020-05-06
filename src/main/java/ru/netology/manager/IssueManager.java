package ru.netology.manager;

import ru.netology.issue.Issue;
import ru.netology.issue.Label;
import ru.netology.issue.Status;
import ru.netology.someone.Assignee;
import ru.netology.comparator.DateComparator;
import ru.netology.repository.IssueRepository;
import ru.netology.comparator.UpdateComparator;
import ru.netology.someone.Author;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import static ru.netology.issue.Status.CLOSED;

public class IssueManager {
    private IssueRepository issues;

    public IssueManager(IssueRepository issues) {
        this.issues = issues;
    }

    public void add(Issue issue) {
        issues.add(issue);
    }

    public List<Issue> showOpen() {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : issues.getAll()) {
            if (issue.getStatus().equals(Status.OPEN)) {
                temp.add(issue);

            }
        }
        return temp;
    }

    public List<Issue> showClosed() {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : issues.getAll()) {
            if (issue.getStatus().equals(CLOSED)) {
                temp.add(issue);

            }
        }
        return temp;
    }

    public List<Issue> findMatch(Predicate<Issue> predicate) {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : issues.getAll()) {
            if (predicate.test(issue)) {
                temp.add(issue);
            }
        }
        return temp;
    }

    public List<Issue> filterByAssignee(String predicate) {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : issues.getAll()) {
            if (issue.getAssigneesSet().contains(predicate)) {
                temp.add(issue);
            }
        }
        return temp;
    }

    public List<Issue> filterByLabel(Label label) {
        List<Issue> temp = new ArrayList<>();
        for (Issue issue : issues.getAll()) {
            if (issue.getLabel().equals(label)) {
                temp.add(issue);
            }
        }
        return temp;
    }

    public List<Issue> sortAscendingTime() {
        DateComparator comparator = new DateComparator(false);
        List<Issue> issuesAll = issues.getAll();
        issuesAll.sort(comparator);
        return issuesAll;
    }

    public List<Issue> sortDescendingTime() {
        DateComparator comparator = new DateComparator(true);
        List<Issue> issuesAll = issues.getAll();
        issuesAll.sort(comparator);
        return issuesAll;
    }

    public List<Issue> sortDescendingUpdate() {
        UpdateComparator comparator = new UpdateComparator(true);
        List<Issue> issuesAll = issues.getAll();
        issuesAll.sort(comparator);
        return issuesAll;
    }

    public List<Issue> sortAscendingUpdate() {
        UpdateComparator comparator = new UpdateComparator(false);
        List<Issue> issuesAll = issues.getAll();
        issuesAll.sort(comparator);
        return issuesAll;
    }

    public Issue findById(int issueId) {
        for (Issue issue : issues.getAll()) {
            if (issue.getId() == issueId) {
                return issue;
            }
        }
        return null;
    }
}
