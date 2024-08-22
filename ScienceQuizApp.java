import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScienceQuizApp {  // Changed class name here
    private List<Question> questions;
    private Scanner scanner;

    public ScienceQuizApp() {  // Updated constructor name
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        System.out.println("Welcome to the General Science Quiz!");
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestion());

            // Display options
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            int userChoice = getUserChoice(options.size());

            // Check if the selected option is correct
            if (question.isCorrect(userChoice)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + question.getCorrectAnswer());
            }
        }

        System.out.println("Your final score is " + score + "/" + questions.size());
    }

    private int getUserChoice(int numOptions) {
        int choice = -1;
        while (true) {
            System.out.print("Enter your choice (1-" + numOptions + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= numOptions) {
                    scanner.nextLine(); // consume newline
                    break;
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and " + numOptions + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        return choice;
    }

    public static void main(String[] args) {
        ScienceQuizApp quiz = new ScienceQuizApp();  // Updated object instantiation

        // Add 15 general science questions with 4 options each
        quiz.addQuestion(new Question("What is the chemical symbol for water?", List.of("H2O", "O2", "CO2", "H2"), 1));
        quiz.addQuestion(new Question("Which planet is known as the Red Planet?", List.of("Earth", "Mars", "Jupiter", "Venus"), 2));
        quiz.addQuestion(new Question("What is the powerhouse of the cell?", List.of("Nucleus", "Ribosome", "Mitochondria", "Chloroplast"), 3));
        quiz.addQuestion(new Question("What is the hardest natural substance on Earth?", List.of("Gold", "Iron", "Diamond", "Platinum"), 3));
        quiz.addQuestion(new Question("How many bones are in the human body?", List.of("206", "208", "210", "212"), 1));
        quiz.addQuestion(new Question("What is the speed of light?", List.of("300,000 km/s", "150,000 km/s", "120,000 km/s", "1,000,000 km/s"), 1));
        quiz.addQuestion(new Question("What gas do plants absorb from the atmosphere?", List.of("Oxygen", "Nitrogen", "Carbon Dioxide", "Methane"), 3));
        quiz.addQuestion(new Question("What is the boiling point of water?", List.of("90°C", "100°C", "110°C", "120°C"), 2));
        quiz.addQuestion(new Question("Who proposed the theory of relativity?", List.of("Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla"), 2));
        quiz.addQuestion(new Question("What is the largest planet in our solar system?", List.of("Earth", "Saturn", "Jupiter", "Neptune"), 3));
        quiz.addQuestion(new Question("What is the main gas found in the air we breathe?", List.of("Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"), 3));
        quiz.addQuestion(new Question("Which vitamin is known as the sunshine vitamin?", List.of("Vitamin A", "Vitamin B", "Vitamin C", "Vitamin D"), 4));
        quiz.addQuestion(new Question("What is the common name for sodium chloride?", List.of("Sugar", "Salt", "Baking Soda", "Vinegar"), 2));
        quiz.addQuestion(new Question("What organ in the human body is primarily responsible for detoxification?", List.of("Heart", "Lungs", "Liver", "Kidneys"), 3));
        quiz.addQuestion(new Question("Which element is necessary for respiration in most living organisms?", List.of("Oxygen", "Nitrogen", "Carbon", "Helium"), 1));

        quiz.startQuiz();
    }
}

class Question {
    private String question;
    private List<String> options;
    private int correctAnswerIndex;

    public Question(String question, List<String> options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;  // This should be the index of the correct option (1-based)
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;  // Added getter for correctAnswerIndex
    }

    public String getCorrectAnswer() {
        return options.get(correctAnswerIndex - 1);  // Convert 1-based index to 0-based
    }

    public boolean isCorrect(int userChoice) {
        return userChoice == correctAnswerIndex;
    }
}