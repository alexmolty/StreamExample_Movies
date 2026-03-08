package references.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class MoviesStream {
    public static void main(String[] args) {
        Movie[] movies = {
                // Группа 2022
                new Movie("The Batman", 2022, 7.8),
                new Movie("Top Gun: Maverick", 2022, 8.3),
                new Movie("Avatar: The Way of Water", 2022, 7.6),

                // Группа 2010
                new Movie("Inception", 2010, 8.3),
                new Movie("Shutter Island", 2010, 8.2),
                new Movie("The Social Network", 2010, 7.8),

                // Группа 2019
                new Movie("Parasite", 2019, 8.5),
                new Movie("The Irishman", 2019, 7.8),
                new Movie("Joker", 2019, 8.4),
        };

        // массив, отсортированный по убыванию по рейтингу (для удобства):
        Movie[] moviesSortedByRating = Stream.of(movies)
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .toArray(Movie[]::new);
        System.out.println("========Sorted by rating========");
        Stream.of(moviesSortedByRating).forEach(System.out::println);

        // массив, отсортированный по годам (для удобства):
        Movie[] moviesSortedByYear = Stream.of(movies)
                .sorted(Comparator.comparingInt(Movie::getYear))
                .toArray(Movie[]::new);

        System.out.println("========Sorted by year========");
        Stream.of(moviesSortedByYear).forEach(System.out::println);

        System.out.println("============================");
        System.out.println("1. Уникальные рейтинги фильмов:");
        uniqueRatingsOfMovies(moviesSortedByRating);
        System.out.println("2. Только 2 первых уникальных года фильмов:");
        first2UniqueYearsOfMovies(moviesSortedByYear);
        System.out.println("3. Второй уникальный год фильмов:");
        secondUniqueYearOfMovies(moviesSortedByYear);
        System.out.println("4. Предпоследний элемент массива:");
        penultMovie(movies);

    }


    private static void uniqueRatingsOfMovies(Movie[] movies) {
        Stream.of(movies)
                .map(Movie::getRating)
                .distinct()
                .forEach(System.out::println);
    }

    private static void first2UniqueYearsOfMovies(Movie[] movies) {
        Stream.of(movies)
                .map(Movie::getYear)
                .distinct()
                .limit(2)
                .forEach(System.out::println);
    }

    private static void secondUniqueYearOfMovies(Movie[] movies) {
        Stream.of(movies)
                .map(Movie::getYear)
                .distinct()
                .skip(1)
                .limit(1)
                .forEach(System.out::println);
    }

    private static void penultMovie(Movie[] movies) {
        Stream.of(movies)
                .skip(Math.max(0, movies.length - 2))
                .limit(1)
                .forEach(System.out::println);
    }
}
