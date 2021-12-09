package Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Anime;
import Classes.Episode;
import Classes.Movie;
import Interfaces.FILTERable;

public class TestFILTER implements FILTERable<Anime> {
    private static Connection con;

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        TestFILTER.con = con;
    }

    public void sortByRatingHighToLow(Anime a) {
        List<Anime> aList = new ArrayList<Anime>();

        final String SQL = "select * from anime order by rating desc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                a = new Anime(rs.getInt("id"), rs.getString("name"), rs.getString("language"),
                        rs.getString("genre"), rs.getInt("year"), rs.getString("type"), rs.getDouble("rating"),
                        rs.getString("productioncompany"));
                aList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Anime anime : aList) {
            System.out.println(anime);
        }
    }

    public void sortByratingHighToLow(Episode e) {
        List<Episode> eList = new ArrayList<Episode>();

        final String SQL = "select * from Episodes order by EpisodeRating desc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Episode ep = new Episode(rs.getInt("AnimeID"), rs.getInt("EpisodeID"), rs.getString("EpisodeName"),
                        Episode.Type.valueOf(rs.getString("EpisodeType")), rs.getDate("AirDate").toString(),
                        rs.getDouble("EpisodeRating"));
                eList.add(ep);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        for (Episode episode : eList) {
            System.out.println(episode);
        }
    }

    public void sortByratingHighToLow(Movie m) {
        List<Movie> mList = new ArrayList<Movie>();

        final String SQL = "select * from Movies order by MovieRating desc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                m = new Movie(rs.getInt("AnimeID"), rs.getInt("MovieID"), rs.getString("MovieName"),
                        rs.getDate("ReleaseDate").toString(), rs.getString("Director"), rs.getInt("Duration"),
                        rs.getDouble("MovieRating"));
                mList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Movie movie : mList) {
            System.out.println(movie);
        }
    }

    public void sortByRatingLowToHigh(Anime a) {
        List<Anime> aList = new ArrayList<Anime>();

        final String SQL = "select * from anime order by rating asc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                a = new Anime(rs.getInt("id"), rs.getString("name"), rs.getString("language"),
                        rs.getString("genre"), rs.getInt("year"), rs.getString("type"), rs.getDouble("rating"),
                        rs.getString("productioncompany"));
                aList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Anime anime : aList) {
            System.out.println(anime);
        }
    }

    public void sortByratingLowToHigh(Episode e) {
        List<Episode> eList = new ArrayList<Episode>();

        final String SQL = "select * from Episodes order by EpisodeRating asc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Episode ep = new Episode(rs.getInt("AnimeID"), rs.getInt("EpisodeID"), rs.getString("EpisodeName"),
                        Episode.Type.valueOf(rs.getString("EpisodeType")), rs.getDate("AirDate").toString(),
                        rs.getDouble("EpisodeRating"));
                eList.add(ep);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        for (Episode episode : eList) {
            System.out.println(episode);
        }
    }

    public void sortByratingLowToHigh(Movie m) {
        List<Movie> mList = new ArrayList<Movie>();

        final String SQL = "select * from Movies order by MovieRating asc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                m = new Movie(rs.getInt("AnimeID"), rs.getInt("MovieID"), rs.getString("MovieName"),
                        rs.getDate("ReleaseDate").toString(), rs.getString("Director"), rs.getInt("Duration"),
                        rs.getDouble("MovieRating"));
                mList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Movie movie : mList) {
            System.out.println(movie);
        }
    }

    public void sortByDurationShortToLong(Movie m) {
        List<Movie> mList = new ArrayList<Movie>();

        final String SQL = "select * from Movies order by Duration asc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                m = new Movie(rs.getInt("AnimeID"), rs.getInt("MovieID"), rs.getString("MovieName"),
                        rs.getDate("ReleaseDate").toString(), rs.getString("Director"), rs.getInt("Duration"),
                        rs.getDouble("MovieRating"));
                mList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Movie movie : mList) {
            System.out.println(movie);
        }
    }

    public void sortByDurationLongToShort(Movie m) {
        List<Movie> mList = new ArrayList<Movie>();

        final String SQL = "select * from Movies order by Duration desc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                m = new Movie(rs.getInt("AnimeID"), rs.getInt("MovieID"), rs.getString("MovieName"),
                        rs.getDate("ReleaseDate").toString(), rs.getString("Director"), rs.getInt("Duration"),
                        rs.getDouble("MovieRating"));
                mList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Movie movie : mList) {
            System.out.println(movie);
        }
    }

    public void sortByDateNewToOld(Anime a) {
        List<Anime> aList = new ArrayList<Anime>();

        final String SQL = "select * from anime order by Year desc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                a = new Anime(rs.getInt("id"), rs.getString("name"), rs.getString("language"),
                        rs.getString("genre"), rs.getInt("year"), rs.getString("type"), rs.getDouble("rating"),
                        rs.getString("productioncompany"));
                aList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Anime anime : aList) {
            System.out.println(anime);
        }
    }

    public void sortByDateNewToOld(Episode e) {
        List<Episode> eList = new ArrayList<Episode>();

        final String SQL = "select * from Episodes order by AirDate desc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Episode ep = new Episode(rs.getInt("AnimeID"), rs.getInt("EpisodeID"), rs.getString("EpisodeName"),
                        Episode.Type.valueOf(rs.getString("EpisodeType")), rs.getDate("AirDate").toString(),
                        rs.getDouble("EpisodeRating"));
                eList.add(ep);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        for (Episode episode : eList) {
            System.out.println(episode);
        }
    }

    public void sortByDateNewToOld(Movie m) {
        List<Movie> mList = new ArrayList<Movie>();

        final String SQL = "select * from Movies order by ReleaseDate desc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                m = new Movie(rs.getInt("AnimeID"), rs.getInt("MovieID"), rs.getString("MovieName"),
                        rs.getDate("ReleaseDate").toString(), rs.getString("Director"), rs.getInt("Duration"),
                        rs.getDouble("MovieRating"));
                mList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Movie movie : mList) {
            System.out.println(movie);
        }
    }

    public void sortByDateOldToNew(Anime a) {
        List<Anime> aList = new ArrayList<Anime>();

        final String SQL = "select * from anime order by Year asc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                a = new Anime(rs.getInt("id"), rs.getString("name"), rs.getString("language"),
                        rs.getString("genre"), rs.getInt("year"), rs.getString("type"), rs.getDouble("rating"),
                        rs.getString("productioncompany"));
                aList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Anime anime : aList) {
            System.out.println(anime);
        }
    }

    public void sortByDateOldToNew(Episode e) {
        List<Episode> eList = new ArrayList<Episode>();

        final String SQL = "select * from Episodes order by AirDate asc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Episode ep = new Episode(rs.getInt("AnimeID"), rs.getInt("EpisodeID"), rs.getString("EpisodeName"),
                        Episode.Type.valueOf(rs.getString("EpisodeType")), rs.getDate("AirDate").toString(),
                        rs.getDouble("EpisodeRating"));
                eList.add(ep);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        for (Episode episode : eList) {
            System.out.println(episode);
        }
    }

    public void sortByDateOldToNew(Movie m) {
        List<Movie> mList = new ArrayList<Movie>();

        final String SQL = "select * from Movies order by ReleaseDate asc";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                m = new Movie(rs.getInt("AnimeID"), rs.getInt("MovieID"), rs.getString("MovieName"),
                        rs.getDate("ReleaseDate").toString(), rs.getString("Director"), rs.getInt("Duration"),
                        rs.getDouble("MovieRating"));
                mList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Movie movie : mList) {
            System.out.println(movie);
        }
    }

    public void filterByType(Episode e, String Type) {
        List<Episode> eList = new ArrayList<Episode>();

        final String SQL = "select * from Episodes where EpisodeType like ?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setString(1, Type);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Episode ep = new Episode(rs.getInt("AnimeID"), rs.getInt("EpisodeID"), rs.getString("EpisodeName"),
                        Episode.Type.valueOf(rs.getString("EpisodeType")), rs.getDate("AirDate").toString(),
                        rs.getDouble("EpisodeRating"));
                eList.add(ep);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        for (Episode episode : eList) {
            System.out.println(episode);
        }
    }

    public void filterByGenre(Anime a, String Genre) {
        List<Anime> aList = new ArrayList<Anime>();

        final String SQL = "select * from anime where genre like ?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setString(1, Genre);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                a = new Anime(rs.getInt("id"), rs.getString("name"), rs.getString("language"),
                        rs.getString("genre"), rs.getInt("year"), rs.getString("type"), rs.getDouble("rating"),
                        rs.getString("productioncompany"));
                aList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Anime anime : aList) {
            System.out.println(anime);
        }
    }

    public void filterByProductionCompany(Anime a, String pCompany) {
        List<Anime> aList = new ArrayList<Anime>();

        final String SQL = "select * from anime where productionCompany like ?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setString(1, pCompany);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                a = new Anime(rs.getInt("id"), rs.getString("name"), rs.getString("language"),
                        rs.getString("genre"), rs.getInt("year"), rs.getString("type"), rs.getDouble("rating"),
                        rs.getString("productioncompany"));
                aList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Anime anime : aList) {
            System.out.println(anime);
        }
    }
}
