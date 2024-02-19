package org.training;

import java.util.Stack;

public class CustomStringBuilder {
    private StringBuilder stringBuilder;
    private final Stack<String> snapshot;

    public CustomStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.snapshot = new Stack<>();
    }

    public CustomStringBuilder(String str) {
        this.stringBuilder = new StringBuilder(str);
        this.snapshot = new Stack<>();
    }

    public void append(String str) {
        snapshot.push(stringBuilder.toString());
        stringBuilder.append(str);
    }

    public void undo() {
        if (snapshot.isEmpty()) return;
        stringBuilder = new StringBuilder(snapshot.pop());
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
