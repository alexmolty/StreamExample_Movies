package references.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MoviesAppl {
    static void main() {
        Movie[] movies = {
                // Группа 2022
                new Movie("The Batman", 2022, 7.8),
                new Movie("Top Gun: Maverick", 2022, 8.3),
                new Movie("Avatar: The Way of Water", 2022, 7.6),
                new Movie("Everything Everywhere All at Once", 2022, 7.8),

                // Группа 2010
                new Movie("Inception", 2010, 8.8),
                new Movie("Shutter Island", 2010, 8.2),
                new Movie("The Social Network", 2010, 7.8),
                new Movie("Toy Story 3", 2010, 8.2),

                // Группа 2019
                new Movie("Parasite", 2019, 8.5),
                new Movie("The Irishman", 2019, 7.8),
                new Movie("Joker", 2019, 8.4),
                new Movie("1917", 2019, 8.2)
        };


        displayMoviesTitle(movies, 2019, 8.0);
        displayMoviesTitleStream(movies, 2019, 8.0);
    }

    private static void displayMoviesTitle(Movie[] movies, int year, double rating) {
        ArrayList<Movie> list = new ArrayList<>();
        for (Movie m : movies) {
            if (m.year == year && m.rating >= rating) {
                list.add(m);
            }
        }
        list.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                int res = Double.compare(o2.rating, o1.rating);
                return res == 0 ? o1.title.compareTo(o2.title) : res;
            }
        });
        for (Movie m : list) {
            System.out.println(m.title);
        }
    }

    private static void displayMoviesTitleStream(Movie[] movies, int year, double rating) {
        Arrays.stream(movies)
                .filter(m -> m.year == year && m.rating >= rating)
                .sorted(Comparator.comparingDouble((Movie m) -> m.rating)
                        .reversed()
                        .thenComparingInt(m -> m.year))
                .map(m -> m.title)
                .forEach(System.out::println);
    }
}
