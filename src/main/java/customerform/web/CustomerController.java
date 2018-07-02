package customerform.web;

import customerform.data.CustomerRepository;
import customerform.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @Valid Customer customer,
            Errors errors) {
        if (errors.hasErrors())
            return "registerForm";

        customerRepository.save(customer);
        return "redirect:/customer/" + customer.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showCustomerProfile(
            @PathVariable String username, Model model) {
        Customer customer = customerRepository.findByUserName(username);
        model.addAttribute(customer);
        return "profile";
    }
}
