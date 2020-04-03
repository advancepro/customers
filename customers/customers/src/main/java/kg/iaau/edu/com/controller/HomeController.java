package kg.iaau.edu.com.controller;

import kg.iaau.edu.com.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    CustomerDao customerDao;

    @RequestMapping("/")
    public String HomePage()
    {
        return "index";
    }

    @RequestMapping("/customers")
    public String showCustomers()
    {
        return "customer";
    }
}
