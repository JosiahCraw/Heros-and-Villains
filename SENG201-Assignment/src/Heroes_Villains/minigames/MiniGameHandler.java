package Heroes_Villains.minigames;

import Heroes_Villains.Game;
import Heroes_Villains.utils.RandomNum;

public class MiniGameHandler {

    public MiniGame[] miniGames;
    public Game game;
    private int pickedGame;
    private int villainMove;
    private int[] villainMoves;

    public MiniGameHandler(Game game) {
        this.game = game;
        miniGames = new MiniGame[game.noOfCities];
        villainMoves = new int[game.noOfCities];
    }

    public void init() {
        for(int i=0; i<game.noOfCities; i++) {
            pickedGame = RandomNum.getNum(3);
            if(pickedGame == 0) {
                villainMove = RandomNum.getNum(3);
                miniGames[i] = new PaperScissorsRock(villainMove, game);
            }
            else if(pickedGame == 1) {
                villainMove = RandomNum.getNum(6) + 1;
                miniGames[i] = new DiceRoll(villainMove, game);
            }
            else if(pickedGame == 2) {
                villainMove = RandomNum.getNum(10) + 1;
                miniGames[i] = new GuessTheNumber(villainMove, game);
            }
            villainMoves[i] = villainMove;
        }
    }

    public MiniGame getCurrentGame(int cityNum) {
        return miniGames[cityNum];
    }
}
