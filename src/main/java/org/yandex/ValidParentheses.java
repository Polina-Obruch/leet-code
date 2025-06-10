package org.yandex;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();

        if (s.length() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);

            if (currentChar == ')') {
                if (brackets.isEmpty() || brackets.pop() != '(') {
                    return false;
                }
            } else if (currentChar == '}') {
                if (brackets.isEmpty() || brackets.pop() != '{') {
                    return false;
                }
            } else if (currentChar == ']') {
                if (brackets.isEmpty() || brackets.pop() != '[') {
                    return false;
                }
            } else {
                brackets.push(currentChar);
            }
        }

        return brackets.isEmpty();
    }
}
