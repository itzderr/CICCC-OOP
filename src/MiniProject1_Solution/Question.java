package MiniProject1_Solution;

    /**
     * The {@code Question} class represents each question for the game.
     * All questions for this game are implemented as instances of this class.
     *
     * Here are some examples of how questions can be used:
     * <blockquote><pre>
     *     Question q = new Question("Vancouver");
     *     System.out.println(q.getHint());
     *     System.out.println(q.updateHint("a"));
     * </pre>
     * </blockquote>
     *
     * @author Derrick Park
     * @version 1.0
     */
public class Question {

        //----- data field--------
        private String name;        // store the question
        private String hint;        // represented as underscores (_)

        // -------constructor------
        // Initialize a new object (a question)
        // 'name' represents a question
        public Question(String name){
            this.name = name.toLowerCase();
            this.hint = initHint();
        }

        // ------method field------

        // returns updated hint by replacing all letter char in name
        // letter: letter to update in hint (user input if correct)
        // check length (to be >1)
        public String updateHint (String letter) throws IllegalArgumentException{
            if(letter.length() != 1){
                throw new IllegalArgumentException("Invalid Argument! You need to enter one letter! ");
            }
            int index = name.indexOf(letter);
            while (index != -1){
                hint = hint.substring(0, index) + letter + hint.substring(index + 1);
                index = name.indexOf(letter, index + 1);
            }
            return hint.substring(0,1).toUpperCase() + hint.substring(1);
        }

        private String initHint(){
            return name.replaceAll("\\w", "_");
        }

        // check if hint and name are equal
        public boolean isCorrect(){
            return name.equals(hint);
        }

        //---- getter methods------
        // return hint
        public String getHint(){
            return hint;
        }

        // return name
        public String getName(){
            return name;
        }
}
