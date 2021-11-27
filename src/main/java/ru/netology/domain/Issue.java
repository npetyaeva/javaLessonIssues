package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Issue implements Comparable<Issue> {
    private final int id;
    private final String title;
    private final String description;
    private final String nameAuthor;
    private final String nameAssignee;
    private boolean isOpen;
    private Set<String> type;
    private Set<String> label;
    private Set<String> theme;
    private Set<String> status;

    @Override
    public int compareTo(Issue o) {
        return id - o.id;
    }
}
