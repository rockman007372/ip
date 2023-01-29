package duke.command;

import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

import java.time.LocalDate;

public class AddDeadlineCommand extends Command {
    private String deadlineDescription;
    private LocalDate by;
    public AddDeadlineCommand(String deadlineDescription, LocalDate by) {
        super();
        this.deadlineDescription = deadlineDescription;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task deadline = new Deadline(deadlineDescription, by);
        tasks.addTask(deadline);
        ui.formResponse("New deadline task added: " + deadline);
        storage.save(tasks.getList());
    }
}
