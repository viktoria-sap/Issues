package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class IssuesRepositoryTest {
    private Repository repository = new Repository();

    @Test
    void shouldAddIssue() {
        repository.add(new Issues());
    }

    @Test
    void shouldAddMultipleIssues() {
        Collection<Issues> issues = new ArrayList<>();
        issues.add(new Issues());
        issues.add(new Issues());

        repository.addAll(issues);
    }

}











