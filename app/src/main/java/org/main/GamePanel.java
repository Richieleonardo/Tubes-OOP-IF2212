package org.main;

import org.Entity.Entity;
import org.Entity.Player;
import org.Entity.Projectile;
import org.checkerframework.checker.units.qual.N;
import org.object.plant.*;
import org.object.zombie.*;
import org.tile.TileManager;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable{

    //  SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;

    private final int tileSize = originalTileSize * scale; // 48x48 tile (Yang akan digunakan)
    private final int maxScreenCol = 16; //Frame hanya memuat 16 Tile dari kiri ke kanan
    private final int maxScreenRow = 12; //Frame membuat 12 Tile dari atas ke bawah
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // WORLD SETTINGS
    public final int maxWorldCol = 31;
    public final int maxWorldRow = 14;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //Getter
    public int getTileSize(){
        return tileSize;
    }
    public int getMaxScreenCol() { return maxScreenCol; }
    public int getMaxScreenRow() { return maxScreenRow; }
    public int getScreenWidth() { return screenWidth; }
    public int getScreenHeight() { return screenHeight; }

    // FPS
    int FPS = 60; //Game tick

    //Instantiate tile manager
    public TileManager tileM = new TileManager(this);
    // Instantiate key handler
    KeyHandler keyH = new KeyHandler(this);
    //Create game loop
    Thread gameThread;

    //UI GAME (Instantiate)
    public UI ui = new UI(this);

    //Collision checker
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);


    //CREATING SUPER OBJECT -> ENTITY AND OBJECT
    public Player player = new Player(this, keyH);
    public ArrayList<Entity> obj= new ArrayList<>();
    public ArrayList<Entity> plant = new ArrayList<>(); //TYPE masih ENTITY,
    public ArrayList<Entity> zombie = new ArrayList<>(); //TYPE masih ENTITY,

    //TODO : gatau perlu ditambah ato ga, perlu ide....
    public ArrayList<Entity> projectileList = new ArrayList<>();
    public ArrayList<Entity> entityList = new ArrayList<>(); //Creating one big entity list to sort the render layer

    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int inventoryState = 3;
    public final int deckState = 4;
    public final int ListPlantState = 5;
    public final int ListZombiesState = 6;
    public final int HelpState = 7;
    public final int swapStateInv = 8; //LATER USE
    public final int swapStateDeck = 9;

    //Constructor
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //Frame
        this.setBackground((Color.BLACK));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true); //Panel "focused" to receive input
    }

    public void setupGame(){
//        assetSetter.setObject();
//        assetSetter.setPlant(plant);
//        assetSetter.setPlant(new Sunflower(this), 15, 6);
//        assetSetter.setPlant(new Threepeater(this), 18, 7);
//        assetSetter.setPlant(new Cabbagepult(this), 17, 7);
//        assetSetter.setPlant(new Peashooter(this), 18, 7);
//        assetSetter.setPlant(new SnowPeashooter(this), 16, 6);
//        assetSetter.setPlant(new Repeater(this), 15,7);
//        assetSetter.setPlant(new Squash(this),16, 7);
//        assetSetter.setPlant(new Wallnut(this), 22, 7);
//        assetSetter.setZombie(new NormalZombie(this), 24, 7);
//        assetSetter.setZombie(new ConeHeadZombie(this), 24, 6);
        gameState = titleState;
    }

    /*
     GAME LOOP
    */
    @Override
    public void run(){ //Game loop of the game
        //For game FPS and FPS counter
        double drawInterval = 1_000_000_000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){ //selama Thread exist loop akan selalu jalan
//            System.out.println("The game loop is running");
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--; //set Delta back to 0
                drawCount++; //counter Frame
            }

            if(timer >= 1_000_000_000){ //Set back timer back to 0
                System.out.println("FPS: "+ drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }

    public void startGameThread(){
        gameThread = new Thread(this); //Instantiate this class
        gameThread.start();
    }

    public void update(){ //update the draw method

        if(gameState == playState){
            //PLAYER
            player.update();


            //ZOMBIE
            for(int i = 0; i < zombie.size(); i++){
                if(zombie.get(i) != null){
                    Zombie enemy = (Zombie) zombie.get(i);
                    enemy.update();
                    if(enemy.collisionTile){
                        ui.gameFinishedLose = true;
                    }
//                    zombie.get(i).update();
                }
            }

            //PLANT
            for(int i = 0; i < plant.size(); i++){
                if(plant.get(i) != null){
                    Plant tanaman = (Plant) plant.get(i);
                    tanaman.update();
                }
            }

            //PROJECTILE
            for(int i = 0; i < projectileList.size(); i++){
                if(projectileList.get(i) != null){
                    if(projectileList.get(i).alive){
                        Projectile pellet = (Projectile) projectileList.get(i);
                        pellet.update();
                    }
                }
                if(projectileList.get(i).alive == false){
                    projectileList.remove(i);
                }
            }
        }

        if(UI.playTime > 200 && zombie.isEmpty()){
            ui.gameFinishedWin = true;
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //DEBUG
        long drawStart = 0;

        if(keyH.checkDrawTime == true){
            drawStart = System.nanoTime();
        }

        //TITLE SCREEN
        if(gameState == titleState){
            ui.draw(g2);
        }else{
            //TILE
            tileM.draw(g2);


            //ADD ENTITIES TO LIST
            entityList.add(player);

//            //ENTITIES object
//        for(int i = 0; i < obj.length; i++){
//            if(obj[i] != null){
//                entityList.add(obj[i]);
//            }
//        }

            //ENTITIES plant
            for(Entity plant : plant){
                if(plant != null){
                    entityList.add(plant);
                }
            }

            //ENTITIES zombie
            for(int i = 0; i < zombie.size(); i++){
                if(zombie.get(i) != null){
                    entityList.add(zombie.get(i));
                }
            }

            //ADD PROJECTILE TO LIST
            for(int i = 0; i < projectileList.size(); i++){
                if(projectileList.get(i) != null){
                    entityList.add(projectileList.get(i));
                }
            }

            //SORT
            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {

                    int result = Integer.compare(e1.worldY, e2.worldY);
                    return result;
                }
            });


            //DRAW ENTITIES
            for(int i = 0; i < entityList.size(); i++){
                entityList.get(i).draw(g2);
            }
            //EMPTY ENTITY LIST
            entityList.clear();

            //UI
            ui.draw(g2);
        }


        //DEBUG
//        g2.drawRect((28+ player.screenX), (12 + player.screenY), 10, 40);

        //DEBUG
        if(keyH.checkDrawTime == true){
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw Time: " + passed);
        }

        g2.dispose();
    }
}
