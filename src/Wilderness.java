




public class Wilderness {

    private byte[] tiles;

    public int width;
    public int height;
    
    
   

    public Wilderness(int width, int height){
        tiles = new byte[width * height];
        this.width=width;
        this.height=height;
        this.generateWild();




    }






    public void generateWild(){
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++) {
                    
                    
                    //Path
                     if (x == 7 || x== 17 || y == 8 || y == 16){
                        tiles[x + y * width] = Tile.PATH.getId();
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
                getTile(x, y).renderWild(screen, this, x<<3, y<<3);              }

        }


    }

    private Tile getTile(int x, int y) {
        if(x<0 || x > width || y < 0 || y > height) {
            return Tile.VOID;
        }
        return Tile.tiles[tiles[x+y * width]];
    }
}
