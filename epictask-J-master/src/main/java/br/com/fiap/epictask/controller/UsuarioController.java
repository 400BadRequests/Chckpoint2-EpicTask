package br.com.fiap.epictask.controller;

import br.com.fiap.epictask.model.Usuario;
import br.com.fiap.epictask.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping("/login")
	public String formLogin() {
		return "login";
	}

	@PostMapping("/register")
	public String save(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			return "registerUser";
		}
		usuarioRepository.save(usuario);
		return "login";
	}

	@RequestMapping("/register")
	public String formRegister(Usuario usuario) { return "registerUser"; }

	@GetMapping("/usuarios")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("usuarios");
		List<Usuario> usuarios = usuarioRepository.findAll();
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}
}
