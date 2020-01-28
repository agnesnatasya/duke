public class Deadline extends Task {
    private String date;

    public Deadline(String name, String date) {
        super(name);
        this.date = date.substring(date.indexOf(" ")).trim();
    }

    public Deadline(String name, String date, boolean isDone) {
        super(name, isDone);
        this.date = date;
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + date + ")";
    }

    public String writeDrive() {
        return "D|" + (super.isDone()? "1|" : "0|") + this.name +"|" + this.date;
    }

    public Deadline setDone() {
        return new Deadline(this.name, this.date, true);
    }
}
