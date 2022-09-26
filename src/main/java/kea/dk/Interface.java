package kea.dk;
import java.util.Scanner;

public class Interface {

    Scanner sc = new Scanner(System.in);

    public void startUp(){
        System.out.println("Velkommen til *inset name* adventure!");
        brugerValg();
    }

    public void brugerValg(){
        String brugerValg = sc.nextLine();

        switch (brugerValg.trim().toLowerCase()){
            case "walk north":
            case "go north":
            case "north":
            case "n":
                System.out.println("going north");
                break;
            default:
                System.out.println("prøv noget andet");
                break;
        }
    }
}
