package com.mockitoCourse.chess;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.processing.Generated;

public class ChessPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String category;
    private Integer age;

    private Integer wins;
    private Integer points;

    public ChessPlayer(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public ChessPlayer(String name, Integer age, Integer wins){
        this.name = name;
        this.age = age;
        this.wins = wins;
    }

    public void assignCategory(){
        System.out.println("Assignin category for paleyer: " + this.name);
        if(this.getAge() < 5){
            throw new RuntimeException("Player too young to play");
        }
        //Is age under 18? Category = Under, or else Senior
        this.category = this.getAge() < 18 ? "Under 18's" : "Senior";
    }

    public void assignScoreStats(){
        System.out.println("Assigning score stats for: " + this.name);
        this.wins = 3;
        //connects to database
        //calculates wins and sets value
        this.points = 9;
        //calculates total points and sets to 'points'
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getPoints() {
        return points;
    }
}
