package com.mockitoCourse.goalsStatistics;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GoalStatisticsTest {

    @Mock
    GoalsService goalsService;

    @InjectMocks
    GoalStatistics goalStatistics;

    @Test
    public void testGoalsPerGame() throws Exception {
        String player = "Pedro Carvalho";

        when(goalsService.getGoals(player)).thenReturn(100);
        Integer goalsAvarage = goalStatistics.goalPerGame(player, 10);
        assertEquals(10, goalsAvarage);

    }

}