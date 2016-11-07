package com.yalingunayer.todo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yalingunayer.todo.dto.request.CreateTodo;
import com.yalingunayer.todo.dto.response.TodoDto;
import com.yalingunayer.todo.services.TodoService;

@RestController
@RequestMapping(value = "/api/todo", produces = "application/json")
@Transactional
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(final TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(path = "/*", method = RequestMethod.GET)
    public List<TodoDto> listTodos(final @RequestParam Optional<Boolean> showCompleted) {
        return todoService.list(showCompleted).stream().map(todo -> new TodoDto(todo)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/*", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
    public TodoDto createTodo(final @RequestBody(required = true) CreateTodo dto) {
        return new TodoDto(todoService.create(dto));
    }
}
