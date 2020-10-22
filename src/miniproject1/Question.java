package miniproject1;

/**
 * The {@code Question} class represents each question for the game.
 * All questions for this game are implemented as instances of this class.
 *
 * Here are some examples of how questions can be used:
 * <blockquote><pre>
 *     Question q = new Question("Vancouver");
 *     System.out.println(q.getHint());
 *     System.out.println(q.updateHint("a"));
 * </pre></blockquote>
 *
 * @author Derrick Park
 * @version 1.0
 */
public class Question {

    /**
     * The name value is used for storing the question as {@code String}.
     */
    private String name;

    /**
     * The hint {@code String} represented as underscores (_).
     * If {@code name} is {@code "Vancouver"} the {@code hint} will be represented as
     * {@code "_________"}
     */
    private String hint;

    /**
     * Initializes a newly created {@code Question} object.
     *
     * @param name A {@code String} represents a question
     */
    public Question(String name) {
        this.name = name.toLowerCase();
        this.hint = initHint();
    }

    /**
     * Returns the updated {@code hint} by replacing all {@code letter} characters in {@code name}.
     *
     * @param letter the letter to update in {@code hint}
     *
     * @return the updated {@code hint}
     * @throws IllegalArgumentException if the {@code letter} length is not 1
     */
    public String updateHint(String letter) throws IllegalArgumentException {
        if (letter.length() != 1) {
            throw new IllegalArgumentException("Invalid Argument! You need to enter one letter!");
        }
        int index = name.indexOf(letter);
        while (index != -1) {
            hint = hint.substring(0, index) + letter + hint.substring(index + 1);
            index = name.indexOf(letter, index + 1);
        }
        return hint.substring(0, 1).toUpperCase() + hint.substring(1);
    }

    private String initHint() {
        return name.replaceAll("\\w", "_");
    }

    /**
     * Returns {@code true} if {@code hint} and {@code name} are equal. Otherwise, {@code false}.
     * @return {@code true} iff {@code hint} and {@code name} are equal
     */
    public boolean isCorrect() {
        return name.equals(hint);
    }

    /**
     * Returns the {@code hint} field.
     * @return the {@code hint}
     */
    public String getHint() {
        return hint;
    }

    /**
     * Returns the {@code name} field.
     * @return the {@code name}
     */
    public String getName() {
        return name;
    }
}
