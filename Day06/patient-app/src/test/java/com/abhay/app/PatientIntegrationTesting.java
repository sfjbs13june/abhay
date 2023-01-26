package com.abhay.app;


import com.abhay.app.controller.PatientController;
import com.abhay.app.model.Patient;
import com.abhay.app.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({PatientController.class})
@ActiveProfiles(value = "test")
public class PatientIntegrationTesting {


    @InjectMocks
    PatientController patientController;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    PatientService patientService;
    @Value("${patient.post.url}")
    String posturl;

    @Value("${patient.put.url}")
    String putUrl;

    @Test
    public void testsavePatientPost() throws Exception {
        String secret = "Basic" + Base64Utils.encodeToString(("abhay123"+":"+"password").getBytes());
        Patient pat = new Patient("pat01","pat_test","23","male","fever");
        ResultActions responseEntity = mockMvc.perform(post(posturl).header(HttpHeaders.AUTHORIZATION, secret).contentType(MediaType.APPLICATION_JSON)
                .content(asObjectToJsonString(pat)).accept(MediaType.APPLICATION_JSON));

        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        Patient patientResult= asJsonStringToObject(result);
        assertNotNull(patientResult);
        assertEquals(patientResult.getId(),"pat01");
        assertEquals(patientResult.getName(),"pat_test");
        assertEquals(patientResult.getAge(),"23");
        assertEquals(patientResult.getGender(),"male");
        assertEquals(patientResult.getDisease(),"fever");

    }


    private String asObjectToJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Patient asJsonStringToObject( String result) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            Patient patient= mapper.readValue(result, Patient.class);
            return patient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
