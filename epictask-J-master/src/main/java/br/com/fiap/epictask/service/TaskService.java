package br.com.fiap.epictask.service;

import br.com.fiap.epictask.model.Task;
import br.com.fiap.epictask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> findAll(){
        List<Task> tasks = repository.findAll();
        return tasks;
    }

    public void create(Task task){
        repository.save(task);
    }

    public Optional<Task> findById(Long id){
        Optional<Task> task = repository.findById(id);
        return task;
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
