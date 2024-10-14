package com.example.todo.services;

import com.example.todo.dto.DtoTodo;
import com.example.todo.entity.Todo;
import java.util.List;

public interface ITodoService {
    public Todo createTodo(DtoTodo dtoTodo);
    public Todo updateTodo(Long id, DtoTodo dtoTodo);
    public void deleteTodo(Long id);
    public List<Todo> getAllTodos();
    public Todo getTodoById(Long id);
}
