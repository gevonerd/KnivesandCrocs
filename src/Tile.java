

public abstract class Tile {

    //Tiles and such
    public static final Tile[] tiles = new Tile[256];
    public static final Tile VOID = new BasicTile(0, 0, 0, Colors.get(000, -1,-1,-1));
    public static final Tile STONE = new BasicTile(1, 1, 0, Colors.get(222,333,111,222));
    public static final Tile GRASS = new BasicTile(2, 2,0, Colors.get(-1,131,141,-1));
    public static final Tile SKY = new BasicTile(3, 3, 0, Colors.get(-1, 135, 135, -1));
    public static final Tile PATH = new BasicTile(4, 4, 0, Colors.get(222,444,-1,-1));
    public static final Tile SHOP1A = new BasicTile (5,5,0, Colors.get(222,333,444,-1));
    public static final Tile SHOP1B = new BasicTile (6,6,0, Colors.get(222,333,444,-1));
    public static final Tile SHOP1C = new BasicTile (7,7,0, Colors.get(222,333,444,-1));
    public static final Tile SHOP1D = new BasicTile (8,8,0, Colors.get(222,422,224,333));
    public static final Tile SHOP1E = new BasicTile (9,9,0, Colors.get(222,422,224,333));
    public static final Tile SHOP1F = new BasicTile (10,10,0, Colors.get(222,422,224,333));
    public static final Tile SHOP1G = new BasicTile (11,11,0, Colors.get(222,422,224,333));
    public static final Tile SHOP1H = new BasicTile (12,12,0, Colors.get(222,422,224,333));
    public static final Tile SHOP1I = new BasicTile (13,13,0, Colors.get(222,422,224,333));
    
    public static final Tile ARENAA = new BasicTile (14,14,0, Colors.get(111,222,224,131));
    public static final Tile ARENAB = new BasicTile (15,15,0, Colors.get(111,222,224,131));
    public static final Tile ARENAC = new BasicTile (16,16,0, Colors.get(111,222,224,131));
    public static final Tile ARENAD = new BasicTile (17,17,0, Colors.get(111,222,224,131));
    public static final Tile ARENAE = new BasicTile (18,18,0, Colors.get(111,222,224,131));
    public static final Tile ARENAF = new BasicTile (19,19,0, Colors.get(111,222,224,131));
    public static final Tile ARENAG = new BasicTile (20,20,0, Colors.get(111,222,224,131));
    public static final Tile ARENAH = new BasicTile (21,21,0, Colors.get(111,222,224,131));
    public static final Tile ARENAI = new BasicTile (22,22,0, Colors.get(111,222,224,131));
    public static final Tile ARENAJ = new BasicTile (23,23,0, Colors.get(111,222,224,131));
    public static final Tile ARENAK = new BasicTile (24,24,0, Colors.get(111,222,224,131));
    public static final Tile ARENAL = new BasicTile (25,25,0, Colors.get(111,222,224,131));
    public static final Tile ARENAM = new BasicTile (26,26,0, Colors.get(111,222,224,131));
    public static final Tile ARENAN = new BasicTile (27,27,0, Colors.get(111,222,224,131));
    public static final Tile ARENAO = new BasicTile (28,28,0, Colors.get(111,222,224,131));
    public static final Tile ARENAP = new BasicTile (29,29,0, Colors.get(111,222,224,131));
    
    public static final Tile SHOP2A = new BasicTile(30,30,0, Colors.get(111,222,333,444));
    public static final Tile SHOP2B = new BasicTile(31,31,0, Colors.get(111,222,333,444));
    public static final Tile SHOP2C = new BasicTile(32,32,0, Colors.get(111,222,333,444));
    public static final Tile SHOP2D = new BasicTile(33,33,0, Colors.get(111,311,112,444));
    public static final Tile SHOP2E = new BasicTile(34,34,0, Colors.get(111,311,112,444));
    public static final Tile SHOP2F = new BasicTile(35,35,0, Colors.get(111,311,112,444));
    public static final Tile SHOP2G = new BasicTile(36,36,0, Colors.get(111,222,540,555));
    public static final Tile SHOP2H = new BasicTile(37,37,0, Colors.get(111,222,540,555));
    public static final Tile SHOP2I = new BasicTile(38,38,0, Colors.get(111,222,540,555));

    protected byte id;
    protected boolean solid;
    protected boolean emitter;

    public Tile(int id, boolean isSolid, boolean isEmitter){
        this.id= (byte)id;
        if(tiles[id] != null) throw new RuntimeException("Duplicate Tile Id on "+ id );
        this.solid=isSolid;
        this.emitter=isEmitter;


        tiles[id]=this;
    }

    public byte getId(){
        return id;
    }

    public boolean isSolid(){
        return solid;
    }

    public boolean isEmitter(){
        return emitter;

    }

    public abstract void render(Screen screen, Level level, int x , int y);
    
    public abstract void renderWild(Screen screen, Wilderness wild, int x , int y);

}
