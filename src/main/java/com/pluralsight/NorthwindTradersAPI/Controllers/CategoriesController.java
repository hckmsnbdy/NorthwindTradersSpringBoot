package com.pluralsight.NorthwindTradersAPI.Controllers;

import com.pluralsight.NorthwindTradersAPI.Models.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    private List<Category> categories = new ArrayList<>();

    public CategoriesController() {
        categories.add(new Category(1, "Beverages"));
        categories.add(new Category(2, "Condiments"));
        categories.add(new Category(17, "Seafood"));
    }

    // GET ALL CATEGORIES
    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categories;
    }

    // GET CATEGORY BY ID
    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int id) {
        for (Category c : categories) {
            if (c.getCategoryId() == id) {
                return c;
            }
        }
        return null;
    }
}
