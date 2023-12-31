package com.mockitoCourse.bookManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class BookManagerTest {

    @Spy
    private BooksRepository booksRepository;

    @InjectMocks
    private BookManager bookManager;

    private Set<String> booksDatabaseSet;

    @Before
    public void setup(){
        booksDatabaseSet = new HashSet<String>();
        booksDatabaseSet.add("Harry Potter");
    }


    @Test
    public void testGetBookInventoryCount(){

        BookManager bookManagerSpy = Mockito.spy(bookManager);
        when(booksRepository.getBooks()).thenAnswer(new GetBooks());

        Integer getBooksCount = bookManagerSpy.getBookInventoryCount();
        assertEquals(1, getBooksCount);

        String newBook = "Black box thinking";
        when(booksRepository.addBook(newBook)).thenAnswer(new AddBook());
        bookManagerSpy.addBook(newBook);
        Integer getBooksCountAfterAdd = bookManagerSpy.getBookInventoryCount();
        assertEquals(2, getBooksCountAfterAdd);
    }

    class GetBooks implements Answer<Object> {

        public Object answer(InvocationOnMock invocation) throws Throwable {

            return booksDatabaseSet;
        }
    }

    class AddBook implements Answer<Object>{

        public Object answer(InvocationOnMock invocation) throws Throwable {
            String book = (String)invocation.getArguments()[0];
            booksDatabaseSet.add(book);
            return book;
        }
    }

}