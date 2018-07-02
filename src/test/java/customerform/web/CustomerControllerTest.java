package customerform.web;

import customerform.data.CustomerRepository;
import customerform.domain.Customer;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class CustomerControllerTest {

    @Test
    public void shouldProcessRegistration() throws Exception {
        CustomerRepository mockRepository = mock(CustomerRepository.class);
        Customer unsaved = new Customer("minhnln",
                "nhatminh0411",
                "Ngo Le Nhat Minh",
                "ngolenhatminh@gmail.com");
        Customer saved = new Customer(1L,
                "minhnln",
                "nhatminh0411",
                "Ngo Le Nhat Minh",
                "ngolenhatminh@gmail.com");

        CustomerController controller = new CustomerController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/customer/register")
                .param("fullName", "Ngo Le Nhat Minh")
                .param("username", "minhnln")
                .param("password", "nhatminh0411")
                .param("email", "ngolenhatminh@gmail.com"))
                .andExpect(redirectedUrl("/customer/minhnln"));

        verify(mockRepository, atLeastOnce()).save(unsaved);
    }

//    @Test
//    public void shouldFailValidationWithNoData() throws Exception {
//        CustomerRepository mockRepository = mock(CustomerRepository.class);
//        CustomerController controller = new CustomerController(mockRepository);
//        MockMvc mockMvc = standaloneSetup(controller).build();
//
//        mockMvc.perform(post("/spitter/register"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("registerForm"))
//                .andExpect(model().errorCount(5))
//                .andExpect(model().attributeHasFieldErrors(
//                        "fullName", "username", "password", "email"));
//    }

}