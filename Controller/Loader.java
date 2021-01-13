package Controller;

import Model.*;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Loader implements DavpdDAO {
    private ArrayList<Davpd> data = new ArrayList();
    public void input(){
        try{
            FileInputStream fileInputStream = new FileInputStream("Data.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            data = (ArrayList<Davpd>) objectInputStream.readObject();
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
    public void test(){
        data.add(new Bernoulli("a", "b", "c", "d", "e", 0.55));
    }
    @Override
    public void loadDavpd(Davpd davpd){
        for (int i = 0; i< data.size(); i++) {
            if(davpd.getClass().getSimpleName() == data.get(i).getClass().getSimpleName()){
                davpd = data.get(i);
                return;
            }
        }
    }
}