package persisten;

import Logik.Kunde;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KundeMapper {


    public static List<Kunde> getKunder() {

        Connection connection;
        List<Kunde> kundeList = new ArrayList<>();

        try {
            connection = Connector.connection();
            String sql = "select * from kunder";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Kunde kunde = new Kunde();
                kunde.setKundenr(resultSet.getInt(1));
                kunde.setNavn(resultSet.getString(2));
                kundeList.add(kunde);

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kundeList;
    }

    public static void slet (String kundenr) {


        try {
            Connection connection = Connector.connection();
            String sql = "delete from kunder where idkunder= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(kundenr));
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void Opret(Kunde kunde) {

        try {
            Connection connection = Connector.connection();
            String sql = "insert into kunder ( navn) values ( ? )";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,kunde.getNavn());
            int resultSet = ps.executeUpdate();




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void Opdater(String nr, String navn) {

        try {
            Connection connection = Connector.connection();
            String sql = "update kunder set navn = ? where idkunder= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, navn);
            ps.setInt(2,Integer.parseInt(nr));
            ps.execute();




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

