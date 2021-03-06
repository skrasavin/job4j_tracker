package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * startUI
 */
public class StartUI {
    private final Output out;

    /**
     * StartUI
     * @param out test
     */
    public StartUI(Output out) {
        this.out = out;
    }

    /**
     * Init
     * @param input test
     * @param tracker test
     * @param actions test
     */
    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    /**
     * main
     * @param args test
     */
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] userAct = new UserAction[]{
                new CreateAction(output),
                new ShowAllAction(output),
                new EditAction(),
                new DeleteAction(),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction(output)};
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(userAct));

        new StartUI(output).init(input, tracker, actions);

        //System.out.println(item.getCreated().
        // format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));
        //System.out.println(item.toString());

    }
}