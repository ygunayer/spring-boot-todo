package com.yalingunayer.todo.dto.request;

/**
 * A basic DTO to serve as the wrapper for the properties of a request to create
 * a todo item
 */
public class CreateTodo {
    /**
     * The contents of the todo item to create
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
