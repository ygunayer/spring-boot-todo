package com.yalingunayer.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yalingunayer.todo.models.TodoModel;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Long> {

    /**
     * Find todo items that are either completed or are incomplete. Note how
     * this method does not have any implementation in the codebase.
     * 
     * This is all thanks to Spring Data which scans the class and tries to
     * figure out which method is meant to do what based of its name.
     * 
     * @param isCompleted
     *            if <strong>true</strong>, show only the completed items, if
     *            <strong>false</strong>, show only the incomplete
     * @return list of todo items that meet the criteria
     */
    public List<TodoModel> findByIsCompleted(boolean isCompleted);
}
