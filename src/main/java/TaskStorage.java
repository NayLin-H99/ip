import java.util.ArrayList;

public class TaskStorage {

    private ArrayList<Task> storage = new ArrayList<>();

    // Adds a new task to the storage and returns a confirmation message
    public String add(Task task) {
        storage.add(task);
        String returnString = "Got it. I've added this task:\n  "
            + task.toString() + "\n"
            + "Now you have " + storage.size() + " tasks in the list.";
        return returnString;
    }

    // returns number of Tasks stored in the storage
    public int size() {
        return storage.size();
    }

    // Checks if the storage is empty
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    // Marks a task as done, and returns a confirmation message
    public String markDone(int ind) {
        if (ind < 0 || ind >= storage.size()){ 
            throw new IllegalArgumentException("☹ OOPS!!! Index entered is not valid. Please use 'list' and check for the appropriate index for task(s).");
        }
        storage.get(ind).markDone();

        return "Nice! I've marked this task as done:\n  " + storage.get(ind).toString();
    }

    // Gets a task from the storage
    public Task get(int ind) {
        if (ind < 0 || ind >= storage.size()){ 
            throw new IllegalArgumentException("☹ OOPS!!! Index entered is not valid. Please use 'list' and check for the appropriate index for task(s).");
        }
        return storage.get(ind);
    }

    public String delete(int ind) {
        if (ind < 0 || ind >= storage.size()){ 
            throw new IllegalArgumentException("☹ OOPS!!! Index entered is not valid. Please use 'list' and check for the appropriate index for task(s).");
        }
        String result = "Noted. I've removed this task:\n  " + storage.get(ind).toString() + "\n";
        storage.remove(ind);
        result += "Now you have " + storage.size() + " tasks in the list.";
        return result;
    }

    // Lists out all tasks from the storage in order of index
    @Override
    public String toString() {
        String result = "Here are the tasks in your list:";
        for (int i = 0; i < storage.size(); i++) {
            result += ("\n" + String.valueOf(i + 1) + "." + storage.get(i).toString());
        }
        return result;
    }

}
