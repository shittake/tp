package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
public class FilterCommand extends Command {
    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_SUCCESS = "Filter students accordingly.";
    public static final int fullScore = 100;

    public static String group;
    public static String metric;
    public static int threshold;

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters all address book students.\n "
            + "Parameters: The group of students you wish to sort (either all, lab, tutorial or consultation), "
            + "the metric to be sorted (performance only for now), "
            + "and the desired threshold value (0 to 100)\n"
            + "For example, 'filter all performance 40' is a command you can type";


    public FilterCommand(String group, String metric, int threshold) {
        this.group = group;
        this.metric = metric;
        this.threshold = threshold;
    }
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        /*
        switch (this.group) {
        case "all":
            model.updateSortAllPersonList(this.metric, this.increasingOrder);
            break;
        case "lab":
            model.updateSortLabPersonList(this.metric, this.increasingOrder);
            break;
        case "tutorial":
            model.updateSortTutorialPersonList(this.metric, this.increasingOrder);
            break;
        case "consultation":
            model.updateSortConsultationPersonList(this.metric, this.increasingOrder);
            break;
        }
         */
        model.updateFilteredPersonList((person) ->
                person.getPerformance().calculateUrgency() >= fullScore - this.threshold);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}