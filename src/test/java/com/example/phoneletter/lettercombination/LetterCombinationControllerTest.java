/**
 * 
 */
package com.example.phoneletter.lettercombination;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author kannan
 *
 */
@AutoConfigureMockMvc
@ContextConfiguration(classes = {LetterCombinationController.class, LetterCombinationService.class, LetterCombination.class})
@WebMvcTest
public class LetterCombinationControllerTest {
	
	@Mock
	private LetterCombinationService service;

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void testGetLetterCombinations() throws Exception {
		Mockito.when(service.getLettersCombination(ArgumentMatchers.anyLong()))
			.thenReturn(new LetterCombination());
		
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/letters/2345678")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String resultJson = result.getResponse().getContentAsString();
        assertNotNull(resultJson);
    }
	
	@Test
	public void testGetLetterCombinationsByPage() throws Exception {
		Mockito.when(service.getLettersCombination(ArgumentMatchers.anyLong()))
			.thenReturn(new LetterCombination());
		
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/letters/2345678/page/3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String resultJson = result.getResponse().getContentAsString();
        assertNotNull(resultJson);
    }

}
