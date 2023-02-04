package duke.command;

import duke.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Represents a Delete command.
 */
public class DeleteTaskCommand extends Command {
    private int index;
    public DeleteTaskCommand(int taskIndex) {
        this.index = taskIndex;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task deleted = tasks.deleteTask(index - 1);
        storage.save(tasks.getList());
        return ui.formResponse("Task deleted: " + deleted);
    }
}

