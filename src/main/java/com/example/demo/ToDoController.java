package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoController {
    private static List<ToDo> todoList;
    public ToDoController() {
        todoList = new ArrayList<>();
        todoList.add(new ToDo(1,false,"Todo 1", 1));
        todoList.add(new ToDo(2,false,"Todo 2", 1));
    }
    @GetMapping("/todos")
    public ResponseEntity<List<ToDo>>  getTodos(){
        return ResponseEntity.ok(todoList);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/todos")
    public ResponseEntity<ToDo> createTodo(@RequestBody ToDo newToDo){
    todoList.add(newToDo);
    return ResponseEntity.status(HttpStatus.CREATED).body(newToDo);
    }
}
