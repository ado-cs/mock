package com.example.mock.web;

import com.example.mock.common.Result;
import com.example.mock.common.Task;
import com.example.mock.services.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/task")
@RestController
public class TaskController {
    @Resource
    private TaskService taskService;

    @PostMapping("/add")
    public Result add(@RequestBody Task task) {
        return taskService.newTask(task);
    }

    @PostMapping("/del")
    public Result del(@RequestBody Task task) {
        return taskService.delTask(task);
    }

    @PostMapping("/list")
    public Result list() {
        return taskService.listTask();
    }
}
