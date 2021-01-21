import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Loader {
    private ArrayList<User> data = new ArrayList();
    public void input(){
        try{
            FileInputStream fileInputStream = new FileInputStream("Data.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            data = (ArrayList<User>) objectInputStream.readObject();
        }
        catch(Exception e){
            System.out.println("No se ha encontrado el archivo, se creara uno nuevo");
        }
    }
    public void output(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("Data.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch(Exception e){
            System.out.println("Error al guardar los datos");
        }
    }
    public void newOpponent(User user) { data.add(user); }
    public ArrayList<User> getOpponents(){ return data; }
}