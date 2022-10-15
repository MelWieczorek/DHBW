package KinoProjectTesting;

public class MovieController {

    public static void main(String[] args) {
        MovieSQL movieSql = new MovieSQL();
        System.out.println(movieSql.getMovieData());
    }
}
