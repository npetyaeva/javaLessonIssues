package ru.netology.manager;

import lombok.RequiredArgsConstructor;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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

    public Collection<Issue> getOpenIssue() {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repo.findAll()) {
            if (item.isOpen()) {
                result.add(item);
            }
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    public Collection<Issue> getCloseIssue() {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repo.findAll()) {
            if (!item.isOpen()) {
                result.add(item);
            }
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    public Collection<Issue> filterAuthor(String author) {
        List<Issue> result = findBy(issue -> issue.getNameAuthor().contains(author));
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    public Collection<Issue> filterLabel(String label) {
        List<Issue> result = findBy(issue -> issue.getLabel().contains(label));
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    public Collection<Issue> filterAssignee(String assignee) {
        List<Issue> result = findBy(issue -> issue.getNameAssignee().contains(assignee));
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    private List<Issue> findBy(Predicate<Issue> filter) {
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
