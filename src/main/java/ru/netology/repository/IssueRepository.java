package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;

public class IssueRepository {
    private final Collection<Issue> items = new ArrayList<Issue>();

    public void save(Issue item) {
        items.add(item);
    }

    public Issue findById(int id) {
        for (Issue item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Collection<Issue> findAll() {
        return items;
    }

    public void removeById(int id) {
        items.removeIf(item -> item.getId() == id);
    }

    public void saveAll(Collection<Issue> items) {
        this.items.addAll(items);
    }

    public void removeAll(Collection<Issue> items) {

        this.items.removeAll(items);
    }
}
