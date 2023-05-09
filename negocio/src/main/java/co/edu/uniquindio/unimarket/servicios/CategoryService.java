package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Category;

public interface CategoryService {
    Category createCategory(Category c) throws Exception;
    Category updateCategory(Category c) throws Exception;

    void deleteCategory(int id) throws Exception;
}
