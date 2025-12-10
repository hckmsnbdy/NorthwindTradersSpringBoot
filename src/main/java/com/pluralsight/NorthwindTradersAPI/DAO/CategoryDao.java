package com.pluralsight.NorthwindTradersAPI.DAO;

import com.pluralsight.NorthwindTradersAPI.Models.Category;
import java.util.List;

public interface CategoryDao {
    List<Category> getAll();
    Category getById(int id);

    Category insert(Category category);
}

