package com.pluralsight.NorthwindTradersAPI.DAO;

import com.pluralsight.NorthwindTradersAPI.Models.Product;
import java.util.List;

public interface ProductDao {
    List<Product> getAll();
    Product getById(int id);

    Product insert(Product product);
}
