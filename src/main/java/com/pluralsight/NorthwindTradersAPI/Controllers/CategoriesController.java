package com.pluralsight.NorthwindTradersAPI.Controllers;

import com.pluralsight.NorthwindTradersAPI.DAO.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.Models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {

    private final CategoryDao categoryDao;

    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int id) {
        return categoryDao.getById(id);
    }
    @RequestMapping(path = "/categories", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category) {
        return categoryDao.insert(category);
    }
}
