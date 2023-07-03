package com.mockitoCourse.zoo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class AnimalTest {

    @Mock(answer = Answers.RETURNS_DEFAULTS)
    Animal animal;

    @Test
    public void testAnimal(){
        System.out.println("---Returns defults---");
        Animal lion = mock(Animal.class);
        System.out.println(lion.getZooKeeper());
        System.out.println(lion.getAge());

        Animal lion2 = mock(Animal.class, RETURNS_DEFAULTS);
        System.out.println(lion2.getZooKeeper());
        System.out.println(lion2.getAge());

        System.out.println("---Returns Smart Nulls---");
        ZooKeeper zooKeeperPedro = new ZooKeeper("Pedro");
        Animal lion3 = mock(Animal.class, RETURNS_SMART_NULLS);
        when(lion3.getZooKeeper()).thenReturn(zooKeeperPedro);
        System.out.println(lion3.getZooKeeper());

        System.out.println("---Returns Mock---");
        Animal lion4 = mock(Animal.class, RETURNS_MOCKS);
        System.out.println(lion4.getAge());
        System.out.println(lion4.getZooKeeper());

        System.out.println("---Returns Deep Stubs---");
        Animal lion5 = mock(Animal.class, RETURNS_DEEP_STUBS);
        System.out.println(lion5.getAge());
        when(lion5.getZooKeeper().getName()).thenReturn("Victor");
        System.out.println(lion5.getZooKeeper().getName());

    }

}