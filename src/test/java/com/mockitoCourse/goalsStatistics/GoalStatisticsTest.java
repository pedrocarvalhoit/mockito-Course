package com.mockitoCourse.goalsStatistics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GoalStatisticsTest {

    @Mock
    GoalsService goalsService;

    @InjectMocks
    GoalStatistics goalStatistics;

    @Test
    public void testGoalsPerGame() throws Exception {
        String player = "Pedro Carvalho";

        //First time will return 100 than second time 10
        when(goalsService.getGoals(player)).thenReturn(100).thenReturn(10);
        Integer goalsHigh = goalStatistics.goalPerGame(player, 10);
        assertEquals(10, goalsHigh);

        Integer goalsLow = goalStatistics.goalPerGame(player, 10);
        assertEquals(1, goalsLow);
    }



}