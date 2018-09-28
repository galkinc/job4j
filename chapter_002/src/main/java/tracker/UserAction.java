package tracker;

public interface UserAction {

    String key();

    String menu();

    void execute(Input input, Tracker tracker);

}
