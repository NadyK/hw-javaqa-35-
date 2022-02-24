package netology.manager;

import netology.domain.Book;
import netology.domain.Product;
import netology.domain.Smartphone;
import netology.repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private final ProductRepository repository = new ProductRepository();
    private final Manager manager = new Manager(repository);

    @Test
    void shouldAdd() {
        Product first = new Smartphone(1, "iPhone-5", 100, "USA");
        Product second = new Book(2, "Стихи", 1000, "Пушкин");
        manager.add(first);
        manager.add(second);

        Product[] expected = new Product[]{first, second};
        assertArrayEquals(repository.findAll(), expected);

    }

    @Test
    void shouldSearchByOneProduct() {
        Product first = new Smartphone(1, "iPhone-5", 100, "USA");
        Product second = new Book(2, "Стихи", 1000, "Пушкин");
        Product third = new Smartphone(3, "iPhone-6", 200, "USA");
        Product fourth = new Book(4, "Android", 300, "China");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] expected = new Product[]{second};
        assertArrayEquals(manager.searchBy("Пушкин"), expected);

    }

    @Test
    void shouldSearchByTwoProduct() {

        Product first = new Smartphone(1, "iPhone-5", 100, "USA");
        Product second = new Book(2, "Стихи", 1000, "Пушкин");
        Product third = new Smartphone(3, "iPhone-6", 200, "USA");
        Product fourth = new Book(4, "Android", 300, "China");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] expected = new Product[]{first, third};
        assertArrayEquals(manager.searchBy("USA"), expected);

    }

    @Test
    void shouldSearchByProductNothing() {

        Product first = new Smartphone(1, "iPhone-5", 100, "USA");
        Product second = new Book(2, "Стихи", 1000, "Пушкин");
        Product third = new Smartphone(3, "iPhone-6", 200, "USA");
        Product fourth = new Book(4, "Android", 300, "China");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] expected = new Product[]{};
        assertArrayEquals(manager.searchBy("Тургенев"), expected);
    }

    @Test
    void shouldSearchByProductName() {

        Product first = new Smartphone(1, "iPhone-5", 100, "USA");
        Product second = new Book(2, "Стихи", 1000, "Пушкин");
        Product third = new Smartphone(3, "iPhone-6", 200, "USA");
        Product fourth = new Book(4, "Android", 300, "China");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] expected = new Product[]{fourth};
        assertArrayEquals(manager.searchBy("Android"), expected);
    }

    @Test
    void shouldSearchByProductNamePart() {

        Product first = new Smartphone(1, "iPhone-5", 100, "USA");
        Product second = new Book(2, "Стихи", 1000, "Пушкин");
        Product third = new Smartphone(3, "iPhone-6", 200, "USA");
        Product fourth = new Book(4, "Android", 300, "China");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] expected = new Product[]{first, third};
        assertArrayEquals(manager.searchBy("iPhone"), expected);
    }


    @Test
    void shouldMatches() {
        Product first = new Smartphone(1, "iPhone-5", 100, "USA");

        assertTrue(manager.matches(first, "iPhone"));
        assertTrue(manager.matches(first, "iPho"));
        assertTrue(manager.matches(first, "USA"));
        assertFalse(manager.matches(first, "Пушкин"));
    }
}