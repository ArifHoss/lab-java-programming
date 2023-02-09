package arrayListLab;// Skapad av Karin och Arif

import static arrayListLab.MovieManagement.*;

public class MoviesMain {

    public static void main(String[] args) {

        loadMovie();

        while (true) {
            int choice = menu();
            switchChoice(choice);
        }

    }

    private static int menu() {
        System.out.println("**************");
        System.out.println("    MENU     ");
        System.out.println("**************");
        System.out.println("1. Add movie");
        System.out.println("2. Revmove movies");
        System.out.println("3. Print all movies");
        System.out.println("4. Print movie by name");
        System.out.println("5. Update movie");
        System.out.println("6. Find latest movie");
        System.out.println("7. Find oldest movie");
        System.out.println("o. Exit.");
        System.out.println("***************");
        System.out.print("\n Make a choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private static void loadMovie() {

        Movie m1 = new Movie("Kung fu Panda", 2008, "Comedy");
        Movie m2 = new Movie("Ocean's Eleven", 2001, "Crime");
        Movie m3 = new Movie("Intersteller", 2014, "Sci-Fi");
        Movie m4 = new Movie("Manhunt", 2017, "Action");

        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        movies.add(m4);

    }

    private static void switchChoice(int choice) {

        switch (choice) {
            case 1:
                addMovie();
                printAllMovies();
                break;

            case 2:
                printAllMovies();
                System.out.println("Write movie name to remove!");
                String rName = sc.nextLine();
                removeMovieByName2(rName);
                printAllMovies();
                break;

            case 3:
                printAllMovies();
                break;

            case 4:
                System.out.print("Write movie name: ");
                String name = sc.nextLine();
                printMovieByName(name);
                break;

            case 5:
                System.out.print("Name: ");
                String nameToUpdate = sc.nextLine();
                updateMovie(nameToUpdate);
                printAllMovies();
                break;

            case 6:
                findLatestMovie();
                break;

            case 7:
                findOldestMovie();
                break;

            case 0:
                System.exit(choice);
                break;

            default:
                System.out.println("Invalid choice! Choose 1 to 0!");
        }
    }
}
