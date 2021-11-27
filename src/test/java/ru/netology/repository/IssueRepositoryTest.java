package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueRepositoryTest {
    private final IssueRepository repo = new IssueRepository();

    private final Issue first = new Issue(
            1, "Title1", "Description1", "AuthorOne", "AssigneeOne", true,
            Set.of("typeOne"), Set.of("labelGreen"), Set.of("themeOne"), Set.of("statusOne")
    );
    private final Issue second = new Issue(
            2, "Title2", "Description2", "AuthorTwo", "AssigneeTwo",true,
            Set.of("typeOne"), Set.of("labelRed"), Set.of("themeTwo"), Set.of("statusTwo")
    );
    private final Issue third = new Issue(
            3, "Title3", "Description3", "AuthorOne","AssigneeOne",true,
            Set.of("typeTwo"), Set.of("labelBlue"), Set.of("themeOne"), Set.of("statusThree")
    );
    private final Issue fourth = new Issue(
            4, "Title4", "Description4", "AuthorThree", "AssigneeThree",false,
            Set.of("typeThree"), Set.of("labelGreen"), Set.of("themeThree"), Set.of("statusOne")
    );
    private final Issue fifth = new Issue(
            5, "Title5", "Description5", "AuthorFourth", "AssigneeOne",true,
            Set.of("typeOne"), Set.of("labelRed"), Set.of("themeFourth"), Set.of("statusOne")
    );
    private final Issue sixth = new Issue(
            6, "Title6", "Description6", "AuthorTwo", "AssigneeFour",false,
            Set.of("typeOne"), Set.of("labelOrange"), Set.of("themeFifth"), Set.of("statusTwo")
    );

    @BeforeEach
    void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
    }

    @Test
    void shouldRemoveById() {
        List<Issue> expected = List.of(first, third);
        repo.removeById(2);
        assertEquals(expected, repo.findAll());
    }

    @Test
    void shouldSaveAll() {
        List<Issue> expected = List.of(first, second, third, fourth, fifth, sixth);
        List<Issue> list = List.of(fourth, fifth, sixth);
        repo.saveAll(list);
        assertEquals(expected, repo.findAll());
    }

    @Test
    void shouldRemoveAll() {
        List<Issue> expected = List.of(first);
        List<Issue> list = List.of(second, third);
        repo.removeAll(list);
        assertEquals(expected, repo.findAll());
    }

    @Test
    void shouldFindByIdTrue() {
        Issue actual = repo.findById(2);
        assertEquals(second, actual);
    }

    @Test
    void shouldFindByIdFalse() {
        Issue actual = repo.findById(10);
        assertEquals(null, actual);
    }
}