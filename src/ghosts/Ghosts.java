package ghosts;

public class Ghosts {
    
    
    public static void main(String[] args) {
    Player player = new Player();
    Login login = new Login(player);
    MenuDeInicio menudeinicio = new MenuDeInicio(login, player);
    menudeinicio.setVisible(true);
    

    }
    
}
