package src.main;

import src.Entity.Player;
import src.object.SuperObject;
import src.tile.TileManager;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //  SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;

    private final int tileSize = originalTileSize * scale; // 48x48 tile
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
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
    int FPS = 60;

    //Instantiate tile manager
    TileManager tileM = new TileManager(this);
    // Instantiate key handler
    KeyHandler keyH = new KeyHandler();
    //Create game loop
    Thread gameThread;


    //Collision checker
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);

    //CREATING SUPER OBJECT
    public SuperObject obj[] = new SuperObject[20];

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

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        //Draw tile first then player
        tileM.draw(g2);
        for(int i = 0;i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }
        player.draw(g2);

        g2.dispose();
    }
}
