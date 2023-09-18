package com.rostertwo.bracketcheckr.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BracketCheckRequest implements DataTransferObject {
    @NotNull
    private String text;
}
