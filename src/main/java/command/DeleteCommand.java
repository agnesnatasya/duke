package command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

import task.Task;

/**
 * A command object for deleting tasks from the list.
 */
public class DeleteCommand extends Command {
    private final Integer taskNumber;

    /**
     * Constructs a command object to delete task from the list.
     * @param taskNumber The index of the task to be deleted.
     */
    public DeleteCommand(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Executes the command to delete task from the list.
     * @param tasks List of tasks of the Duke object.
     * @param ui UI object of the Duke object.
     * @param storage Storage object of the Duke object.
     * @return String as the response of the execution.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task removedTask = tasks.get(taskNumber - 1);
            tasks.remove(removedTask);
            storage.deleteDrive(taskNumber);
            return ui.showRemove(removedTask, tasks.size());
        } catch (IndexOutOfBoundsException e) {
            return ui.showException(new DukeException(
                    "☹ OOPS!!! The description of a delete cannot be empty."));
        } catch (DukeException de) {
            return ui.showException(de);
        }
    }
}