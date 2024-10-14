package com.example.todo.services.impl;

import com.example.todo.dto.DtoTodo;
import com.example.todo.entity.Todo;
import com.example.todo.repository.ITodoRepository;
import com.example.todo.services.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private ITodoRepository todoRepository;

    @Override
    public Todo createTodo(DtoTodo dtoTodo) {
        Todo todo = new Todo();
        todo.setTitle(dtoTodo.getTitle());
        todo.setDescription(dtoTodo.getDescription());
        todo.setCompleted(dtoTodo.isCompleted());
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, DtoTodo dtoTodo) {
        Optional<Todo> todoOpt = todoRepository.findById(id);
        if (todoOpt.isPresent()) {
            Todo todo = todoOpt.get();
            todo.setTitle(dtoTodo.getTitle());
            todo.setDescription(dtoTodo.getDescription());
            todo.setCompleted(dtoTodo.isCompleted());
            return todoRepository.save(todo);
        }
        return null;
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }
}
