package com.example.mock.services;

import com.example.mock.common.Result;
import com.example.mock.common.Task;

public interface TaskService {
    Result newTask(Task task);
    Result delTask(Task task);
    Result listTask();
}
