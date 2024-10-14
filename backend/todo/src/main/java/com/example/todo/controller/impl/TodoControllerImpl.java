package com.example.todo.controller.impl;

import com.example.todo.controller.ITodoController;
import com.example.todo.dto.DtoTodo;
import com.example.todo.entity.Todo;
import com.example.todo.services.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoControllerImpl implements ITodoController {

    @Autowired
    private ITodoService todoService;

    @Override
    @PostMapping(path = "/save")
    public Todo createTodo(@RequestBody DtoTodo dtoTodo) {
        return todoService.createTodo(dtoTodo);
    }

    @Override
    @PutMapping("/update/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody DtoTodo dtoTodo) {
        return todoService.updateTodo(id, dtoTodo);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    @Override
    @GetMapping(path = "/all-list")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @Override
    @GetMapping("/list/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }
}
