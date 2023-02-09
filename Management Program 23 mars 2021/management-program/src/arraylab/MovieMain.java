package arraylab;// skapad av Karin och Arif.

import static arraylab.MovieManagement.*;

public class MovieMain {

    public static void main(String[] args) {
        loadMovie();
        while (true) {
            int choice = menu();
            switchChoice(choice);

        }
    }

    public static int menu() {
        System.out.println("**************");
        System.out.println("    MENU     ");
        System.out.println("**************");
        System.out.println("1. Add movie.");
        System.out.println("2. Remove movie.");
        System.out.println("3. Print all movies.");
        System.out.println("4. Print movie by name.");
        System.out.println("5. Update movie.");
        System.out.println("6. Number of movies.");
        System.out.println("7. Show movies by index.");
        System.out.println("0. Exit.");
        System.out.println("***************");
        System.out.print("\nMake a choice: ");

        int choice = sc.nextInt();
        sc.nextLine();
        return choice;

    }

    public static void loadMovie() {

        Movie m1 = new Movie("Kung fu Panda", 2008, "Comedy");
        Movie m2 = new Movie("BadBoy", 2001, "Triler");
        Movie m3 = new Movie("Die Hard", 2009, "Action");
        Movie m4 = new Movie("Transformer", 2018, "Sci-Fi");

        addMovie(m1);
        addMovie(m2);
        addMovie(m3);
        addMovie(m4);

    }

    private static void switchChoice(int choice) {

        switch (choice) {

            case 1:
                createMovie();
                System.out.println("**************");
                break;

            case 2:
                System.out.println("**************");
                printAllMovies();
                System.out.println("**************");
                System.out.print("\nEnter moive name from above list to remove: ");
                String name = sc.nextLine();

                removeMovieByName(name);
                System.out.println("\nMovies left on your library!");
                System.out.println("**************");
                printAllMovies();
                break;

            case 3:
                printAllMovies();
                break;

            case 4:
                System.out.print("Write movie name to print: ");
                System.out.println("**************");
                String name1 = sc.nextLine();
                printMovieByName(name1);
                break;

            case 5:
                System.out.println("\nYou have the following movies:");
                printAllMovies();
                System.out.print("\nChoose movie by name from above list:");
                String nameToUpdate = sc.nextLine();
                updateMovie(nameToUpdate);
                System.out.println("****************");
                System.out.println("Updated movielist!");
                printAllMovies();
                break;

            case 6:
                numberOfMovie();
                break;

            case 7:
                showMoviesByIndex();
            case 0:
                System.exit(0);
                break;

            default:
                System.out.println("\nWrong choice! Choose again.");

        }
    }

}
