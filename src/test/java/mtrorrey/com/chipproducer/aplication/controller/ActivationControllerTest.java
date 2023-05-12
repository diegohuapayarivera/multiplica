package mtrorrey.com.chipproducer.aplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import mtrorrey.com.chipproducer.aplication.service.ActivationService;
import mtrorrey.com.chipproducer.domain.models.ActivationDTO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivationControllerTest {
    private MockMvc mockMvc;

    @Mock
    ActivationService activationService;

    @InjectMocks
    private ActivationController activationController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(activationController).build();
    }


    @Test
    public void testActivation() throws Exception {
        ActivationDTO activationDTO = new ActivationDTO();
        activationDTO.setMetrorreySerial("123456789");
        doNothing().when(activationService).activation(activationDTO);
        mockMvc.perform(post("/chip-card/activation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(activationDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string("Mensaje enviado"));

    }

    @Test
    public void testFallbackActivation() throws Exception {
        mockMvc.perform(post("/chip-card/activation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());

    }


    @Test
    public void testHandleInvalidDataException() throws Exception {
        mockMvc.perform(post("/chip-card/activation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"chipId\": null}"))
                .andExpect(status().isOk());

    }
}
