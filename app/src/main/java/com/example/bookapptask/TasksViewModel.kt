package com.example.bookapptask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TasksViewModel (val dao: TaskDao): ViewModel() {

    var newTaskName = ""
    val tasks = dao.getAll()
//    val tasksString = Transformations.map(tasks) {
//        tasks -> formatTasks(tasks)
//    }

//    private val tasks: LiveData<List<Task>> = dao.getAll()
//    val tasksString: LiveData<String> = MediatorLiveData<String>().apply {
//        addSource(tasks) { tasks ->
//            value = formatTasks(tasks)
//        }
//    }

    private val _navigateToTask = MutableLiveData<Long?>()
    val navigateToTask: LiveData<Long?>
        get() = _navigateToTask

    fun addTask() {
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }

    fun onTaskClicked(taskId: Long) {
        _navigateToTask.value = taskId
    }

    fun onTaskNavigated() {
        _navigateToTask.value = null
    }

//    fun formatTasks(tasks: List<Task>) : String {
//        return tasks.fold(""){
//            str, item -> str + '\n' + formatTask(item)
//        }
//    }
//    fun formatTask(task: Task): String {
//        var str = "ID: ${task.taskId}"
//        str += '\n' + "Name: ${task.taskName}"
//        str += '\n' + "Complete: ${task.taskDone}" + '\n'
//        return str
//    }
}