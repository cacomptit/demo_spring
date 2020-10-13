package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Book;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookRepository {
    @Select("select id, name from books")
    List<Book> findAll();

    @Select("select * from books where id = #{id}")
    Book findById(int id);

    @Insert("insert into books(name) values(#{name})")
    void addBook(Book book);

    @Update("update books set name = #{name} where id = #{id}")
    void editBook(Book book);

    @Delete("delete from books where id = #{id}")
    void deleteBook(int id);

}