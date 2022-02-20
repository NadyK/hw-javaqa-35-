package netology.manager;

import netology.domain.Product;

import netology.repository.ProductRepository;

public class Manager {
    private ProductRepository prodactRepository;

    public Manager(ProductRepository repository) {
        this.prodactRepository = repository;
    }
    public void add (Product product){
        prodactRepository.save(product);
    }
    public Product[] searchBy(String text) {
        // ваш код
        return Product[];
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getTitle().contains(search)) {
                return true;
            }
            return false;
        }
    ...
        return false;
    }
}




