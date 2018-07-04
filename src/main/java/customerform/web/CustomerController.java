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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.tiles3.SpringWildcardServletTilesApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/customer")
public class CustomerController extends HttpServlet {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Customer());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration (
            @Valid Customer customer,
            Errors errors) throws IllegalStateException, IOException {
        if (errors.hasErrors())
            return "registerForm";

        customerRepository.save(customer);
        MultipartFile profilePicture = customer.getProfilePicture();
        File localFile = new File("/tmp/customer/" + customer.getUsername() + ".jpg");
        profilePicture.transferTo(localFile);
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
