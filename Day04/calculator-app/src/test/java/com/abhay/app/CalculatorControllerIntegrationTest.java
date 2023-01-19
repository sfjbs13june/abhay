package com.abhay.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculatorControllerAdd() throws Exception{
        String a = "3.0";
        String b = "7.0";
        ResultActions responseEntity = mockMvc.perform(get("/add").param("a",a).param("b",b));
        responseEntity.andExpect(status().isOk());
        String result =responseEntity.andReturn().getResponse().getContentAsString();
        Assert.assertEquals("10.0",result);
    }

    @Test
    public void testCalculatorControllerSub() throws Exception{
        String a = "12.0";
        String b = "8.0";
        ResultActions responseEntity = mockMvc.perform(get("/sub").param("a",a).param("b",b));
        responseEntity.andExpect(status().isOk());
        String result =responseEntity.andReturn().getResponse().getContentAsString();
        Assert.assertEquals("4.0",result);
    }

    @Test
    public void testCalculatorControllerMul() throws Exception{
        String a = "10.0";
        String b = "7.0";
        ResultActions responseEntity = mockMvc.perform(get("/mul").param("a",a).param("b",b));
        responseEntity.andExpect(status().isOk());
        String result =responseEntity.andReturn().getResponse().getContentAsString();
        Assert.assertEquals("70.0",result);
    }

    @Test
    public void testCalculatorControllerDiv() throws Exception{
        String a = "10.0";
        String b = "5.0";
        ResultActions responseEntity = mockMvc.perform(get("/div").param("a",a).param("b",b));
        responseEntity.andExpect(status().isOk());
        String result =responseEntity.andReturn().getResponse().getContentAsString();
        Assert.assertEquals("2.0",result);
    }

}
