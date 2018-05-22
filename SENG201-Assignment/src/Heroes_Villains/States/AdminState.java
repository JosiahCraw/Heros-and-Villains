package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.cities.rooms.Rooms;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;

import java.awt.*;

public class AdminState extends State{

    public int buttonClicked;
    private Rooms[] currRooms;
    private UIElement up, down, left, right;
    private Color colour;
    private Citys citysClass;
    private BattleState battleState;

    public AdminState(Game game, Citys citysClass, BattleState battleState) {
        super(game);
        this.citysClass = citysClass;
        this.battleState = battleState;
        up = new UIButton(200, 550, game, Assets.blankButton, 200, 35);
        down = new UIButton(200, 650, game, Assets.blankButton, 200, 35);
        left = new UIButton(50, 600, game, Assets.blankButton, 200, 35);
        right = new UIButton(350, 600, game, Assets.blankButton, 200, 35);
        currRooms = new Rooms[5];
        for(int i=0; i<4; i++) {
            currRooms[i] = citysClass.cities[game.getPlayer().getCurrentCity()].rooms[i];
        }
        colour = Color.WHITE;

    }


    @Override
    public void update() {
        for(int i=0; i<4; i++) {
        currRooms[i] = citysClass.cities[game.getPlayer().getCurrentCity()].rooms[i];
    }
        up.update();
        down.update();
        left.update();
        right.update();
        if(((UIButton) up).isHovering() && game.getMouseListener().leftClicked) {
            game.getPlayer().setX(640);
            game.getPlayer().setY(360);
            game.getPlayer().setCurrentRoom(1);
        }
        if(((UIButton) right).isHovering() && game.getMouseListener().leftClicked) {
            game.getPlayer().setX(640);
            game.getPlayer().setY(360);
            game.getPlayer().setCurrentRoom(2);
        }
        if(((UIButton) down).isHovering() && game.getMouseListener().leftClicked) {
            game.getPlayer().setX(640);
            game.getPlayer().setY(360);
            game.getPlayer().setCurrentRoom(3);
        }
        if(((UIButton) left).isHovering() && game.getMouseListener().leftClicked) {
            game.getPlayer().setX(640);
            game.getPlayer().setY(360);
            game.getPlayer().setCurrentRoom(0);
        }
    }

    @Override
    public void render(Graphics graphics) {
        up.render(graphics);
        down.render(graphics);
        left.render(graphics);
        right.render(graphics);
        DrawText.draw(graphics, currRooms[1].roomName, 300, 568, true, colour, Assets.smallFont);
        DrawText.draw(graphics, currRooms[3].roomName, 300, 668, true, colour, Assets.smallFont);
        DrawText.draw(graphics, currRooms[0].roomName, 150, 618, true, colour, Assets.smallFont);
        DrawText.draw(graphics, currRooms[2].roomName, 450, 618, true, colour, Assets.smallFont);
        if(((UIButton) up).isHovering()) {
            DrawText.draw(graphics, currRooms[1].roomName, 300, 568, true, Color.CYAN, Assets.smallFont);
        }
        if(((UIButton) down).isHovering()) {
            DrawText.draw(graphics, currRooms[3].roomName, 300, 668, true, Color.CYAN, Assets.smallFont);
        }
        if(((UIButton) left).isHovering()) {
            DrawText.draw(graphics, currRooms[0].roomName, 150, 618, true, Color.CYAN, Assets.smallFont);
        }
        if(((UIButton) right).isHovering()) {
            DrawText.draw(graphics, currRooms[2].roomName, 450, 618, true, Color.CYAN, Assets.smallFont);
        }
        if(battleState.currMiniGame != null) {
            DrawText.draw(graphics, "Current Mini Game: " + battleState.currMiniGame.gameName, 640, 100, true, Color.BLACK, Assets.invFont);
            DrawText.draw(graphics, "Villains Move: " + battleState.currMiniGame.villainMoveWords, 640, 150, true, Color.BLACK, Assets.invFont);
        }

    }
}
