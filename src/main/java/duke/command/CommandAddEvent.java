package duke.command;

import java.time.LocalDate;

import duke.storage.Storage;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Represents an Event command.
 */
public class CommandAddEvent extends Command {
    private String description;
    private LocalDate from;
    private LocalDate to;

    /**
     * Constructor for CommandAddEvent.
     *
     * @param eventDescription Description of an event task.
     * @param from Date the event starts.
     * @param to Date the event ends.
     */
    public CommandAddEvent(String eventDescription, LocalDate from, LocalDate to) {
        this.description = eventDescription;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task event = new Event(description, from, to);
        tasks.addTask(event);
        ui.formResponse("New event task added: " + event);
        storage.save(tasks.getList());
    }
}