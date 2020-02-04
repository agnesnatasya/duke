package duke;

/**
 * An abstract object of task, has a name and a done status.
 */
public abstract class Task {
    protected String name;
    private boolean isDone;

    /**
     * Constructor for an abstract task, which is not done.
     * @param name The name of event task
     */
    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    /**
     * Protected constructor for a task, in which the done status can be specified.
     * @param name The name of event task
     * @param isDone The done status of event task
     */
    protected Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    /**
     * String which states the name and done status of a task.
     * @return The string of the task.
     */
    public String toString() {
        String done = isDone ? "0xE2 0x9C 0x93" : "0xE2 0x9C 0x97";
        return "[" + done + "] " + name;
    }

    /**
     * Boolean of done status of the task.
     * @return Boolean of the done status of the task.
     */
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * Method to return a the name of the task.
     * @return A string of the name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract method to return a new task with specified done status.
     * @return A new task object.
     */
    public abstract Task setDone();

    /**
     * Abstract method to return a string of the task object to be written to a file.
     * @return A string of the task to be written to a file.
     */
    public abstract String writeDrive();
}