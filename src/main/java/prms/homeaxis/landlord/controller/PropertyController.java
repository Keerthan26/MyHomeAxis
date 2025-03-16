package prms.homeaxis.landlord.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

import prms.homeaxis.landlord.entities.Property;
import prms.homeaxis.landlord.service.PropertyService;

@Controller
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	PropertyService propertyService;

	@GetMapping("/openAddProperty")
	public String openAddProperty(Model model) {
		model.addAttribute("property", new Property());
		return "landlord/addproperty"; // JSP name
	}

	@PostMapping("/addProperty")
	public ModelAndView addProperty(@ModelAttribute Property property, ModelAndView mView) {

		property.setStatus("Active");
		System.out.println(property);
		// Insert the property into the database
		int result = propertyService.registerProperty(property);

		if (result > 0) {
			mView.setViewName("landlord/addproperty");
			mView.addObject("message", "Property addition successful");
		} else {
			mView.setViewName("landlord/addproperty");
			mView.addObject("message", "Property addition failed");
		}
		return mView;
	}
	
	@GetMapping("/viewproperties")
	public ModelAndView viewProperties(ModelAndView mview) {
	    List<Property> allProperties = propertyService.getAllProperties();
	    if (allProperties == null) {
	        allProperties = new ArrayList<>(); // Handle the null case
	    }
	    System.out.println("allproperties : " + allProperties);
	    mview.addObject("allproperties", allProperties);
	    mview.setViewName("landlord/view_property");
	    return mview;
	}
	@GetMapping("/viewProperty")
	 public String viewProperty(@RequestParam("propertyId") Long propertyId, Model model) {
        Property property = propertyService.getPropertyById(propertyId);
        if (property != null) {
            model.addAttribute("property", property);
            return "landlord/viewProperty";
        } else {
            model.addAttribute("error", "Property not found.");
            return "error";
        }
    }
	
	@GetMapping("/updateProperty")
    public String showUpdateForm(@RequestParam("propertyId") Long propertyId, Model model) {
        Property property = propertyService.getPropertyById(propertyId);
        if (property != null) {
            model.addAttribute("property", property);
            return "landlord/updateProperty";
        } else {
            model.addAttribute("error", "Property not found.");
            return "error";
        }
    }

    @PostMapping("/updateProperty")
    public String updateProperty(Property property) {
        propertyService.saveProperty(property);
        return "redirect:/property/viewProperty?propertyId=" + property.getPropertyId();
    }

    @PostMapping("/deleteProperty")
    public String deleteProperty(@RequestParam("propertyId") int propertyId) {
        propertyService.deletePropertyById(propertyId);
        return "redirect:/landlord/manageproperties";
    }
    @GetMapping("/properties/{tenantId}")
    public String openPropertyPage(@PathVariable String tenantId,Model model) {
    	System.out.println(tenantId);
        int id=Integer.parseInt(tenantId);
        List<Property> properties = propertyService.findPropertyByUserId(id);
        if (properties == null || properties.isEmpty()) {
            System.out.println("No properties found for user ID: " + id );
        } else {
            System.out.println("Properties found: " + properties.size());
        }
        model.addAttribute("properties", properties);
        return "tenant/viewProperty";
    }

 
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ModelAndView handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", "Invalid user ID format: " + ex.getValue());
        return modelAndView;
    }
}
