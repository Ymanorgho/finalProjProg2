import java.util.Scanner;

//



public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Choice 1");
                System.out.println("2. Choice 2");
                System.out.println("3. Choice 3");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                String paragraph;

                switch (choice) {
                    case 1:
                        paragraph = ParagraphLoader.getParagraph("choice1");
                        //dito cinonsider yung paragraphLoader na file as Class, tapos yung .getParagraph na method basically
                        //since pareho lang location nila di na natin kelangan magreference ng specific filepath.
                        //basically if ever kukuha ka dun sa paragraphs.properties, which in this case ay yung database natin,
                        //gagamitin mo lang na format ay yung as above.
                        //Ginawa ko nalang na properties imbis na json dahil static variables
                        //pero if ever maggagawa tayo score system json yata kelangan natin gamitin para dun maiistore yung scores
                        //ng user

                        break;
                    case 2:
                        paragraph = ParagraphLoader.getParagraph("choice2");
                        break;
                    case 3:
                        paragraph = ParagraphLoader.getParagraph("choice3");
                        break;
                    case 4:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        paragraph = "Invalid choice. Please try again.";
                }

                System.out.println("\n" + paragraph);
            }
        }
    }
}