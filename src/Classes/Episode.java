package Classes;

public class Episode extends Anime {
    private int AnimeID;
    private int EpisodeID;
    private String EpisodeName;

    public enum Type {
        CANON, FILLER, MIXED
    }

    private Type EpisodeType;
    private String AirDate;
    private double EpisodeRating;

    public Episode() {
    }

    public Episode(int aID, int eID, String eName, Type typeArg, String AirDate, double eRating) {
        this.AnimeID = aID;
        this.EpisodeID = eID;
        this.EpisodeName = eName;
        this.EpisodeType = typeArg;
        this.AirDate = AirDate;
        this.EpisodeRating = eRating;
    }

    public Episode(String Line) {
        String[] values = Line.split(",");
        this.AnimeID = Integer.valueOf(values[0]);
        this.EpisodeID = Integer.valueOf(values[1]);
        this.EpisodeName = values[2];
        this.EpisodeType = Type.valueOf(values[3]);
        this.AirDate = values[4];
        this.EpisodeRating = Double.valueOf(values[5]);
    }

    public int getAnimeID() {
        return this.AnimeID;
    }

    public int getEpisodeID() {
        return this.EpisodeID;
    }

    public String getEpisodeName() {
        return this.EpisodeName;
    }

    public Type getEpisodeType() {
        return this.EpisodeType;
    }

    public String getAirdate() {
        return this.AirDate;
    }

    public double getEpisodeRating() {
        return this.EpisodeRating;
    }

    @Override
    public String toString() {
        return String.format("%10s%10s%55s%10s%20s%5s", AnimeID, EpisodeID, EpisodeName, EpisodeType, AirDate,
                EpisodeRating);
    }
}
