public class Movie {

    private String title;
    private String year;
    private String actors;
    private String director;
    private String Genre;

    //constructor for the movie object with all the variables
    public Movie(String title, String year, String actors, String director, String Genre) {
        this.title = title;
        this.year = year;
        this.actors = actors;
        this.director = director;
        this.Genre = Genre;
    }

    public Movie() {

    }

    public void printMovie() {
        System.out.println("Title: " + title);
        System.out.println("Year: " + year);
        System.out.println("Actors: " + actors);
        System.out.println("Director: " + director);
        System.out.println("Genre: " + Genre);
    }

    //getters and setters for the movie object
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void SetGenre(String Genre) {
        this.Genre = Genre;

    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String toString() {
        return "Movie{" + "title='" + title + '\'' + ", year='" + year + '\'' + ", actors='" + actors + '\'' + ", director='" + director + '\'' + ", Genre='" + Genre + '\'' + '}';
    }
}


