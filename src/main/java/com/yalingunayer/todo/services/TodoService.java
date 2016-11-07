package com.yalingunayer.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yalingunayer.todo.dto.request.CreateTodo;
import com.yalingunayer.todo.dto.response.TodoDto;
import com.yalingunayer.todo.models.TodoModel;
import com.yalingunayer.todo.repositories.TodoRepository;

/**
 * Service layer for the Todo domain
 */
@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /**
     * List todo items
     * 
     * @param showCompleted
     *            whether to list completed, incomplete or all items
     * 
     * @see TodoRepository#findByIsCompleted(showCompleted)
     * 
     * @return list of todo items
     */
    public List<TodoModel> list(final Optional<Boolean> showCompleted) {
        return showCompleted.isPresent() ? todoRepository.findByIsCompleted(showCompleted.get()) : todoRepository.findAll();
    }

    /**
     * Create a todo item
     * 
     * @param dto
     *            request body that contains todo content
     * 
     * @see TodoDto
     * 
     * @return the newly created todo item
     */
    public TodoModel create(final CreateTodo dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Missing argument `dto`");
        }

        if (dto.getContent() == null) {
            throw new IllegalArgumentException("Missing todo content");
        }

        final TodoModel todo = new TodoModel(dto.getContent());
        return todoRepository.save(todo);
    }
}
