import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class WriteArray {
    static void main() {
        String[] arrayTest = {"Imran", "Tarik", "Esad"};

        try{
            ArrayWriter(arrayTest);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void ArrayWriter(String[] data) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/emirnurkovic/Documents/Fakultet/OOP/Predavanja_i_Labovi_JavaOOP/FileManipulations-Iterators-UnitTesting/arrayOutput"));

        for(String row : data){
            bufferedWriter.write(row + "\n");
        }

        bufferedWriter.close();
    }
}
