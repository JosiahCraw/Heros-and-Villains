package Heroes_Villains.minigames;

import Heroes_Villains.Game;
import Heroes_Villains.utils.RandomNum;

public class MiniGameHandler {

    public MiniGame[] miniGames;
    public Game game;
    private int pickedGame;
    private int villainMove;


    public MiniGameHandler(Game game) {
        this.game = game;

    }

    public MiniGame getGame() {
        MiniGame miniGame;
        RandomNum randomNum;
        randomNum = new RandomNum();
            pickedGame = randomNum.getNum(3);
            if(pickedGame == 0) {
                villainMove = randomNum.getNum(3);
                miniGame = new PaperScissorsRock(villainMove, game);
                return miniGame;
            }
            else if(pickedGame == 1) {
                villainMove = randomNum.getNum(6) + 1;
                miniGame = new DiceRoll(villainMove, game);
                return miniGame;
            }
            else{
                villainMove = randomNum.getNum(10) + 1;
                miniGame = new GuessTheNumber(villainMove, game);
                return miniGame;
            }
        }

    public MiniGame getCurrentGame(int cityNum) {
        return miniGames[cityNum];
    }
}
