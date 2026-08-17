import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class WriteDemo{
    static void main() {
        try{
            simpleWriter("test");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void simpleWriter(String text) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/emirnurkovic/Documents/Fakultet/OOP/Predavanja_i_Labovi_JavaOOP/FileManipulations-Iterators-UnitTesting/output.txt"));

        bufferedWriter.write("Our first line \n");
        bufferedWriter.write(text + "\n");
        bufferedWriter.write(text + "\n");
        bufferedWriter.close();

    }
}