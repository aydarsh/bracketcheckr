package com.rostertwo.bracketcheckr.controllers;

import com.rostertwo.bracketcheckr.dto.BracketCheckRequest;
import com.rostertwo.bracketcheckr.dto.BracketCheckResponse;
import com.rostertwo.bracketcheckr.services.BracketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BracketController {

    private final BracketService bracketService;

    @PostMapping("/api/checkBrackets")
    public BracketCheckResponse checkBrackets(@Valid @RequestBody BracketCheckRequest request) {
        log.info("Check brackets for {}", request);
        boolean isCorrect = bracketService.areBracketsCorrect(request.getText());
        return new BracketCheckResponse(isCorrect);
    }
}

