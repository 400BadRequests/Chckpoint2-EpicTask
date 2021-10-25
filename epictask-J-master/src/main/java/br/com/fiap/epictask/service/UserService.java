package br.com.fiap.epictask.service;

import br.com.fiap.epictask.model.User;
import br.com.fiap.epictask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        List<User> users =  repository.findAll();
        return users;
    }

    public void create(User user){
        user.setPassword(AuthenticationService.getPasswordEnconder().encode(user.getPassword()));
        repository.save(user);
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }
}
