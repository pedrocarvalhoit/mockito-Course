package com.mockitoCourse.PlayerStatics;


public class PlayerStatistics {

    private Player player;
    private int games;
    private int goals;

    public PlayerStatistics() {
    }

    public PlayerStatistics(Player player, int games, int goals) {
        this.player = player;
        this.games = games;
        this.goals = goals;
    }

    public double gamesPerGoal(){
        return (double)this.games / (double)this.goals;
    }

    public double goalsPerGame(){
        return (double)this.goals / (double)this.games;
    }

    public boolean underThirty(Player player){
        return player.getAge() < 30;
    }

    public Double[] creatCsvRecord(){
        if(this.games == 0){
            return null;
        }else{
            return new Double[]{goalsPerGame(), gamesPerGoal()};
        }
    }

    public static Player getYougerPlayer(Player p1, Player p2){
        if (p2.getAge() < p1.getAge()){
            return p2;
        }else{
            return p1;
        }
    }

}
