package com.mockitoCourse.chess;

import com.mockitoCourse.playerStatics.Player;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ChessPlayerTest {

    @Test
    public void testAssignCategorySpy(){
        ChessPlayer player = new ChessPlayer("Pedro", 30, 4);
        ChessPlayer playerSpy = Mockito.spy(player);

        playerSpy.assignCategory();

        assertEquals("Senior", playerSpy.getCategory());
    }

    @Test
    public void testAssignCategorySpyNullDoNothing(){
        ChessPlayer player = new ChessPlayer("Pedro", 30, 4);
        ChessPlayer playerSpy = Mockito.spy(player);

        doNothing().when(playerSpy).assignCategory();
        playerSpy.assignCategory();

        assertEquals(null, playerSpy.getCategory());
    }

    @Test
    public void testAssignCategoryMock(){
        ChessPlayer playerMock = Mockito.mock(ChessPlayer.class);

        when(playerMock.getAge()).thenReturn(30);
        doCallRealMethod().when(playerMock).assignCategory();
        doCallRealMethod().when(playerMock).getCategory();
        playerMock.assignCategory();

        assertEquals("Senior", playerMock.getCategory());
    }

    @Test
    public void testAssignScoreStats(){
        ChessPlayer chessPlayer = new ChessPlayer("Victor", 27);
        ChessPlayer chessPlayerSpy = Mockito.spy(chessPlayer);

        doAnswer((chessP) ->{
            ChessPlayer player = (ChessPlayer)chessP.getMock();
            player.setWins(3);
            player.setPoints(9);
            return null;
        }).when(chessPlayerSpy).assignScoreStats();

        chessPlayerSpy.assignScoreStats();
        assertSame(3, chessPlayerSpy.getWins());
        assertSame(9, chessPlayerSpy.getPoints());

    }


}