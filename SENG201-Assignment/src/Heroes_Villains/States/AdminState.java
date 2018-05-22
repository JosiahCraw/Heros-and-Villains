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

    private UIElement cityInfoRadio;
    public int buttonClicked;
    private Rooms[] currRooms;
    private UIElement up, down, left, right;
    private Color colour;
    private Citys citysClass;

    public AdminState(Game game, Citys citysClass) {
        super(game);
        this.citysClass = citysClass;
        cityInfoRadio = new RadioButtons(50, 50, game, Assets.testRadioButton, game.getNoOfCities(), 50, true, 150, 150);
        ((RadioButtons) cityInfoRadio).getButtons()[0].clicked = true;
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
        cityInfoRadio.update();
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
        buttonClicked = ((RadioButtons) cityInfoRadio).currentlyClicked;
    }

    @Override
    public void render(Graphics graphics) {
        cityInfoRadio.render(graphics);
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
        DrawText.draw(graphics, game.miniGameHandler.miniGames[buttonClicked].gameName, 600, 300, true, Color.BLACK, Assets.invFont);
        DrawText.draw(graphics, game.miniGameHandler.miniGames[buttonClicked].villainMoveWords, 600, 400, true, Color.BLACK, Assets.invFont);

    }
}
