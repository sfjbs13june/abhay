package com.abhay.app.ContainerTest;

import com.abhay.app.Container.CalculatorOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorOperation.class)
public class CalculatorOperationIntegrationTesting {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculatorOperationAdd() throws Exception {
        long a = 10L;
        long b = 10L;
        ResultActions responseEntity = mockMvc.perform(get("/add").param("a", String.valueOf(a)).param("b", String.valueOf(b)));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("20", result);
    }

    @Test
    public void testCalculatorOperationSub() throws Exception {
        long a = 22L;
        long b = 10L;
        ResultActions responseEntity = mockMvc.perform(post("/sub").param("a", String.valueOf(a)).param("b", String.valueOf(b)));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("12", result);
    }

    @Test
    public void testCalculatorOperationMul() throws Exception {
        long a = 5L;
        long b = 10L;
        ResultActions responseEntity = mockMvc.perform(put("/mul").param("a", String.valueOf(a)).param("b", String.valueOf(b)));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("50", result);
    }

    @Test
    public void testCalculatorOperationDiv() throws Exception {
        long a = 8L;
        long b = 4L;
        ResultActions responseEntity = mockMvc.perform(delete("/div").param("a", String.valueOf(a)).param("b", String.valueOf(b)));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("2", result);
    }

}
