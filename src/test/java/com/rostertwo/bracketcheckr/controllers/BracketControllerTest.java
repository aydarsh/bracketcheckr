package com.rostertwo.bracketcheckr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rostertwo.bracketcheckr.dto.BracketCheckRequest;
import com.rostertwo.bracketcheckr.services.BracketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BracketControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private BracketService bracketService;

    @Test
    public void invalidInputReturnsBadRequest() throws Exception {
        BracketCheckRequest request = new BracketCheckRequest();
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/checkBrackets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void incorrectBrackets() throws Exception {
        BracketCheckRequest request = new BracketCheckRequest();
        request.setText("(Hello, (world)");
        when(bracketService.areBracketsCorrect(request.getText())).thenReturn(false);

        String json = objectMapper.writeValueAsString(request);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/checkBrackets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isCorrect").value(false));
    }

    @Test
    public void correctBrackets() throws Exception {
        BracketCheckRequest request = new BracketCheckRequest();
        request.setText("(Hello, (world))");
        when(bracketService.areBracketsCorrect(request.getText())).thenReturn(true);

        String json = objectMapper.writeValueAsString(request);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/checkBrackets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isCorrect").value(true));
    }
}
