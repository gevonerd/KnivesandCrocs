public class Player {

    private static String dir ="1234" ;
    public InputHandler input; 
    private Screen screen;
    

    public static void render(String direction, Screen screen, int x, int y, int color){
        for (int i = 0; i < direction.length(); i++){
            int charIndex = dir.indexOf(direction.charAt(i));
            if (charIndex >= 0) screen.render(x + (i * 8), y, charIndex + 27 * 32, color);
        }
    }
}