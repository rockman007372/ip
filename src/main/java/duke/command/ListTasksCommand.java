package duke.command;

import duke.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Represents a List command.
 */
public class ListTasksCommand extends Command {
    public ListTasksCommand() {
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String tasksString = tasks.listTasks();
        return ui.formResponse(tasksString);
    }
}
