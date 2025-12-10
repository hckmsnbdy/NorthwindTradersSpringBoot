package com.pluralsight.NorthwindTradersAPI.DAO;

import com.pluralsight.NorthwindTradersAPI.Models.Product;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {

    private final DataSource dataSource;

    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        String sql = "SELECT ProductID, ProductName, CategoryID, UnitPrice FROM Products";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("CategoryID"),
                        rs.getDouble("UnitPrice")
                );
                products.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product getById(int id) {
        String sql = "SELECT ProductID, ProductName, CategoryID, UnitPrice " +
                "FROM Products WHERE ProductID = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                            rs.getInt("ProductID"),
                            rs.getString("ProductName"),
                            rs.getString("CategoryID"),
                            rs.getDouble("UnitPrice")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
