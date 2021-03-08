package simple.wireframe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import simple.wireframe.model.ContactRequest;
import simple.wireframe.services.ContactRequestService;
import simple.wireframe.services.RequestTypeService;
import simple.wireframe.services.ValidationServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    RequestTypeService requestTypeService;

    @Autowired
    ContactRequestService contactRequestService;

    @Autowired
    ValidationServiceImpl validationService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("requestTypes", requestTypeService.gettAllRequestTypes());
        model.addAttribute("yourRequestMaxChars", 10);
        model.addAttribute("selected", 0);

        return "index";
    }

    @GetMapping("/{selectedTypeId}")
    public String homePageWithSelectedType(Model model, @PathVariable String selectedTypeId) {
        model.addAttribute("requestTypes", requestTypeService.gettAllRequestTypes());
        model.addAttribute("yourRequestMaxChars", 10);
        model.addAttribute("selected", selectedTypeId);

        return "index";
    }

    @PostMapping("/validate")
    public RedirectView validateData(RedirectAttributes redirectAttributes, @RequestParam String requestType, @RequestParam String name,
                                     @RequestParam String surname, @RequestParam String policyNumber, @RequestParam String yourRequest) {
        List<String> validationResults = new ArrayList<>();
        validationResults.add(validationService.validateAttrValueForLettersOnly("name", name));
        validationResults.add(validationService.validateAttrValueForLettersOnly("surname", surname));
        validationResults.add(validationService.validateAttrValueForAlphanumericOnly("policyNumber", policyNumber));

        List<String> errorMessages = validationResults.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());

        if(errorMessages != null && !errorMessages.isEmpty()) {
            redirectAttributes.addFlashAttribute("requestType", requestType);
            redirectAttributes.addFlashAttribute("name", name);
            redirectAttributes.addFlashAttribute("surname", surname);
            redirectAttributes.addFlashAttribute("policyNumber", policyNumber);
            redirectAttributes.addFlashAttribute("yourRequest", yourRequest);
            redirectAttributes.addFlashAttribute("errorMessages", errorMessages);

            return new RedirectView("/"+requestTypeService.findByValue(requestType).getId(), true);
        } else {
            contactRequestService.saveContactRequest(new ContactRequest(requestType, policyNumber, name, surname, yourRequest));

            return new RedirectView("/", true);
        }
    }
}
