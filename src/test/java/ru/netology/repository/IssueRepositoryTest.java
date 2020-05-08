package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.issue.*;
import ru.netology.manager.IssueManager;
import ru.netology.user.Assignee;
import ru.netology.user.Author;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.issue.Label.BUG;
import static ru.netology.issue.Status.CLOSED;
import static ru.netology.issue.Status.OPEN;

class IssueRepositoryTest {
    private Issue issue1 = new Issue(1, "Тесты к дз по CI падают", new Author(1, "Anna", "Petrova"), BUG, new Assignee(2, "Ivan", "Kusnetsov"), new Tag(2, "new app"), OPEN, new GregorianCalendar(2020, Calendar.JANUARY, 17, 11, 10, 9).getTime(), new GregorianCalendar(2020, Calendar.JANUARY, 17, 11, 10, 9).getTime());
    private Issue issue2 = new Issue(2, "Один из автотестов не проходит", new Author(3, "Vladimir", "Ivanov"), BUG, new Assignee(4, "Iliya", "Potapov"), new Tag(3, "new app"), OPEN, new GregorianCalendar(2019, Calendar.DECEMBER, 5, 15, 3, 20).getTime(), new GregorianCalendar(2019, Calendar.DECEMBER, 7, 15, 3, 20).getTime());
    private Issue issue3 = new Issue(3, "должен быть такой StackTrace", new Author(5, "Petr", "Laptev"), Label.ENHANCEMENT, new Assignee(6, "Dmitriy", "Krupitsa"), CLOSED, new GregorianCalendar(2019, Calendar.NOVEMBER, 4, 16, 12, 14).getTime(), new GregorianCalendar(2019, Calendar.NOVEMBER, 4, 16, 12, 14).getTime());
    private Issue issue4 = new Issue(4, "Файл с домашним заданием не загружается", new Author(7, "Alexandr", "Bogachev"), BUG, new Assignee(5, "Petr", "Laptev"), CLOSED, new GregorianCalendar(2020, Calendar.MARCH, 24, 12, 11, 11).getTime(), new GregorianCalendar(2020, Calendar.MARCH, 24, 2, 11, 11).getTime());
    private Issue issue5 = new Issue(5, "Шрифт заголовка должен быть синим", new Author(9, "Nikolay", "Sidorov"), Label.WANTFIX, new Assignee(1, "Anna", "Petrova"), OPEN, new GregorianCalendar(2020, Calendar.APRIL, 5, 12, 11, 11).getTime(), new GregorianCalendar(2020, Calendar.MAY, 5, 13, 15, 17).getTime());
    private Issue issue6 = new Issue(6, "Не очевидно определение валидности", new Author(8, "Anastasia", "Kim"), BUG, new Assignee(2, "Ivan", "Kuznetsov"), CLOSED, new GregorianCalendar(2020, Calendar.MAY, 20, 8, 11, 11).getTime(), new GregorianCalendar(2020, Calendar.MAY, 20, 9, 11, 11).getTime());

    private IssueRepository repository = new IssueRepository();
    private IssueManager issueManager = new IssueManager(repository);

    @BeforeEach
    void setUp() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        repository.add(issue5);
        repository.add(issue6);
    }

    @Test
    void shouldAdd() {
        assertEquals(issue1, repository.findById(1));
    }

    @Test
    void shouldOpen() {
        repository.open(6);
        Issue byId = issueManager.findById(6);
        assertSame(byId.getStatus(), Status.OPEN);
    }

    @Test
    void shouldClose() {
        repository.close(5);
        Issue byId = issueManager.findById(5);
        assertSame(byId.getStatus(), CLOSED);
    }


    @Test
    void deleteById() {
        repository.deleteById(6);
        assertNull(repository.findById(6));
    }

    @Test
    void deleteByIdIfNotExist() {
        repository.deleteById(8);
        List<Issue> actual = repository.getAll();
        List<Issue> expected = new ArrayList<>();
        expected.add(issue1);
        expected.add(issue2);
        expected.add(issue3);
        expected.add(issue4);
        expected.add(issue5);
        expected.add(issue6);
        assertEquals(expected, actual);
    }

}












