public class MovieBuilder {

    private String title = "";
    private String year = "";
    private String actors = "";
    private String director = "";
    private String Genre = "";


    public MovieBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder setYear(String year) {
        this.year = year;
        return this;
    }

    public MovieBuilder setActors(String actors) {
        this.actors = actors;
        return this;
    }

    public MovieBuilder setDirector(String director) {
        this.director = director;
        return this;
    }

    public MovieBuilder setGenre(String Genre) {
        this.Genre = Genre;
        return this;
    }

    public Movie build() {
        return new Movie(title, year, actors, director, Genre);
    }
}
