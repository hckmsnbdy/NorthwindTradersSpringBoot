package com.pluralsight.NorthwindTradersAPI.Controllers;

import com.pluralsight.NorthwindTradersAPI.DAO.ProductDao;
import com.pluralsight.NorthwindTradersAPI.Models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    private final ProductDao productDao;

    public ProductsController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int id) {
        return productDao.getById(id);
    }
    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {
        return productDao.insert(product);
    }


}
