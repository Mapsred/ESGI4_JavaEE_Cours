package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryBuilder {
    public static void handleVisit(Visite visite) {
        try {
            String INSERT = "INSERT INTO `visite` (`name`, `note`, `date`) VALUES (?, ?, ?)";
            PreparedStatement query = ConfigHandler.getDatabase().prepare(INSERT);
            query.setString(1, visite.getNomEtudiant());
            query.setInt(2, visite.getNote());
            query.setString(3, visite.getDate());
            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet findAllVisits() {
        String SELECT = "SELECT * FROM `visite`";
        try {
            PreparedStatement query = ConfigHandler.getDatabase().prepare(SELECT);

            return query.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
