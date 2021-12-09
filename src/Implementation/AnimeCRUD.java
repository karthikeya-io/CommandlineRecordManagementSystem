package Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import Classes.Anime;
import Interfaces.CRUDable;

public class AnimeCRUD implements CRUDable<Anime> {
    private static Connection con;

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        AnimeCRUD.con = con;
    }

    @Override
    public void create() {
        final String SQL = "create table anime(id int primary key,name varchar(30),language varchar(30),genre varchar(30),year int,type varchar(30),rating decimal(2,1),productioncompany varchar(30))";
        try (Statement statement = con.createStatement()) {
            statement.executeUpdate(SQL);
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Anime Table Created");
    }

    @Override
    public void insert(Anime a) {
        final String SQL = "insert into anime values(?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, a.getId());
            statement.setString(2, a.getName());
            statement.setString(3, a.getLanguage());
            statement.setString(4, a.getGenre());
            statement.setInt(5, a.getYear());
            statement.setString(6, a.getType());
            statement.setDouble(7, a.getRating());
            statement.setString(8, a.getProductionCompany());

            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            update(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Anime a) {
        final String SQL = "update anime set name=?, language=?, genre=?, year=?, type=?, rating=?, productioncompany=? where id=?;";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setString(1, a.getName());
            statement.setString(2, a.getLanguage());
            statement.setString(3, a.getGenre());
            statement.setInt(4, a.getYear());
            statement.setString(5, a.getType());
            statement.setDouble(6, a.getRating());
            statement.setString(7, a.getProductionCompany());
            statement.setInt(8, a.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Updated Insert!");
    }

    public void update(Anime a, int id, double rating) {
        final String SQL = "update anime set rating=? where ID=?;";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setDouble(1, rating);
            statement.setInt(2, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Anime> printAll() {
        List<Anime> aList = new ArrayList<Anime>();
        final String SQL = "select * from anime";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Anime a = new Anime(rs.getInt("id"), rs.getString("name"), rs.getString("language"),
                        rs.getString("genre"), rs.getInt("year"), rs.getString("type"), rs.getDouble("rating"),
                        rs.getString("productioncompany"));
                aList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aList;
    }

    @Override
    public List<Anime> printByID(int id) {
        List<Anime> aList = new ArrayList<Anime>();
        final String SQL = "select * from anime where id =?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Anime a = new Anime(rs.getInt("id"), rs.getString("name"), rs.getString("language"),
                        rs.getString("genre"), rs.getInt("year"), rs.getString("type"), rs.getDouble("rating"),
                        rs.getString("productioncompany"));
                aList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aList;
    }

    public List<Anime> printByName(String name) {
        List<Anime> aList = new ArrayList<Anime>();
        final String SQL = "select * from anime where name like ?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Anime a = new Anime(rs.getInt("id"), rs.getString("name"), rs.getString("language"),
                        rs.getString("genre"), rs.getInt("year"), rs.getString("type"), rs.getDouble("rating"),
                        rs.getString("productioncompany"));
                aList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aList;
    }

    public List<Anime> printAnime(Double d) {
        List<Anime> aList = new ArrayList<Anime>();
        final String SQL = "select * from anime where rating =?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setDouble(1, d);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Anime a = new Anime(rs.getInt("id"), rs.getString("name"), rs.getString("language"),
                        rs.getString("genre"), rs.getInt("year"), rs.getString("type"), rs.getDouble("rating"),
                        rs.getString("productioncompany"));
                aList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aList;
    }

    public void delete() {

        final String SQLde = "drop table Episodes";
        final String SQLdm = "drop table Movies";

        try (Statement statement = con.createStatement()) {
            statement.executeUpdate(SQLde);
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Statement statement = con.createStatement()) {
            statement.executeUpdate(SQLdm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final String SQL = "truncate anime";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        final String SQL = "delete from anime where id=?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String name) {
        final String SQL = "delete from anime where name=?";
        try (PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
