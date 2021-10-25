package br.com.fiap.epictask.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.fiap.epictask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.epictask.model.User;
import br.com.fiap.epictask.repository.UserRepository;
import br.com.fiap.epictask.service.AuthenticationService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private MessageSource messages;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("users");
		List<User> users = service.findAll();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@RequestMapping("/new")
	public String create(User user) {
		return "user-form";
	}

	@RequestMapping("/{id}")
	public ModelAndView update(@PathVariable Long id) {
		ModelAndView view = new ModelAndView("alter-user");
		Optional<User> user = service.findById(id);
		view.addObject("user",user);
		return view;
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirect){
		service.deleteById(id);
		redirect.addFlashAttribute("message", "Deletado com sucesso");
		return "redirect:/user";
	}

	@PostMapping
	public String save(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) return "user-form";
		service.create(user);
		redirect.addFlashAttribute("message", messages.getMessage("newuser.success", null, LocaleContextHolder.getLocale()));
		return "redirect:user";
	}

}
