package Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import Classes.Movie;
import Interfaces.CRUDable;

public class MovieCRUD implements CRUDable<Movie> {
    private static Connection con;

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        MovieCRUD.con = con;
    }

    @Override
    public void create() {

        final String SQL = "CREATE TABLE Movies(AnimeID INT NOT NULL, MovieID INT PRIMARY KEY NOT NULL, MovieName VARCHAR(100), ReleaseDate DATE, Director VARCHAR(30), Duration INT, MovieRating DECIMAL(2,1),CONSTRAINT fk_movies FOREIGN KEY (AnimeID) REFERENCES Anime(ID) ON DELETE CASCADE ON UPDATE CASCADE)";
        try (Statement statement = con.createStatement()) {
            statement.executeUpdate(SQL);
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Movies Table Created");

    }

    @Override
    public void insert(Movie m) {

        final String SQL = "INSERT INTO Movies VALUES(?,?,?,?,?,?,?)";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, m.getAnimeID());
            statement.setInt(2, m.getMovieID());
            statement.setString(3, m.getMovieName());
            statement.setString(4, m.getReleasedate());
            statement.setString(5, m.getDirector());
            statement.setInt(6, m.getDuration());
            statement.setDouble(7, m.getMovieRating());

            statement.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            update(m);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Movie m) {

        final String SQL = "UPDATE Movies SET AnimeID=?, MovieName=?, ReleaseDate=?, Director=?, Duration=?, MovieRating=? where MovieID=?;";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, m.getAnimeID());
            statement.setString(2, m.getMovieName());
            statement.setString(3, m.getReleasedate());
            statement.setString(4, m.getDirector());
            statement.setInt(5, m.getDuration());
            statement.setDouble(6, m.getMovieRating());
            statement.setInt(7, m.getMovieID());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Updated Insert!");

    }

    public void update(Movie m, int id, double rating) {

        final String SQL = "UPDATE Movies SET MovieRating=? WHERE MovieID=?;";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setDouble(1, rating);
            statement.setInt(2, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> printAll() {
        List<Movie> mList = new ArrayList<Movie>();

        final String SQL = "select * from Movies";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Movie m = new Movie(rs.getInt("AnimeID"), rs.getInt("MovieID"), rs.getString("MovieName"),
                        rs.getDate("ReleaseDate").toString(), rs.getString("Director"), rs.getInt("Duration"),
                        rs.getDouble("MovieRating"));
                mList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mList;
    }

    @Override
    public List<Movie> printByID(int id) {
        List<Movie> mList = new ArrayList<Movie>();

        final String SQL = "select * from Movies where MovieID =?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Movie m = new Movie(rs.getInt("AnimeID"), rs.getInt("MovieID"), rs.getString("MovieName"),
                        rs.getDate("ReleaseDate").toString(), rs.getString("Director"), rs.getInt("Duration"),
                        rs.getDouble("MovieRating"));
                mList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mList;
    }

    public List<Movie> printMovie(double rating) {
        List<Movie> mList = new ArrayList<Movie>();

        final String SQL = "select * from Movies where MovieRating=?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setDouble(1, rating);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Movie m = new Movie(rs.getInt("AnimeID"), rs.getInt("MovieID"), rs.getString("MovieName"),
                        rs.getDate("ReleaseDate").toString(), rs.getString("Director"), rs.getInt("Duration"),
                        rs.getDouble("MovieRating"));
                mList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mList;
    }

    public List<Movie> printByAnimeName(String name) {
        List<Movie> mList = new ArrayList<Movie>();

        final String SQL = "SELECT * FROM Movies LEFT JOIN Anime ON Movies.AnimeID=Anime.ID WHERE Anime.Name LIKE ?;";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Movie m = new Movie(rs.getInt("AnimeID"), rs.getInt("MovieID"), rs.getString("MovieName"),
                        rs.getDate("ReleaseDate").toString(), rs.getString("Director"), rs.getInt("Duration"),
                        rs.getDouble("MovieRating"));
                mList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mList;
    }

    public List<Movie> printByMovieName(String name) {
        List<Movie> aList = new ArrayList<Movie>();

        final String SQL = "select * from Movies where MovieName like ?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Movie m = new Movie(rs.getInt("AnimeID"), rs.getInt("MovieID"), rs.getString("MovieName"),
                        rs.getDate("ReleaseDate").toString(), rs.getString("Director"), rs.getInt("Duration"),
                        rs.getDouble("MovieRating"));
                aList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aList;
    }

    public void delete() {

        final String SQL = "TRUNCATE Movies";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByID(int id) {

        final String SQL = "DELETE FROM Movies WHERE MovieID=?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByMovieName(String name) {

        final String SQL = "DELETE FROM Movies WHERE MovieName=?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByAnimeName(String name) {

        final String SQL = "DELETE FROM Movies LEFT JOIN Anime ON Movies.AnimeID=Anime.ID WHERE Anime.Name LIKE ?;";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
