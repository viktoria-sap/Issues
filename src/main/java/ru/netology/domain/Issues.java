
package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.function.Predicate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Issues implements Predicate<Issues> {
    private int id;
    private String author;
    private String label;
    private String projects;
    private String milestones;
    private String assignee;
    private String search;
    private String open;
    private String closed;

    public boolean matchesOpen(String search){
        if (getOpen().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }

    public boolean matchesClosed(String search){
        if (getClosed().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean test(Issues issues) {
        return false;
    }

    @Override
    public Predicate<Issues> and(Predicate<? super Issues> other) {
        return null;
    }

    @Override
    public Predicate<Issues> negate() {
        return null;
    }

    @Override
    public Predicate<Issues> or(Predicate<? super Issues> other) {
        return null;
    }
}
