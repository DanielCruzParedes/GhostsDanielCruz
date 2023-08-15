package ghosts;
    import java.util.Comparator;

public class Usuarios {
    
    private String user;
    private String contrasena;
    private int puntos;
    private String logs;
    
    
    public Usuarios(String user, String contrasena, int puntos, String logs){
        this.user=user;
        this.contrasena=contrasena;
        this.puntos=puntos;
        this.logs=logs;
    }
    public static class UsuarioComparator implements Comparator<Usuarios> {
        @Override
        public int compare(Usuarios usuario1, Usuarios usuario2) {
            return Integer.compare(usuario2.getPuntos(), usuario1.getPuntos());
        }
    }

    
    public void setUser(String user){
    this.user=user;
    }
    
    public String getUser(){
        return user;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena=contrasena;
    }
    public String getContrasena(){
        return contrasena;
    }
    public void setPuntos(int puntos){
        this.puntos=this.puntos+puntos;
    }
    public int getPuntos(){
        return puntos;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public String getLogs() {
        return logs;
    }
    
    
    


}



