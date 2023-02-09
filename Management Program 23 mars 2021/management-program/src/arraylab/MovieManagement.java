package arraylab;

import java.util.*;

public class MovieManagement {

    static Scanner sc = new Scanner(System.in);
    public static Movie[] movies = new Movie[10];
    static int counter = 0;

    public static void addMovie(Movie m) {
        if (counter == movies.length) {
            Movie[] temp = new Movie[movies.length * 2];
            for (int i = 0; i < movies.length; i++) {
                temp[i] = movies[i];
            }
            movies = temp;
            movies[counter] = m;
        } else {
            movies[counter] = m;
            counter++;
        }

    }

    public static void createMovie() {
        System.out.println("**************");
        System.out.println("These are the movies you have in your library: ");
        printAllMovies();

        System.out.println("**************");
        System.out.print("Add name: ");
        String name = sc.nextLine();

        System.out.print("Add year: ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("Add genre: ");
        String genre = sc.nextLine();

        Movie m = new Movie(name, year, genre);
        addMovie(m);
        System.out.println("You have succesfully added this movie to your library: " + m);
    }

    public static void numberOfMovie() {
        System.out.println("Total number of movies: " + counter);
    }

    public static void printAllMovies() {
        for (int i = 0; i < counter; i++) {
            System.out.println(movies[i]);

        }
    }

    public static void printMovieByName(String name) {
        Movie m = findMovieByName(name);
        if (m != null) {
            System.out.println("This is your movie:: " + m);
        } else {
            System.out.println("No such name!");
        }

    }

    public static Movie findMovieByName(String name) {

        for (Movie film : movies) {
            if (film.getName().equalsIgnoreCase(name)) {
                return film;
            }

        }
        return null;
    }

    public static Movie removeMovieByName(String name) {
        findMovieByName(name);
        for (int i = 0; i < counter; i++) {
            if (movies[i].getName().equalsIgnoreCase(name)) {

                movies[i] = movies[counter - 1];
                movies[counter - 1] = null;
                counter--;
            }

        }
        return null;
    }

    public static void updateMovie(String name) {

        Movie m = findMovieByName(name);

        System.out.println("What do you want to update? Choose number from below.");
        System.out.println("1. Name");
        System.out.println("2. Year");
        System.out.println("3. Genre");
        System.out.println("4. All");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                updateMovieName(m);
                System.out.println("You changed the movie name to: " + m.getName());
                break;

            case 2:
                updateMovieYear(m);
                System.out.println("You changed the movie year to: " + m.getYear());
                break;

            case 3:
                updateMovieGenre(m);
                System.out.println("You changed the movie year to: " + m.getGenre());
                break;

            case 4:
                updateMovieName(m);
                System.out.println("You changed the movie name to: " + m.getName());
                updateMovieYear(m);
                System.out.println("You changed the movie year to: " + m.getYear());
                updateMovieGenre(m);
                System.out.println("You changed the movie year to: " + m.getGenre());
                break;

            default:
                System.out.println("Wrong choice");
        }
    }

    public static void updateMovieName(Movie m) {
        System.out.println("Write new movie name: ");
        String newName = sc.nextLine();
        m.setName(newName);
    }

    public static void updateMovieYear(Movie m) {
        System.out.println("Write new year");
        int newYear = sc.nextInt();
        sc.nextLine();
        m.setYear(newYear);
    }

    public static void updateMovieGenre(Movie m) {
        System.out.println("Write new genre: ");
        String newGenere = sc.nextLine();
        m.setGenre(newGenere);

    }

    public static void showMoviesByIndex() {
        for (int i = 0; i < counter; i++) {
            System.out.println("Movie at position " + i + " is: " + movies[i]);

        }
    }

}
