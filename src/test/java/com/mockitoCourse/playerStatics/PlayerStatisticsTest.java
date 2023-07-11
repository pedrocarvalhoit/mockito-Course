package com.mockitoCourse.playerStatics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerStatisticsTest {

    @Test
    public void playerNamesEqual() throws InterruptedException {
        Player p1 = new Player("Pedro Carvalho", 30);
        Thread.sleep(200);
        Player p2 = new Player("Pedro Carvalho", 26);
        //EQUALS just check de Name
        assertEquals(p1, p2);
    }

    @Test
    public void playerNamesNotEqual(){
        Player p1 = new Player("Pedro Carvalho", 30);
        Player p2 = new Player("Victor Duarte", 26);
        assertNotEquals(p1, p2);
    }

    @Test
    public void yougerPlayerName(){
        Player p1 = new Player("Pedro Carvalho", 30);
        Player p2 = new Player("Victor Duarte", 26);
        assertSame(p2, PlayerStatistics.getYougerPlayer(p1,p2));
    }

    @Test
    public void underThirtyTrue(){
        PlayerStatistics statistics = new PlayerStatistics();
        Player p1 = new Player("Pedro Carvalho", 30);
        Player p2 = new Player("Victor Duarte", 26);
        assertTrue(statistics.underThirty(p2));
    }

    @Test
    public void underThirtyFalse(){
        PlayerStatistics statistics = new PlayerStatistics();
        Player p1 = new Player("Pedro Carvalho", 30);
        Player p2 = new Player("Victor Duarte", 26);
        assertFalse(statistics.underThirty(p1));
    }

    @Test
    public void csvReportNull(){
        Player p1 = new Player("Pedro Carvalho", 30);
        PlayerStatistics statistics = new PlayerStatistics(p1, 0, 0);
        assertNull(statistics.creatCsvRecord());
    }

    @Test
    public void csvReportNotNull(){
        Player p1 = new Player("Pedro Carvalho", 30);
        PlayerStatistics statistics = new PlayerStatistics(p1, 3, 0);
        assertNotNull(statistics.creatCsvRecord());
    }

    @Test
    public void getCsvStatusRecord(){
        Player p1 = new Player("Pedro Carvalho", 30);
        PlayerStatistics statistics = new PlayerStatistics(p1, 4, 8);
        Double[] expectedArray = {2d,0.5};
        assertArrayEquals(expectedArray, statistics.creatCsvRecord());
    }

}