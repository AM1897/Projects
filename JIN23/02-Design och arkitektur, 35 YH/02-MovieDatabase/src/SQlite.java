import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class SQlite {
    private Connection conn = null; // Connection to database
    private final String databaseName = "OMDBMovie Database"; // Name of database

    // Constructor for SQlite class - connects to database and creates table if it doesn't exist and deletes old movies
    public SQlite() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
            System.out.println("Connected! \nDatabase name is: " + databaseName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        createTable(); // Create table if it doesn't exist directly after connecting to database
        deleteOldMovies(); // Delete old movies from database
    }
    // Create table if it doesn't exist directly after connecting to database
    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS movies (\n"
                + "id integer PRIMARY KEY,\n"
                + "title varchar(50) UNIQUE,\n" // UNIQUE so that there can't be two movies with the same title
                + "year varchar(50),\n"
                + "genre varchar(50),\n"
                + "director varchar(50),\n"
                + "actors varchar(50),\n"
                + "date varchar(50)\n" + ");";
        try {
            conn.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // Delete old movies from database (older than current month)
    private void deleteOldMovies() {
        try {
            PreparedStatement pStatement = conn.prepareStatement("DELETE FROM movies WHERE date < ?");
            pStatement.setInt(1, LocalDate.now().getMonthValue());
            pStatement.executeUpdate();
            System.out.println("Old movies deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // Add movie to database from Movie object
    public void addMovieToDatabase(Movie movie) {
        // Add movie to database with current month as date
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        try {
            PreparedStatement pStatement = conn.prepareStatement("INSERT INTO movies (title, year, director, actors, genre, date) VALUES (?,?,?,?,?,?)");
            pStatement.setString(1, movie.getTitle());
            pStatement.setString(2, movie.getYear());
            pStatement.setString(3, movie.getActors());
            pStatement.setString(4, movie.getDirector());
            pStatement.setString(5, movie.getGenre());
            pStatement.setInt(6, month);

            int result = pStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Done!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // Search for movie in database and print out the result
    public boolean findMovieInDatabaseByTitle (String search) {
        try {
            PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM movies WHERE title LIKE ?");
            pStatement.setString(1, "%" + search + "%");
            ResultSet result = pStatement.executeQuery();

            if (result.next()) {
                System.out.println("Title: " + result.getString("title"));
                System.out.println("Year: " + result.getString("year"));
                System.out.println("Genre: " + result.getString("genre"));
                System.out.println("Director: " + result.getString("director"));
                System.out.println("Actors: " + result.getString("actors"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public void findMovieInDatabaseByActor(String search) {
        try {
            PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM movies WHERE actors LIKE ?");
            pStatement.setString(1, "%" + search + "%");
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                System.out.println("Title: " + result.getString("title"));
                System.out.println("Year: " + result.getString("year"));
                System.out.println("Genre: " + result.getString("genre"));
                System.out.println("Director: " + result.getString("director"));
                System.out.println("Actors: " + result.getString("actors"));
            }
        } catch (SQLException e) {
            System.out.println("No movies found");
            System.out.println(e.getMessage());
        }
    }
    public void findMovieInDatabaseByYear(String search) {
        try {
            PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM movies WHERE year LIKE ?");
            pStatement.setString(1, "%" + search + "%");
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                System.out.println("Title: " + result.getString("title"));
                System.out.println("Year: " + result.getString("year"));
                System.out.println("Genre: " + result.getString("genre"));
                System.out.println("Director: " + result.getString("director"));
                System.out.println("Actors: " + result.getString("actors"));
            }
        } catch (SQLException e) {
            System.out.println("No movies found");
            System.out.println(e.getMessage());
        }
    }
    public void findMovieInDatabaseByDirector(String search) {
        try {
            PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM movies WHERE director LIKE ?");
            pStatement.setString(1, "%" + search + "%");
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                System.out.println("Title: " + result.getString("title"));
                System.out.println("Year: " + result.getString("year"));
                System.out.println("Genre: " + result.getString("genre"));
                System.out.println("Director: " + result.getString("director"));
                System.out.println("Actors: " + result.getString("actors"));
            }
        } catch (SQLException e) {
            System.out.println("No movies found");
            System.out.println(e.getMessage());
        }
    }


    // test method to print out all movies in database - not used in program
    public void deleteAllMovies() {
        try {
            PreparedStatement pStatement = conn.prepareStatement("DELETE FROM movies");
            pStatement.executeUpdate();
            System.out.println("All movies deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}