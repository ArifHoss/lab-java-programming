package arrayListLab;

import java.util.*;

public class MovieManagement {

    static ArrayList<Movie> movies = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addMovie() {
        System.out.println("These are the movies you have on your list!");
        System.out.println("            *****************              ");
        printAllMovies();
        System.out.print("Add name: ");
        String name = sc.nextLine();

        System.out.print("Add year: ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("Add genre: ");
        String genre = sc.nextLine();

        Movie m = new Movie(name, year, genre);
        movies.add(m);
    }

    public static void printAllMovies() {

        for (Movie film : movies) {
            System.out.println(film);

        }
        System.out.println("            *****************              ");
    }

    public static void printMovieByName(String name) {
        Movie m = findMovieByName(name);
        if (m != null) {
            System.out.println(m);
        } else {
            System.out.println("No such name!");
        }

    }

    public static Movie findMovieByYear(int year) {

        return null;
    }

    public static Movie findMovieByName(String name) {

        for (Movie film : movies) {
            if (film.getName().equalsIgnoreCase(name)) {
                return film;
            }

        }

        return null;
    }

    public static void removeMovieByName2(String name) {
        Movie m = findMovieByName(name);
        if (m != null) {
            movies.remove(m);
            System.out.println("You just remove movie named: " + m);
        } else {
            System.out.println("No such name!");
        }
    }

    public static void removeMovieByName(String name) {

        for (Movie film : movies) {
            if (film.getName().equalsIgnoreCase(name)) {
                System.out.println("You just removed movie named: " + film);
                movies.remove(film);

            } else {
                System.out.println("No such namee");
            }
        }
    }

    public static void updateMovie(String name) {

        Movie m = findMovieByName(name);

        System.out.println("What do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Year");
        System.out.println("3. Genre");
        System.out.println("4. All");
        System.out.print("Make a choice:");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                updateMovieByName(m);
                break;
            case 2:
                updateMovieByYear(m);
                break;
            case 3:
                updateMovieByGenere(m);
                break;
            case 4:
                updateMovieByName(m);
                updateMovieByYear(m);
                updateMovieByGenere(m);
                break;
            default:
                System.out.println("Wrong choice");
        }
    }

    public static void updateMovieByName(Movie m) {
        System.out.print("Write new name:");
        String newName = sc.nextLine();
        m.setName(newName);
    }

    public static void updateMovieByYear(Movie m) {
        System.out.print("Write new year:");
        int newYear = sc.nextInt();
        sc.nextLine();
        m.setYear(newYear);
    }

    public static void updateMovieByGenere(Movie m) {

        System.out.print("Write new genre: ");
        String newGenere = sc.nextLine();
        m.setGenre(newGenere);
    }

    public static void findLatestMovie() {
        int maxYear = 0;
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(maxYear).getYear() < movies.get(i).getYear()) {
                maxYear = i;
            }

        }
        System.out.println(movies.get(maxYear));

    }

    public static void findOldestMovie() {
        int minYear = 0;
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(minYear).getYear() > movies.get(i).getYear()) {
                minYear = i;
            }

        }
        System.out.println(movies.get(minYear));
    }

}
