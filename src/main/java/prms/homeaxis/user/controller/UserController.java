package prms.homeaxis.user.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import prms.homeaxis.landlord.entities.Property;
import prms.homeaxis.landlord.service.PropertyService;
import prms.homeaxis.manager.entities.Manager;
import prms.homeaxis.tenant.entities.Tenant;
import prms.homeaxis.user.entities.User;
import prms.homeaxis.user.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    PropertyService propertyService;
    
    @GetMapping("/")
    public String OpenIndexPage(Model model) {
    	 List<Property> allProperties = propertyService.getAllProperties();
         model.addAttribute("allproperties", allProperties);
        return "user/index";
    }
    
    @GetMapping("/openLoginPage")
    public String openLoginPage() {
        return "user/login";
    }
    
    @GetMapping("/ManagerRegistrationPage")
    public String ManagerRegistrationPage() {
        return "user/manager_registration";
    }
    
    @GetMapping("/TenantRegistrationPage")
    public String TenantRegistrationPage(){
        return "user/tenant_registration";
    }
    @GetMapping("/forgotPassword")
    public String forgotPasswordPage() {
        return "user/forgotPassword";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {

        System.out.println("\n username :" + username);
        System.out.println("\n password :" + password);

        // Fetch user from db
        Optional<User> optUser = userService.fetchUserBy(username);

        if (optUser.isEmpty()) {
            model.addAttribute("message", "Wrong username");
            return "user/login";
        }

        User registeredUser = optUser.get();

        System.out.println("\n user from database---------");
        System.out.println(registeredUser);

        if (!userService.matchPassword(password, registeredUser)) {
            model.addAttribute("message", "Wrong Password");
            return "user/login";
        }

        session.setAttribute("loggedInUser", registeredUser);
        int roleId = registeredUser.getRole_id();
        boolean isAuthorized = registeredUser.isStatus();

        if (roleId == 1) {
            return "landlord/dashboard";
        } else if (isAuthorized && roleId == 2) {
        	 List<Property> allProperties = propertyService.getAllProperties();
             model.addAttribute("allproperties", allProperties);
            return "user/index";
        } else if (isAuthorized && roleId == 3) {
        	 List<Property> allProperties = propertyService.getAllProperties();
             model.addAttribute("allproperties", allProperties);
            return "user/index";
        } else {
            model.addAttribute("message", "Your application is pending");
            return "user/login";
        }
    }
    
    
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    
    @PostMapping("/managerRegister")
    public ModelAndView registration(@ModelAttribute User user, @ModelAttribute Manager manager, ModelAndView mView) {
        user.setRole_id(2);
        
        System.out.println("\n User details-------");
        System.out.println(user);
        System.out.println(manager);

        int result = userService.registerManager(user, manager);

        if (result > 0) {
            mView.setViewName("user/login");
            mView.addObject("message", "\n Registration success. Please login to continue");
        } else {
            mView.setViewName("user/manager_registration");
            mView.addObject("message", "\n Registration failed. Please try again");
        }
        return mView;
    }
    
    @PostMapping("/tenantRegister")
    public ModelAndView tenantregistration(@ModelAttribute User user, @ModelAttribute Tenant tenant, ModelAndView mView) {
        tenant.setTenantStatus("Active");
        user.setRole_id(3);
        System.out.println("\n User details-------");
        System.out.println(user);
        System.out.println(tenant);

        int result = userService.registerTenant(user, tenant);

        if (result > 0) {
            mView.setViewName("user/login");
            mView.addObject("message", "\n Registration success. Please login to continue");
        } else {
            mView.setViewName("user/tenant_registration");
            mView.addObject("message", "\n Registration failed. Please try again");
        }
        return mView;
    }
    @PostMapping("/resetPassword")
	public String resetPassword(@RequestParam String username, Model model, String newPassword) {
	    Optional<User> optUser = userService.fetchUserBy(username);
 
	    if (optUser.isEmpty()) {
	        model.addAttribute("message", "Invalid username");
	        return "user/forgotPassword";
	    }
 
	    User user = optUser.get();
	    userService.updatePassword(user, newPassword);
 
	    model.addAttribute("message", "Password has been reset. Please log in with your new password.");
	    return "user/login";
	}
    @GetMapping("/viewProfile")
    public String viewProfile(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        

        if (loggedInUser == null) {
            model.addAttribute("message", "You need to log in first.");
            return "user/login";
        }
        List<User> profile = userService.getAllUsers();
        model.addAttribute("user", loggedInUser);
        model.addAttribute("profile",profile);
        return "user/profile";
    }
    @GetMapping("/editProfile")
    public String editProfile(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            model.addAttribute("message", "You need to log in first.");
            return "user/login";
        }

        model.addAttribute("user", loggedInUser);
        return "user/editProfile";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(HttpSession session, 
                                @RequestParam("name") String name,
                                @RequestParam("email") String email,
                                @RequestParam("mobile") String mobile,@RequestParam("dob") String dob, 
                                @RequestParam("profileImage") MultipartFile profileImage,
                                @RequestParam("idProof") MultipartFile idProof,
                                Model model) throws IOException, ParseException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            model.addAttribute("message", "You need to log in first.");
            return "user/login";
        }

        loggedInUser.setName(name);
        loggedInUser.setEmailId(email);
        loggedInUser.setMobile(mobile);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = sdf.parse(dob);
        loggedInUser.setDateOfBirth(new java.sql.Date(parsedDate.getTime()));
        
        
        userService.updateUser(loggedInUser, profileImage, idProof);
        session.setAttribute("loggedInUser", loggedInUser);

        return "redirect:/viewProfile";
    }
}