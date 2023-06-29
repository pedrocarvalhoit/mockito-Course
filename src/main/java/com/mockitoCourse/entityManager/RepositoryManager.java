package com.mockitoCourse.entityManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class RepositoryManager {

    public static final String GET_ALL_STUDENTS = "SELECT * FROM student_table";
    private final EntityManager entityManager;

    public RepositoryManager(EntityManager entityManagerArg) {
        this.entityManager = entityManagerArg;
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = getStudentsQuery(entityManager, GET_ALL_STUDENTS);
        entityManager.close();
        return studentList;
    }

    private static List<Student> getStudentsQuery(EntityManager entityManager, String sql){
        Query allStudentsQuery = entityManager.createNamedQuery(sql);
        return allStudentsQuery.getResultList();
    }
}
