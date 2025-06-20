package org.yandex;

import java.util.Stack;

public class SimplifyPath71 {
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack();
        int start = 0;
        int end = 0;
        int size = path.length();
        String points = "...";

        for (int i = 1; i < size; ++i) {
            char cur = path.charAt(i);

            if (cur == '/') {
                continue;
            }

            if (Character.isLetter(cur)) {
                start = i;
                int j = i + 1;
                while (j < size && path.charAt(j) != '/') {
                    ++j;
                }
                end = j;
                stack.push(path.substring(start, end));
                i = --j;
            }

            if (cur == '.') {
                int count = 1;
                int j = i + 1;

                while (j < size && path.charAt(j) == '.') {
                    ++count;
                    ++j;
                }

                if (j >= size || path.charAt(j) == '/') {
                    if (count == 3) {
                        stack.push(points);
                    } else if (count == 2) {
                        if (!stack.isEmpty()) {
                            String s = stack.peek();
                            if (!s.equals(points)) {
                                stack.pop();
                            }
                        }
                    } else if (count > 3) {
                        stack.push(path.substring(i, j));
                    }
                } else {
                    while (j < size && path.charAt(j) != '/') {
                        ++j;
                    }

                    stack.push(path.substring(i, j));
                }

                i = --j;
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
            res.insert(0, "/");
        }

        return res.toString();
    }

    //Доработанное решение
    public String simplifyPathTwo(String path) {
        int len = path.length();
        String[] stack = new String[len]; int top = 0;

        int i = 0;
        while (i < len) {
            while (i < len && path.charAt(i) == '/') i++; // Skip slashes
            int start = i; // Start of next component
            while (i < len && path.charAt(i) != '/') i++; // Read until next slash or end
            int end = i;
            if (end > start) {
                String part = path.substring(start, end);
                if (part.equals(".")) {
                    continue;
                } else if (part.equals("..")) {
                    if (top > 0) top--; // pop
                } else {
                    stack[top++] = part; // push
                }
            }
        }

        if (top == 0) return "/";
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < top; j++) {
            sb.append('/').append(stack[j]);
        }
        return sb.toString();
    }

}
