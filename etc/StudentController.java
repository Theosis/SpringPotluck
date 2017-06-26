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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
   
	@GetMapping(path="/")
	public String add(Model m) {
		
		WebDataObject wdo = new WebDataObject();
		m.addAttribute("WebData", wdo);
		Student st = new Student();
		m.addAttribute("S", st);
		return "index";
	}
    
    @GetMapping(path="/add")
    public String addNew(Model m)
            {
                Student student = new Student();  
//                WebDataObject wdo = new WebDataObject();
                m.addAttribute("stud", student);
//                m.addAttribute("WebData", wdo);
//                System.out.println(wdo);
//                System.out.println(m);
                return "index";
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
    
    @RequestMapping(path = "/" , method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("Student") Student st, @ModelAttribute("WebData") WebDataObject wdo, Model m)
    	{
//    	System.out.println("-----------------------------------");
//    	System.out.println("STUDENT = " + st);
//    	System.out.println("-----------------------------------");
    	m.addAttribute("stud", st);
		System.out.println("CHOICE = " + wdo.getChoice());
		studentRepository.save(st);
		return "saved";
		
    	}
    
    @GetMapping(path="/all")
    public String getAll( Model m){
    	
    	Iterable<Student> students= studentRepository.findAll();
    	m.addAttribute("Students",students);
    	return "list";
    }
}