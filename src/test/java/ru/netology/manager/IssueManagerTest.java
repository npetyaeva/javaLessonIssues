package ru.netology.manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class IssueManagerTest {
    private final IssueRepository repo = Mockito.mock(IssueRepository.class);
    private final IssueManager manager = new IssueManager(repo);

    private final Issue first = new Issue(
            1, "Title1", "Description1", "AuthorOne", "AssigneeOne", true,
            Set.of("typeOne"), Set.of("labelGreen"), Set.of("themeOne"), Set.of("statusOne")
    );
    private final Issue second = new Issue(
            2, "Title2", "Description2", "AuthorTwo", "AssigneeOne", false,
            Set.of("typeOne"), Set.of("labelRed"), Set.of("themeTwo"), Set.of("statusTwo")
    );
    private final Issue third = new Issue(
            3, "Title3", "Description3", "AuthorOne", "AssigneeTwo", true,
            Set.of("typeTwo"), Set.of("labelBlue"), Set.of("themeOne"), Set.of("statusThree")
    );

    @BeforeEach
    void setUp() {
        Collection<Issue> returned = List.of(first, second, third);
        doReturn(returned).when(repo).findAll();
    }

    @AfterEach
    void endUp() {
        verify(repo).findAll();
    }

    @Test
    public void shouldChangeOpenClose() {
        manager.changeOpenClose(1);
        assertFalse(first.isOpen());
    }

    @Test
    public void shouldGetOpenIssue() {
        assertEquals(List.of(third, first), manager.getOpenIssue());
    }

    @Test
    public void shouldGetCloseIssue() {
        assertEquals(List.of(second), manager.getCloseIssue());
    }

    @Test
    public void shouldFilterAuthor() {
        assertEquals(List.of(third, first), manager.filterAuthor("AuthorOne"));
    }

    @Test
    public void shouldFilterLabel() {
        assertEquals(List.of(second), manager.filterLabel("labelRed"));
    }

    @Test
    public void shouldFilterAssignee() {
        assertEquals(List.of(second, first), manager.filterAssignee("AssigneeOne"));
    }
}