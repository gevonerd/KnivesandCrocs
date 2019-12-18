 




public class Level {

    private byte[] tiles;

    public int width;
    public int height;
    
    
    private int arenaX = 18;
    private int arenaY = 4;

    private int shop2X = 14;
    private int shop2Y = 5;

    public Level(int width, int height){
        tiles = new byte[width * height];
        this.width=width;
        this.height=height;
        this.generateLevel();




    }






    public void generateLevel(){
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++) {
                    if (x == 0 || y == 0 || x ==24 || y== 24){
                        tiles[x + y * width] = Tile.SKY.getId();
                    }
                    //Rock border
                    else if (x == 1 || y == 1 || x ==23 || y== 23){
                        tiles[x + y * width] = Tile.STONE.getId();
                    }
                    //Path
                    else if (x == 7 || x== 17 || y == 8 || y == 16){
                        tiles[x + y * width] = Tile.PATH.getId();
                    }
                    //Shop 1
                    else if (x == 4 && y == 5){
                        tiles[x + y * width] = Tile.SHOP1A.getId();
                    }
                    else if (x == 5 && y == 5){
                        tiles[x + y * width] = Tile.SHOP1B.getId();
                    }
                    else if (x == 6 && y == 5){
                        tiles[x + y * width] = Tile.SHOP1C.getId();
                    }
                    else if (x == 4 && y == 6){
                        tiles[x + y * width] = Tile.SHOP1D.getId();
                    }
                    else if (x == 5 && y == 6){
                        tiles[x + y * width] = Tile.SHOP1E.getId();
                    }
                    else if (x == 6 && y == 6){
                        tiles[x + y * width] = Tile.SHOP1F.getId();
                    }
                    else if (x == 4 && y == 7){
                        tiles[x + y * width] = Tile.SHOP1G.getId();
                    }
                    else if (x == 5 && y == 7){
                        tiles[x + y * width] = Tile.SHOP1H.getId();
                    }
                    else if (x == 6 && y == 7){
                        tiles[x + y * width] = Tile.SHOP1I.getId();
                    }
                    //arena
                    
                    else if (x == arenaX && y == arenaY){
                        tiles[x + y * width] = Tile.ARENAA.getId();
                    }
                    else if (x == arenaX + 1 && y == arenaY){
                        tiles[x + y * width] = Tile.ARENAB.getId();
                    }
                    else if (x == arenaX + 2 && y == arenaY){
                        tiles[x + y * width] = Tile.ARENAC.getId();
                    }
                    else if (x == arenaX + 3 && y == arenaY){
                        tiles[x + y * width] = Tile.ARENAD.getId();
                    }
                    else if (x == arenaX  && y == arenaY + 1){
                        tiles[x + y * width] = Tile.ARENAE.getId();
                    }
                    else if (x == arenaX + 1&& y == arenaY + 1){
                        tiles[x + y * width] = Tile.ARENAF.getId();
                    }
                    else if (x == arenaX + 2 && y == arenaY + 1){
                        tiles[x + y * width] = Tile.ARENAG.getId();
                    }
                    else if (x == arenaX + 3 && y == arenaY + 1){
                        tiles[x + y * width] = Tile.ARENAH.getId();
                    }
                    else if (x == arenaX && y == arenaY + 2){
                        tiles[x + y * width] = Tile.ARENAI.getId();
                    }
                    else if (x == arenaX + 1&& y == arenaY + 2){
                        tiles[x + y * width] = Tile.ARENAJ.getId();
                    }
                    else if (x == arenaX + 2 && y == arenaY + 2){
                        tiles[x + y * width] = Tile.ARENAK.getId();
                    }
                    else if (x == arenaX + 3 && y == arenaY + 2){
                        tiles[x + y * width] = Tile.ARENAL.getId();
                    }
                    else if (x == arenaX && y == arenaY + 3){
                        tiles[x + y * width] = Tile.ARENAM.getId();
                    }
                    else if (x == arenaX + 1 && y == arenaY + 3){
                        tiles[x + y * width] = Tile.ARENAN.getId();
                    }
                    else if (x == arenaX + 2&& y == arenaY + 3){
                        tiles[x + y * width] = Tile.ARENAO.getId();
                    }
                    else if (x == arenaX + 3 && y == arenaY + 3){
                        tiles[x + y * width] = Tile.ARENAP.getId();
                    }
                    //shop 2


                    else if (x == shop2X && y == shop2Y){
                        tiles[x + y * width] = Tile.SHOP2A.getId();
                    }
                    else if (x == shop2X + 1 && y == shop2Y){
                        tiles[x + y * width] = Tile.SHOP2B.getId();
                    }
                    else if (x == shop2X + 2 && y == shop2Y){
                        tiles[x + y * width] = Tile.SHOP2C.getId();
                    }
                    else if (x == shop2X  && y == shop2Y + 1){
                        tiles[x + y * width] = Tile.SHOP2D.getId();
                    }
                    else if (x == shop2X + 1&& y == shop2Y + 1){
                        tiles[x + y * width] = Tile.SHOP2E.getId();
                    }
                    else if (x == shop2X + 2 && y == shop2Y + 1){
                        tiles[x + y * width] = Tile.SHOP2F.getId();
                    }
                    else if (x == shop2X && y == shop2Y + 2){
                        tiles[x + y * width] = Tile.SHOP2G.getId();
                    }

                    else if (x == shop2X + 1&& y == shop2Y + 2){
                        tiles[x + y * width] = Tile.SHOP2H.getId();
                    }
                    else if (x == shop2X + 2 && y == shop2Y + 2){
                        tiles[x + y * width] = Tile.SHOP2I.getId();
                    }



                    //everything else grass
                     else{
                         tiles[x + y * width] = Tile.GRASS.getId();
                    }
            }
        }
    }
    public void tick(){

    }


    public void renderTiles(Screen screen, int xOffset, int yOffset){
        if(xOffset <0 )xOffset = 0;
        if(xOffset > ((width <<3 )-screen.width)) xOffset = ((width <<3 )-screen.width);

        if(yOffset <0 )yOffset = 0;
        if(yOffset > ((height <<3 )-screen.height)) yOffset = ((height <<3 )-screen.height);

        //screen.getOffset(xOffset * yOffset);

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                getTile(x, y).render(screen, this, x<<3, y<<3);            }

        }


    }

    private Tile getTile(int x, int y) {
        if(x<0 || x > width || y < 0 || y > height) {
            return Tile.VOID;
        }
        return Tile.tiles[tiles[x+y * width]];
    }
}
