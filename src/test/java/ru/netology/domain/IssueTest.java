package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IssueTest {
    private final Issue first = new Issue(
            1, "Title1", "Description1", "AuthorOne", true, Set.of("typeOne"),
            Set.of("labelGreen"), Set.of("themeOne"), Set.of("statusOne")
    );

    @Test
    public void shouldCompareToTrue() {
        assertEquals(0, first.compareTo(first));
    }
}
