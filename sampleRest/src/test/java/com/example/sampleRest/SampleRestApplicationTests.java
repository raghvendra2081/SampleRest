package com.example.sampleRest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SampleRestApplicationTests {

	
	private MockMvc mocMvc;
	
	@InjectMocks
    testController testcontroller;
	
	@Before
	public void setup() throws Exception {
		mocMvc = MockMvcBuilders.standaloneSetup(testcontroller).build();
	}
	
    @Test
    public void testGreeting() throws Exception{
        mocMvc.perform(MockMvcRequestBuilders.get("/api/greeting"))
       .andExpect(MockMvcResultMatchers.status().isOk())
       .andExpect(MockMvcResultMatchers.content().string("test greeting"));
    }
    
    @Test
    public void testCards() throws Exception{
        mocMvc.perform(MockMvcRequestBuilders.get("/api/cards/1234/sfwdlfks9fdsjru832"))
       .andExpect(MockMvcResultMatchers.status().isOk())
       .andExpect(MockMvcResultMatchers.content().string("12345678901234sfwdlfks9fdsjru832"));
    }
	


}
