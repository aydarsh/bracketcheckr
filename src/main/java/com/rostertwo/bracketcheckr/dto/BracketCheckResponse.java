package com.rostertwo.bracketcheckr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class BracketCheckResponse {
    @JsonProperty("isCorrect")
    boolean correct;
}
