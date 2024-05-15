package src.main;

import src.Entity.Entity;
import src.Entity.Player;
import src.object.SuperObject;
import src.tile.TileManager;

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
    TileManager tileM = new TileManager(this);
    // Instantiate key handler
    KeyHandler keyH = new KeyHandler();
    //Create game loop
    Thread gameThread;

    //UI GAME (Instantiate)
    public UI ui = new UI(this);

    //Collision checker
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);


    //CREATING SUPER OBJECT -> ENTITY AND OBJECT
    public Player player = new Player(this, keyH);
    public Entity obj[] = new Entity[10];
    public Entity plant[] = new Entity[10]; //TYPE masih ENTITY, TODO : buat type Plant yang extends Entity
    public Entity zombie[] = new Entity[10]; //TYPE masih ENTITY, TODO : buat type Zombie yang extends Entity

    //TODO : gatau perlu ditambah ato ga, perlu ide....
    ArrayList<Entity> entityList = new ArrayList<>(); //Creating one big entity list to sort the render layer

    //Constructor
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //Frame
        this.setBackground((Color.BLACK));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true); //Panel "focused" to receive input
    }

    public void setupGame(){
        assetSetter.setObject();
        assetSetter.setPlant();
        assetSetter.setZombie();
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
        //PLAYER
        player.update();

        //ZOMBIE
        for(int i = 0; i < zombie.length; i++){
            if(zombie[i] != null){
                zombie[i].update();
            }
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

        //TILE
        tileM.draw(g2);
        //UI
        ui.draw(g2);

        //ADD ENTITIES TO LIST
        entityList.add(player);

            //ENTITIES object
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                entityList.add(obj[i]);
            }
        }

            //ENTITIES plant
        for(int i = 0; i < plant.length; i++){
            if(plant[i] != null){
                entityList.add(plant[i]);
            }
        }

            //ENTITIES zombie
        for(int i = 0; i < zombie.length; i++){
            if(zombie[i] != null){
                entityList.add(zombie[i]);
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
        for(int i = 0; i < entityList.size(); i++){
            entityList.remove(i);
        }


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
