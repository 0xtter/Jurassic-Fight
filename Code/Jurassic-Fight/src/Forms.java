import java.util.Scanner;  // Import the Scanner class

public class Forms {

    public static String promptEnterKey(){
        System.out.println("Appuyer sur \"ENTER\" pour continuer... (ou 'finir' pour terminer la simulation)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
     }


    public static Integer askForInteger(Integer min, Integer max, String prompt) {
        
        System.out.println(prompt);

        while (true) {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            String input = myObj.nextLine();  // Read user input
            try {
                Integer n = Integer.parseInt(input);
                if (min <= n && n <= max) {
                    myObj.close();
                    return n;
                } else {
                    System.out.println(String.format("Veuillez saisir un entier entre %d et %d", min, max));
                }
            } catch (Exception e) {
                if (input.equals("quit")) {
                    System.exit(0);
                }
                System.out.println("Veuillez saisir un entier");
            }
        }
    }
}
