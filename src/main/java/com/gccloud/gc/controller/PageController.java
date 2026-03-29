package com.gccloud.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gccloud.gc.entities.Product;
import com.gccloud.gc.entities.User;
import com.gccloud.gc.forms.ProductForm;
import com.gccloud.gc.forms.UserForm;
import com.gccloud.gc.services.ProductServices;
import com.gccloud.gc.services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private ProductServices productServices;

    @RequestMapping("/about")
    public String aboutPage(Model model) {
        // sending data to thymeleaf
        model.addAttribute("visualRating", "4.9/5");
        model.addAttribute("isLogin", true);
        System.out.println("about page loaded");
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage(Model model) {
        System.out.println("services page loaded");
        return "services";
    }

    @RequestMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("isLogin", true);
        System.out.println("login page loaded");
        return "login";
    }

    @RequestMapping("/logout")
    public String logoutPage(Model model) {
        System.out.println("logout page loaded");
        return "logout";
    }

    @RequestMapping("/home")
    public String homePage(Model model) {
        System.out.println("home page loaded");
        return "home";
    }

    @RequestMapping("/contact")
    public String contactPage(Model model) {
        System.out.println("contact page loaded");
        return "contact";
    }

    @RequestMapping("/products")
    public String productsPage(Model model) {
        System.out.println("products page loaded");
        return "products";
    }

    @GetMapping("/productForm")
    public String productsFormPage(Model model) {
        return "productForm";
    }

    @PostMapping("/do-products")
    public String processRegister(@ModelAttribute ProductForm productForm) {

        System.out.println("do products start");
        System.out.println(productForm);
        System.out.println("TAGS FROM FORM: " + productForm.getCategoryTags());

        // ProductForm -> Product entity
        Product product = Product.builder()
                .name(productForm.getName())
                .description(productForm.getDescription())
                .model(productForm.getModel())
                .picture("https://th.bing.com/th/id/OIP.NTYJM1T90jW1QQUahumstAHaHa?w=172&h=180")
                .category(productForm.getCategory())
                .categoryTags(productForm.getCategoryTags())
                .build();

        Product savedProduct = productServices.saveProduct(product);

        System.out.println("TAGS IN ENTITY: " + product.getCategoryTags());
        System.out.println("Saved product: " + savedProduct);

        return "redirect:/productForm";
    }

    @GetMapping("/register")
    public String register(Model model) {

        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        return "register";
    }

    @PostMapping("/do-register")
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {

        System.out.println("do register start");
        System.out.println(userForm);

        // UserForm -> User entity
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://thumbs.dreamstime.com/z/default-avatar-profile-icon.jpg");

        User savedUser = userServices.saveUser(user);

        // success message
        session.setAttribute("message", "Registration successful! Please login to continue.");

        return "redirect:/register";
    }
}
