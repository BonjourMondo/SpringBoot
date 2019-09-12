package com.energy.simulation.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class HomeControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void validateLogin() throws Exception {
        String content="{\"user\":\"admin\",\"password\":\"admin\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/data")
//                .param("name", "admin")
//                .param("password","admin")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void validateLogin2() throws Exception {
//        String content="{\"username\":\"admin\",\"password\":\"admin\"}";
        mockMvc.perform(MockMvcRequestBuilders.get("/data2")
                .param("username", "admin")
                .param("password","admin")
        )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}