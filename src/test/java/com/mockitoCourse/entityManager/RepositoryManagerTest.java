package com.mockitoCourse.entityManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class RepositoryManagerTest {

    @Test
    public void getAllStudentsTest(){
        EntityManager emMock = Mockito.mock(EntityManager.class);
        RepositoryManager repositoryManager= new RepositoryManager(emMock);

        Student a = new Student(1, "Pedro");
        Student b = new Student(2, "Thamires");
        Student c = new Student(3, "Victor");
        List<Student> studentList = Arrays.asList(a,b,c);

        Query queryMock = Mockito.mock(Query.class);
        when(queryMock.getResultList()).thenReturn(studentList);

        when(emMock.createNamedQuery(RepositoryManager.GET_ALL_STUDENTS)).thenReturn(queryMock);

        List<Student> actualStudents = repositoryManager.getAllStudents();
        Assert.assertThat(actualStudents, is(studentList));
    }

}