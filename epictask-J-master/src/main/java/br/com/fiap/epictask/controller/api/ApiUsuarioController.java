package br.com.fiap.epictask.controller.api;

import br.com.fiap.epictask.model.Usuario;
import br.com.fiap.epictask.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class ApiUsuarioController {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @GetMapping()
        public Page<Usuario> index(
                @RequestParam(required = false) String nome,
                @PageableDefault(page = 0, size = 10) Pageable pageable) {

            if (nome == null) {
                return usuarioRepository.findAll(pageable);
            }
            return usuarioRepository.findUsuarioByNome("%" + nome + "%", pageable);
        }

        @PostMapping()
        public ResponseEntity<Usuario> create(@RequestBody Usuario usuario, UriComponentsBuilder uriBuilder) {
            usuarioRepository.save(usuario);
            URI uri = uriBuilder.path("/api/task/{id}").buildAndExpand(usuario.getId()).toUri();
            return ResponseEntity.created(uri).body(usuario);
        }

        @GetMapping("{id}")
        public ResponseEntity<Usuario> get(@PathVariable Long id) {
            Optional<Usuario> usuario = usuarioRepository.findById(id);

            if (usuario.isPresent())
                return ResponseEntity.ok( usuario.get() );

            return ResponseEntity.notFound().build();
        }

        @DeleteMapping("{id}")
        public ResponseEntity<Usuario> delete(@PathVariable Long id){
            Optional<Usuario> usuario = usuarioRepository.findById(id);

            if(usuario.isEmpty()) return ResponseEntity.notFound().build();

            usuarioRepository.deleteById(id);

            return ResponseEntity.ok().build();
        }
}
