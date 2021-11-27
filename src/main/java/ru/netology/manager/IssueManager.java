package ru.netology.manager;

import lombok.RequiredArgsConstructor;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class IssueManager {
    private final IssueRepository repo;

    public void changeOpenClose(int id) {
        for (Issue item : repo.findAll()) {
            if (item.getId() == id) {
                item.setOpen(!item.isOpen());
            }
        }
    }

    public Collection<Issue> getOpenIssue () {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repo.findAll()) {
            if (item.isOpen()) {
                result.add(item);
            }
        }
        return result;
    }

    public Collection<Issue> getCloseIssue () {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repo.findAll()) {
            if (!item.isOpen()) {
                result.add(item);
            }
        }
        return result;
    }

    public Collection<Issue> filterAuthor(String author) {
        return findBy(issue -> issue.getNameAuthor().contains(author));
    }

    public Collection<Issue> filterLabel(String label) {
        return findBy(issue -> issue.getLabel().contains(label));
    }

    public Collection<Issue> filterAssignee(String assignee) {
        return findBy(issue -> issue.getNameAssignee().contains(assignee));
    }

    private Collection<Issue> findBy(Predicate<Issue> filter) {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repo.findAll()) {
            if (filter.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

/*    public void add(Issue item) {
        repo.save(item);
    }

    public void addAll(Collection<Issue> items) {
        repo.saveAll(items);
    }

    public Issue findById(int id) {
        return repo.findById(id);
    }

    public Collection<Issue> getAll() {
        return repo.findAll();
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public void removeAll(Collection<Issue> items) {
        repo.removeAll(items);
    }*/
}
