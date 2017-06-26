package com.jdpaley;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    
	
	@Autowired
    private StudentRepository studentRepository;
   
    
	@GetMapping(path="/")
	public String menu(Model m) {
		
		WebDataObject wdo = new WebDataObject();
		m.addAttribute("WebData", wdo);
//		Student st = new Student();
//		m.addAttribute("S", st);
		return "index";
	}
    
	
    @PostMapping(path = "/")
    public String saveStudent(@ModelAttribute("WebData") WebDataObject wdo, Model m)
    	{

	    	String ch = wdo.getChoice().toUpperCase();
			System.out.println("CHOICE = " + ch);
			
			if (ch.equals("A")) {
				
                Student student = new Student();  
                m.addAttribute("S", student);
				return "add";
			}
			else if (ch.equals("D")) {
				
				
				return "delete";
			} 
			else if (ch.equals("L")) {
				
				
				return "list";
			} 
			else {
				wdo.setChoice(null);
				return "index";
			}				
    	}
    
    
/*    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String studentValidator(@Valid Student s, BindingResult bindingResult)
    
    {		
    		if (bindingResult.hasErrors())
    		{
    			return "index";
				
    		}else{
    			System.out.println("Form data valid. REDIRECTING to /valid");
    			return "redirect:/valid";
			
    		}
			
    }*/
    
    
    @PostMapping(path="/add")
    public String add(@ModelAttribute("S") Student student, Model m)
            {
        		studentRepository.save(student);
        		WebDataObject wdo = new WebDataObject();
        		m.addAttribute("WebData", wdo);
                return "index";
            }
 
    
    @PostMapping(path="/list")
    public String getAll( Model m){
    	
    	Iterable<Student> students= studentRepository.findAll();
    	m.addAttribute("Students",students);
    	return "list";
    }
}