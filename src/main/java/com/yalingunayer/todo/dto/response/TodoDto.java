package com.yalingunayer.todo.dto.response;

import com.yalingunayer.todo.models.TodoModel;

/**
 * Basic DTO that represents a todo item
 */
public class TodoDto {
    /**
     * Whether the item is marked as completed
     */
    private final boolean isCompleted;

    /**
     * The contents of the item
     */
    private final String content;

    public TodoDto(final TodoModel todo) {
        this.isCompleted = todo.isCompleted();
        this.content = todo.getContent();
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getContent() {
        return content;
    }

}
