package com.itheima.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final IBookService bookService;
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public R getAll() {
        List<Book> list = bookService.list();
        return R.r(list != null, list);
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        return R.r(book != null, book);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        Page<Book> page = new Page<>(currentPage, pageSize);
        bookService.getPage(page, book);
        if (currentPage > page.getPages()) {
            page = bookService.getPage(page, book);
        }
        return R.r(page);
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if(book.getName().contains("z")) {
            throw new IOException();
        }
        boolean success = bookService.save(book);
        return R.r(success, success ? "book added successfully ^_^" : "book fail to add -_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return R.r(bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return R.r(bookService.removeById(id));
    }

}
