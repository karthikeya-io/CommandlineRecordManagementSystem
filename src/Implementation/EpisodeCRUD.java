package Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import Classes.Episode;
import Interfaces.CRUDable;

public class EpisodeCRUD implements CRUDable<Episode> {
    private static Connection con;

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        EpisodeCRUD.con = con;
    }

    @Override
    public void create() {

        final String SQL = "CREATE TABLE Episodes(AnimeID INT NOT NULL,EpisodeID INT PRIMARY KEY NOT NULL,EpisodeName VARCHAR(100),EpisodeType VARCHAR(30),AirDate DATE,EpisodeRating DECIMAL(2,1),CONSTRAINT fk_episodes FOREIGN KEY (AnimeID)REFERENCES Anime(ID) ON DELETE CASCADE ON UPDATE CASCADE)";
        try (Statement statement = con.createStatement()) {
            statement.executeUpdate(SQL);
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Episodes Table Created");

    }

    @Override
    public void insert(Episode ep) {

        final String SQL = "INSERT INTO Episodes VALUES(?,?,?,?,?,?)";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, ep.getAnimeID());
            statement.setInt(2, ep.getEpisodeID());
            statement.setString(3, ep.getEpisodeName());
            statement.setString(4, ep.getEpisodeType().toString());
            statement.setString(5, ep.getAirdate());
            statement.setDouble(6, ep.getEpisodeRating());

            statement.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            update(ep);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Episode ep) {

        final String SQL = "UPDATE Episodes SET AnimeID=?, EpisodeName=?, EpisodeType=?, AirDate=?, EpisodeRating=? where episodeID=?;";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, ep.getAnimeID());
            statement.setString(2, ep.getEpisodeName());
            statement.setString(3, ep.getEpisodeType().name());
            statement.setString(4, ep.getAirdate());
            statement.setDouble(5, ep.getEpisodeRating());
            statement.setInt(6, ep.getEpisodeID());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Updated Insert!");

    }

    public void update(Episode ep, int id, double rating) {

        final String SQL = "UPDATE Episodes SET EpisodeRating=? WHERE EpisodeID=?;";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setDouble(1, rating);
            statement.setInt(2, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Episode> printAll() {
        List<Episode> eList = new ArrayList<Episode>();

        final String SQL = "select * from Episodes";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Episode ep = new Episode(rs.getInt("AnimeID"), rs.getInt("EpisodeID"), rs.getString("EpisodeName"),
                        Episode.Type.valueOf(rs.getString("EpisodeType")), rs.getDate("AirDate").toString(),
                        rs.getDouble("EpisodeRating"));
                eList.add(ep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eList;
    }

    @Override
    public List<Episode> printByID(int id) {
        List<Episode> eList = new ArrayList<Episode>();

        final String SQL = "select * from Episodes where EpisodeID =?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Episode ep = new Episode(rs.getInt("AnimeID"), rs.getInt("EpisodeID"), rs.getString("EpisodeName"),
                        Episode.Type.valueOf(rs.getString("EpisodeType")), rs.getDate("AirDate").toString(),
                        rs.getDouble("EpisodeRating"));
                eList.add(ep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eList;
    }

    public List<Episode> printEpisode(double rating) {
        List<Episode> eList = new ArrayList<Episode>();

        final String SQL = "select * from Episodes where EpisodeRating=?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setDouble(1, rating);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Episode ep = new Episode(rs.getInt("AnimeID"), rs.getInt("EpisodeID"), rs.getString("EpisodeName"),
                        Episode.Type.valueOf(rs.getString("EpisodeType")), rs.getDate("AirDate").toString(),
                        rs.getDouble("EpisodeRating"));
                eList.add(ep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eList;
    }

    public List<Episode> printByAnimeName(String name) {
        List<Episode> eList = new ArrayList<Episode>();

        final String SQL = "SELECT * FROM Episodes LEFT JOIN Anime ON Episodes.AnimeID=Anime.ID WHERE Anime.Name LIKE ?;";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Episode ep = new Episode(rs.getInt("AnimeID"), rs.getInt("EpisodeID"), rs.getString("EpisodeName"),
                        Episode.Type.valueOf(rs.getString("EpisodeType")), rs.getDate("AirDate").toString(),
                        rs.getDouble("EpisodeRating"));
                eList.add(ep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eList;
    }

    public List<Episode> printByEpName(String name) {
        List<Episode> eList = new ArrayList<Episode>();

        final String SQL = "select * from Episodes where EpisodeName like ?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Episode ep = new Episode(rs.getInt("AnimeID"), rs.getInt("EpisodeID"), rs.getString("EpisodeName"),
                        Episode.Type.valueOf(rs.getString("EpisodeType")), rs.getDate("AirDate").toString(),
                        rs.getDouble("EpisodeRating"));
                eList.add(ep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eList;
    }

    public void delete() {

        final String SQL = "TRUNCATE Episodes";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByID(int id) {

        final String SQL = "DELETE FROM Episodes WHERE EpisodeID=?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByEpisodeName(String name) {

        final String SQL = "DELETE FROM Episodes WHERE EpisodeName=?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByAnimeName(String name) {

        final String SQL = "DELETE FROM Episodes LEFT JOIN Anime ON Episodes.AnimeID=Anime.ID WHERE Anime.Name LIKE ?;";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}