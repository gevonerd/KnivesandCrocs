public class Sprite {

    private static String chars ="1234" ;
            
          

    public static void render(String direction, Screen screen, int x, int y, int color){
        


        for (int i = 0; i < direction.length(); i++){
            int charIndex = chars.indexOf(direction.charAt(i));
            if (charIndex >= 0) screen.render(x + (i * 8), y, charIndex + 26 * 32, color);
        }
    }
}