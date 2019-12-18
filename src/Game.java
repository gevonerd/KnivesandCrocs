
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;
    //width of window
    private static final int WIDTH = 160;
    //sets height of window reletive to the width
    private static final int HEIGHT = WIDTH/12 * 9;
    //scales window up if its too small
    private static final int SCALE =8;

    //Name of the window
    public static final String NAME = "Knives and Crocs";

    private JFrame frame;

    //is it running or not?
    public boolean running = false;
    public int tickCount = 0;
    public int grass;
    public int walk;
    
    public boolean town = true;
    
    //background or world
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixles = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    //Sets array for color data of pixels. each number is the number of bits for each channel
    private int[] colors = new int[6*6*6];

    private Screen screen;
    public InputHandler input;
    public Level level;
    public Wilderness wild;
    public Player player;

    //render tool tip or not to render tooltip?
    private boolean shop1tt = false;
    private boolean shop2tt = false;

    //main constructor in game class
    //Creates main Frame
    public Game() {
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        //creates actual JFrame
        frame = new JFrame(NAME);
        //This makes it not kill itself
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //gives the frame a basic layout
        frame.setLayout(new BorderLayout());
        //adds this game class and the boarder layout to the frame
        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        //this either allows or does not allow the user to re-size the window
        frame.setResizable(false);
        //this makes the window appear in a location reletive to nothing AKA center screen.
        frame.setLocationRelativeTo(null);
        //This makes the Frame visible
        frame.setVisible(true);

        ImageIcon logoIcon = new ImageIcon("favicon.png");
        Image logo = logoIcon.getImage();
        frame.setIconImage(logo);
    }

    public void init(){
        int index = 0;
        for (int r = 0; r < 6; r++){
            for (int g = 0; g < 6; g++){
                for (int b = 0; b < 6; b++){
                    int rr = (r * 255/5);
                    int gg = (g * 255/5);
                    int bb = (b * 255/5);

                    colors [index++] = rr << 16 | gg << 8 | bb;
                }
            }
        }

        screen = new Screen(WIDTH, HEIGHT, new SpriteSheet("/sprite_sheet2.png"));
        input = new InputHandler(this);
        level = new Level (25,25);
        wild = new Wilderness (120,120);

    }
    //This method starts the game
    public synchronized void start() {
        running = true;
        //Creates a new thread
        new Thread(this).start();
    }
    //stops the game
    public synchronized void stop() {
        running = false;
    }
    //this is the method for running the actual game and contains the main "Game Loop"
    public void run(){

        //Varaibles used in rendering 60 and only 60 frames per second
        long lastTime= System.nanoTime();
        double nsPerTick = 1000000000D/60D;
        //ticks is the number of behind the scenes updates and frames is the number of graphics updates
        int ticks = 0;
        int frames = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0;

        //calls init function for render of sprite and sprite sheet hoopla
        init();

        //This is the game loop
        while (running){
            long now = System.nanoTime();
            delta +=(now - lastTime) / nsPerTick;
            lastTime = now;

            boolean shouldRender= true;

            while (delta >= 1){
                ticks++;
                tick();
                delta -=1;
                shouldRender = true;
            }

            try {
                Thread.sleep(2);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            if (shouldRender){
                frames++;
                render();
            }
            // System.out.println(frames + " Frames , " + ticks + " Ticks");

            if (System.currentTimeMillis() - lastTimer >= 1000){
                lastTimer += 1000;
                //System.out.println(frames + " Frames , " + ticks + " Ticks");
                frames = 0;
                ticks = 0;

            }

        }
    }

    private int x = 0, y = 0;

    public void tick() {
        tickCount++;
        grass++;
        walk++;
        //System.out.println(grass);
        level.tick();
        if (input.up.isPressed()) {
            if(screen.yOffset>=-33)
                screen.yOffset--;}
        if (input.down.isPressed()) {
            if(screen.yOffset<=125)
                screen.yOffset++;}
        if (input.left.isPressed()) {
            if(screen.xOffset>=-60)
                screen.xOffset--;}
        if (input.right.isPressed()) {
            if(screen.xOffset<=100)
                screen.xOffset++;}
        //System.out.println (screen.yOffset+"\t"+screen.xOffset);
        //screen.yOffset++;
        //System.out.println("x: " + screen.xOffset + "y: " + screen.yOffset);
        if (input.e.isPressed())    {
            if ((screen.xOffset>-43) &&(screen.xOffset<-26) && (screen.yOffset<13) && (screen.yOffset>5)){

                //System.out.println("Shop 1");
                Shop.weapons();
            }
            //System.out.println (screen.yOffset+"\t"+screen.xOffset);
            //screen.yOffset++;

            else if ((screen.xOffset>-16) && (screen.xOffset< 16) && (screen.yOffset<13) && (screen.yOffset>5)) {
                //System.out.println("Shop 2");
                Shop.armor();
            }
            else if ((screen.xOffset<-20) && (screen.xOffset>-30) && (screen.yOffset<-20) && (screen.yOffset>-30)) {
                System.out.println("Shop 3");
            }
        }

        //Building label
        if ((screen.xOffset>-43) &&(screen.xOffset<-26) && (screen.yOffset<13) && (screen.yOffset>5)){
            shop1tt= true;

        }
        else{
            shop1tt = false;
        }
        
        if ((screen.xOffset>-16) && (screen.xOffset< 16) && (screen.yOffset<13) && (screen.yOffset>5)) {
            shop2tt = true;
        }
        else {
            shop2tt = false;
            }
    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return;
        }

        int xOffset = x - (screen.width/2);
        int yOffset= y - (screen.height/2);

        //Tile Rendering
        if(town){
            level.renderTiles(screen, xOffset, yOffset);
        }
        else {
            wild.renderTiles(screen, xOffset, yOffset);
        }
        //Font rendering
        Font.render("Knives and Crocs", screen, 35, 5, Colors.get(000, -1, -1, 225));
        if(shop1tt){
            Font.render("Weapon Shop", screen,  screen.xOffset + 30 , screen.yOffset + 90 , Colors.get(111, -1, -1, 525));
            Font.render("press e to enter", screen, screen.xOffset + 30 , screen.yOffset + 100 , Colors.get(111, -1, -1, 525));
        }


        if(shop2tt){
            Font.render("Armor Shop", screen,  screen.xOffset + 30 , screen.yOffset + 90 , Colors.get(111, -1, -1, 525));
            Font.render("press e to enter", screen, screen.xOffset + 30 , screen.yOffset + 100 , Colors.get(111, -1, -1, 525));
        }
        
        //Sprite & animation Rendering
        if (( grass < 70)&& (grass > 30)){
            Sprite.render("1", screen,16 ,16 , Colors.get(113,224,-1,-1));
            if (grass > 60){grass = 0;}
        }
        else {
            Sprite.render("2", screen,16 ,16 , Colors.get(113,224,-1,-1));

        }

        if (( walk < 70)&& (walk > 30)){
            Player.render("1", screen, screen.xOffset + 75 , screen.yOffset + 50 , Colors.get(-1,111,443,533));

            if (walk > 50){walk = 0;}
        }
        else {
            Player.render("2", screen, screen.xOffset + 75 , screen.yOffset + 50 , Colors.get(-1,111,443,533));

        }
        for (int y = 0; y < screen.height; y++){
            for (int x = 0; x < screen.width; x++){
                int colorCode = screen.pixels[x+y * screen.width];
                if (colorCode < 255) pixles[x + y * WIDTH] = colors[colorCode];

            }

        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());

        g.drawImage(image, 0,0, getWidth(),getHeight(), null);

        g.dispose();
        bs.show();
    }
    //This is the main, it has a public, a static, and even a VOID! I KNOW AMAZING!!
    public static void main(String[] args) {

        new Game().start();
    }

}
