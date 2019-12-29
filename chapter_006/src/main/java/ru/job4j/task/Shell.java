package ru.job4j.task;

import java.util.Stack;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Shell {
    private Stack<String> stack = new Stack<>();
    private String path = "/";

    public Shell cd(final String path) {
        StringJoiner joiner = new StringJoiner("/", "/", "");
        StringTokenizer tokens = new StringTokenizer(path, "/");
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            if (path.matches("//\\w+///")) {
                stack.clear();
                stack.push(token);
            } else if (token.matches("\\w+")) {
                stack.push(token);
            } else if (token.equals("..")) {
                stack.pop();
            }
        }
        stack.forEach(joiner::add);
        this.path = joiner.toString();
        return this;
    }

    public String path() {
        return path;
    }
}
