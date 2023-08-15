package ghosts;

import java.util.ArrayList;


public class Player {
    public int turno;
    GhostGame gg;
    private String text;
    public boolean modoTutorial;
    Player player;
    public String usuarioLogeado;
    public String segundoPlayer;
    ArrayList<Usuarios>listaUsuarios;
    public int totalUsuariosActivos;
    public int totalUsuariosHistoricos;
    public int contadorFantasmasBuenos1;
    public int contadorFantasmasMalos1;
    public int contadorFantasmasBuenos2;
    public int contadorFantasmasMalos2;
    public String logs="";
    String dificultad="NORMAL";
    String modo;
    
    public Player(){
       listaUsuarios=new ArrayList<>();
       this.player=this;
    }
    
    //Recursividad
    public Usuarios buscarUsuario(String nombreUser, int i) {
    if (i >= listaUsuarios.size()) {
        return null;
    }

    Usuarios usuario = listaUsuarios.get(i);
    if (usuario != null && usuario.getUser().equals(nombreUser)) {
        return usuario; 
    }
    return buscarUsuario(nombreUser, i + 1);
}
    
     //Recursividad
    public Usuarios getContra(String nombreUser, int i){
        if(i>= listaUsuarios.size()){
            return null;
        }
        
            Usuarios usuario = listaUsuarios.get(i);
            Usuarios contra = listaUsuarios.get(i);
        if(usuario != null && usuario.getUser().equals(nombreUser)){
            return contra;
        }
        return getContra(nombreUser, i+1);
    }
    
    public boolean agregarUsuario(Usuarios usuario){
        Usuarios aux = buscarUsuario(usuario.getUser(),0);
        
        if(aux==null){
            listaUsuarios.add(usuario);
            return true;
        }
        return false;
        
    }
    public void agregarPuntosAlUsuario(String nombreUser, int puntosPorAgregar){
        buscarUsuario(nombreUser,0);
    }
    
    public void eliminarCuenta(String nombreuser){
        listaUsuarios.remove(this.buscarUsuario(usuarioLogeado,0));
    }
    
    
    
    
    
}
