package com.rostertwo.bracketcheckr.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class BracketServiceTest {

    @InjectMocks
    private BracketService bracketService;

    @Test
    public void emptyBrackets() {
        String text = "(Hello, ())";
        assertFalse(bracketService.areBracketsCorrect(text));
    }

    @Test
    public void emptyBracketsWithSpaceChars() {
        String text = "(Hello, (   ))";
        assertFalse(bracketService.areBracketsCorrect(text));
    }

    @Test
    public void incorrectBrackets() {
        String text = "(Hello, (world)";
        assertFalse(bracketService.areBracketsCorrect(text));
    }

    @Test
    public void correctBrackets() {
        String text = "(Hello, (world))";
        assertTrue(bracketService.areBracketsCorrect(text));
    }
}