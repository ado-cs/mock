package com.example.mock.services.impl;

import com.example.mock.common.Result;
import com.example.mock.common.Task;
import com.example.mock.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TaskServiceImpl implements TaskService {
    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();

    @Override
    public Result newTask(Task task) {
        if (task == null) return Result.INVALID_PARAMETER;
        tasks.put(task.getId(), task);
        return Result.SUCCESS;
    }

    @Override
    public Result delTask(Task task) {
        if (task == null) return Result.INVALID_PARAMETER;
        return tasks.remove(task.getId()) != null ? Result.SUCCESS : Result.NA_DATA;
    }

    @Override
    public Result listTask() {
        return Result.ok(new ArrayList<>(tasks.values()));
    }
}
