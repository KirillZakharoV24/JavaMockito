import org.example.MovieManager;
import org.example.MovieRep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    MovieManager manager1 = new MovieManager(10);
    MovieManager manager = new MovieManager();
    MovieRep movie1 = new MovieRep(1,"movie1", "genre1");
    MovieRep movie2 = new MovieRep(2,"movie2", "genre2");
    MovieRep movie3 = new MovieRep(3,"movie3", "genre3");
    MovieRep movie4 = new MovieRep(4,"movie4", "genre4");
    MovieRep movie5 = new MovieRep(5,"movie5", "genre1");
    MovieRep movie6 = new MovieRep(6,"movie6", "genre2");
    MovieRep movie7 = new MovieRep(7,"movie7", "genre3");
    MovieRep movie8 = new MovieRep(8,"movie8", "genre4");
    MovieRep movie9 = new MovieRep(9,"movie9", "genre1");
    MovieRep movie10 = new MovieRep(10,"movie10", "genre2");

    @BeforeEach
    public void setup() {
        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);
        manager.save(movie8);
        manager.save(movie9);
        manager.save(movie10);

    }

    @Test

    public void testAddMovies() {
        MovieRep movie11 = new MovieRep(11,"movie11", "genre3");
        manager.save(movie11);

        MovieRep[] expected = {movie1,movie2,movie3,movie4,movie5,movie6,movie7,movie8,movie9,movie10,movie11};
        MovieRep[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void testReverseOrder() {
        MovieRep[] expected = {movie10,movie9,movie8,movie7,movie6,movie5,movie4,movie3,movie2,movie1};
        MovieRep[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected,actual);
    }


    @Test

    public void testLimit() {

        int expected = 10;
        int actual = manager1.getLimit();

        Assertions.assertEquals(expected,actual);
    }

    @Test

    public void shouldReturnLastMoviesWithLimit () {
        MovieManager manager = new MovieManager(5);
        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);
        manager.save(movie8);
        manager.save(movie9);
        manager.save(movie10);

        MovieRep[] expected = {movie10, movie9, movie8, movie7, movie6};
        MovieRep[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldGetMovieId() {
        MovieRep movie = new MovieRep(1,"movie1", "genre1");
        int expected = 1;
        int actual = movie.getMovieId();

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldSetMovieId() {
        MovieRep movie = new MovieRep(1,"movie1", "genre1");
        movie.setMovieId(1);
        int movieId = movie.getMovieId();

        Assertions.assertEquals(1, movieId);
    }

    @Test
    public void shouldGetMovieName() {
        MovieRep movie = new MovieRep(1,"movie1", "genre1");
        String expected = "movie1";
        String actual = movie.getMovieName();

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldSetMovieName() {
        MovieRep movie = new MovieRep(1,"movie1", "genre1");
        movie.setMovieName("movie2");
        String expected = "movie2";
        String actual = movie.getMovieName();
        Assertions.assertEquals(expected,actual);
    }

    @Test

    public void shouldGetGenre() {
        MovieRep movie = new MovieRep(1, "movie1", "genre1");
        movie.getGenre();
        String expected = "genre1";
        String actual = movie.getGenre();

        Assertions.assertEquals(expected,actual);
    }

    @Test

    public void shouldSetGenre() {
        MovieRep movie = new MovieRep(1,"movie1", "genre1");
        movie.setGenre("genre2");
        String expected = "genre2";
        String actual = movie.getGenre();
        Assertions.assertEquals(expected,actual);

    }




}
