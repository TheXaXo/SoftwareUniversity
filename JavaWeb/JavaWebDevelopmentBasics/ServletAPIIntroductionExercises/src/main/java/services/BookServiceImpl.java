package services;

import entities.Book;
import models.bindingModels.AddBookModel;
import models.viewModels.ViewBookModel;
import org.modelmapper.ModelMapper;
import repositories.BookRepository;
import repositories.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    public BookServiceImpl() {
        this.bookRepository = BookRepositoryImpl.getInstance();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void saveBook(AddBookModel addBookModel) {
        Book book = this.modelMapper.map(addBookModel, Book.class);
        book.setId(UUID.randomUUID().toString());
        book.setCreationDate(new Date());

        this.bookRepository.saveBook(book);
    }

    @Override
    public List<ViewBookModel> getAllBooks() {
        List<ViewBookModel> booksDtos = new ArrayList<>();

        for (Book book : this.bookRepository.getAllBooks()) {
            ViewBookModel bookDto = this.modelMapper.map(book, ViewBookModel.class);
            booksDtos.add(bookDto);
        }

        return booksDtos;
    }

    @Override
    public ViewBookModel findBookByTitle(String title) {
        Book book = this.bookRepository.findBookByTitle(title);

        if (book == null) {
            return null;
        }

        return this.modelMapper.map(book, ViewBookModel.class);
    }

    @Override
    public void deleteBookByTitle(String title) {
        this.bookRepository.deleteBookByTitle(title);
    }
}