package com.mockitoCourse.zoo;

public class Animal {

    private ZooKeeper zooKeeper = null;
    private int age = 0;

    public Animal(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public int getAge() {
        return age;
    }

    public ZooKeeper getZooKeeper() {
        return null;
    }
}
