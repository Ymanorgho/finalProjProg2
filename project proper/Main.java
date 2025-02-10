import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        UserSession userSession = new UserSession();
        TopicManager topicManager = new TopicManager();
        QuizManager quizManager = new QuizManager();

        while (true) {
            System.out.println("\nWelcome to IR4.0 Explorers");
            System.out.println("1. Learn about IR 4.0 Topics");
            System.out.println("2. Take a Quiz");
            System.out.println("3. View Score");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    topicManager.displayTopics(scanner);
                    break;
                case 2:
                    quizManager.startQuiz(scanner, userSession);
                    break;
                case 3:
                    System.out.println("Your current score: " + userSession.getScore() + " points");
                    break;
                case 4:
                    System.out.println("Thank you for exploring IR 4.0!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class TopicManager {
    private final Map<Integer, String> topics = new HashMap<>();

    public TopicManager() {
        topics.put(1, "Internet of Things (IoT): Connecting devices to the internet.");
        topics.put(2, "Cloud Computing: Storing and processing data remotely.");
        topics.put(3, "Big Data: Analyzing large datasets for insights.");
        topics.put(4, "Artificial Intelligence & Machine Learning: Machines learning and making decisions.");
        topics.put(5, "Automation & Robotics: Machines performing tasks with minimal human intervention.");
    }

    public void displayTopics(Scanner scanner) {
        System.out.println("\nChoose a topic to learn about:");
        for (Map.Entry<Integer, String> entry : topics.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().split(":")[0]);
        }
        System.out.print("Enter topic number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println(topics.getOrDefault(choice, "Invalid choice."));
    }
}

class QuizManager {
    private final List<Question> questions = new ArrayList<>();

    public QuizManager() {
        questions.add(new Question("What does IoT stand for?", "A) Internet of Things", "B) Internet of Technology", "C) Intelligent Operating Technology", 'A'));
        questions.add(new Question("Which technology is used for storing and processing data remotely?", "A) AI", "B) Cloud Computing", "C) Big Data", 'B'));
        questions.add(new Question("What is the main purpose of Big Data?", "A) Analyzing large datasets", "B) Controlling robots", "C) Internet browsing", 'A'));
        questions.add(new Question("Which field enables machines to learn and make decisions?", "A) Robotics", "B) AI & Machine Learning", "C) IoT", 'B'));
        questions.add(new Question("What is the role of Automation & Robotics?", "A) Manual task execution", "B) Minimizing human intervention", "C) Data analysis", 'B'));
    }

    public void startQuiz(Scanner scanner, UserSession userSession) {
        System.out.println("\nStarting IR 4.0 Quiz!");
        int score = 0;
        
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            System.out.println(question.getOptionA());
            System.out.println(question.getOptionB());
            System.out.println(question.getOptionC());
            System.out.print("Enter your answer (A/B/C): ");
            char answer = scanner.next().toUpperCase().charAt(0);
            
            if (answer == question.getCorrectAnswer()) {
                System.out.println("Correct!");
                score += 10;
            } else {
                System.out.println("Wrong answer. Correct answer is: " + question.getCorrectAnswer());
            }
        }
        
        userSession.updateScore(score);
        System.out.println("Quiz completed! You earned " + score + " points.");
    }
}

class UserSession {
    private int score;

    public void updateScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }
}

class Question {
    private final String question;
    private final String optionA;
    private final String optionB;
    private final String optionC;
    private final char correctAnswer;

    public Question(String question, String optionA, String optionB, String optionC, char correctAnswer) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() { return question; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public char getCorrectAnswer() { return correctAnswer; }
}
