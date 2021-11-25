package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue implements Comparable<Issue> {
    private int id;
    private String title;
    private String description;
    private String nameAuthor;
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
