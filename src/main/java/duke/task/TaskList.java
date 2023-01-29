package duke.task;

import duke.DukeException;

import java.time.LocalDate;
import java.util.List;

public class TaskList {
    private List<Task> taskList;

    public TaskList(List<Task> list) {
        taskList = list;
    }

    public List<Task> getList() {
        return this.taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public String listTasks() throws DukeException {

        if (taskList.size() == 0) {
            throw new DukeException("No tasks available.");
        }

        StringBuilder stringList = new StringBuilder();
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            stringList.append((i + 1) + ". " + task.toString());

            if (i < taskList.size() - 1) {
                stringList.append(System.lineSeparator());
            }
        }

        return stringList.toString();
    }

    private void checkIndex(int idx) throws DukeException {
        if (idx < 0 || idx >= taskList.size()) {
            throw new DukeException("Task index out of bounds.");
        }
    }

    public void markTask(int idx) throws DukeException {
        checkIndex(idx);
        Task t = taskList.get(idx);
        t.markAsDone();
    }

    public void unmarkTask(int idx) throws DukeException {
        checkIndex(idx);
        Task t = taskList.get(idx);
        t.markAsUndone();
    }

    /**
     * Deletes the duke.task with the same index.
     *
     * @param idx Index of the duke.task in the list.
     * @return duke.task.Task deleted.
     * @throws DukeException If index is out of bounds.
     */
    public Task deleteTask(int idx) throws DukeException {
        checkIndex(idx);
        Task t = taskList.get(idx);
        taskList.remove(t);
        return t;
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }


}
