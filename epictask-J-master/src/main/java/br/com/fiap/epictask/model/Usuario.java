package br.com.fiap.epictask.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome inválido, informe um nome")
    private String nome;

    @NotBlank(message = "Email inválido, informe um email")
    @Email(message = "Formato de e-mail errado")
    private String email;

    @Size(min=8, message = "A senha deve ter no minino 8 caracteres")
    @Size(max=20, message = "A senha deve ter no maximo 20 caracteres")
    private String senha;
}
