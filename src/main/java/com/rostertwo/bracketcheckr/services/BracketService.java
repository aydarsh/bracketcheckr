package com.rostertwo.bracketcheckr.services;

import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class BracketService {

    /**
     * This method checks if brackets in text are correct
     * @param text in which brackets are checked
     * @return true if brackets are correct
     */
    public boolean areBracketsCorrect(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false; // Некорректная скобочная пара
                }
            }
        }
        return stack.isEmpty(); // Если стек пуст, то все скобки были корректно закрыты
    }
}
