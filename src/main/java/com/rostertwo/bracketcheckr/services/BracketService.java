package com.rostertwo.bracketcheckr.services;

import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class BracketService {

    public boolean areBracketsCorrect(String text) {
        if (text == null || text.isEmpty()) {
            return false; // Пустой текст считается некорректным
        }

        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false; // Некорректная скобочная пара
                }

                // Проверка пустых скобок
                char top = stack.peek();
                boolean onlySpaces = true;
                while (top != '(') {
                    if (!Character.isWhitespace(top)) {
                        onlySpaces = false;
                    }
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false; // Некорректная скобочная пара
                    }
                    top = stack.peek();
                }

                if (onlySpaces) {
                    return false; // Скобки содержат только пробелы
                }

                stack.pop(); // Удалить соответствующую скобку
            } else {
                stack.push(c); // Остальные символы добавить в стек, чтобы трекать символы между скобками
            }
        }
        return stack.isEmpty(); // Если стек пуст, то все скобки были корректно закрыты
    }
}
