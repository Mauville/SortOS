package SortOS;
import java.io.*;

public class MovieFactory{
    public static void main(String[] args){
        try{
            Movie m = new Movie();
            m.setTitle("Avengers");
            m.setDirector("Russeau");
            m.setYear("2019");
            m.setDuration("3:01");
            m.setClassification("G");

            FileOutputStream fos = new FileOutputStream("movies.oop");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(m);
            oos.close();
        }
        catch (FileNotFoundException fe ){
            System.out.println("File does not exist");
        }
        catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

}
