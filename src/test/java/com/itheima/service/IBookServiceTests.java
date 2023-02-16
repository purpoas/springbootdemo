package com.itheima.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class IBookServiceTests {
    @Autowired
    private IBookService bookService;

    @Test
    void testService() {
        Page<Book> page = new Page<>(2,1);
        for (Book book : bookService.page(page).getRecords()) {
            System.out.println(book);
        }
    }

    @Test
    void testDelete() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(13);
        bookService.removeByIds(integers);
    }

    @Test
    void testUpdate() {
        Book book = bookService.getById(6);
        book.setName("lili");
        bookService.updateById(book);
    }
}
