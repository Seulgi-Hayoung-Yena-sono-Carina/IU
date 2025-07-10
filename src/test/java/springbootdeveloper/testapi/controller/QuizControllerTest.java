package springbootdeveloper.testapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void mockMvcSetUp(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    public void getQuiz1() throws Exception{
        final String url="/quiz";

        final ResultActions result=mockMvc.perform(get(url)
                .param("code","1"));

        result
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Created"));

    }

    @Test
    public void getQuiz2() throws Exception{
        final String url ="/quiz";

        final ResultActions result= mockMvc.perform(get(url).param("code","2"));

        result
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Bad Request"));
    }
}