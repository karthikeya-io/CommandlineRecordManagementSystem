package Classes;

public class Movie extends Anime {
    private int AnimeID;
    private int MovieID;
    private String MovieName;
    private String ReleaseDate;
    private String Director;
    private int Duration;
    private double MovieRating;

    public Movie() {
    }

    public Movie(int aID, int mID, String mName, String ReleaseDate, String Dir, int duration, double mRating) {
        this.AnimeID = aID;
        this.MovieID = mID;
        this.MovieName = mName;
        this.ReleaseDate = ReleaseDate;
        this.Director = Dir;
        this.Duration = duration;
        this.MovieRating = mRating;
    }

    public Movie(String Line) {
        String[] values = Line.split(",");
        this.AnimeID = Integer.valueOf(values[0]);
        this.MovieID = Integer.valueOf(values[1]);
        this.MovieName = values[2];
        this.ReleaseDate = values[3];
        this.Director = values[4];
        this.Duration = Integer.valueOf(values[5]);
        this.MovieRating = Double.valueOf(values[6]);
    }

    public int getAnimeID() {
        return this.AnimeID;
    }

    public int getMovieID() {
        return this.MovieID;
    }

    public String getMovieName() {
        return this.MovieName;
    }

    public String getDirector() {
        return this.Director;
    }

    public int getDuration() {
        return this.Duration;
    }

    public String getReleasedate() {
        return this.ReleaseDate;
    }

    public double getMovieRating() {
        return this.MovieRating;
    }

    @Override
    public String toString() {
        return String.format("%10s%10s%50s%20s%20s%5s%5s", AnimeID, MovieID, MovieName, ReleaseDate, Director, Duration,
                MovieRating);
    }
}
