import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.List;

class ReadFilesDemo {
    static void main() {
        try{
            readWholeFile();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void simpleRead() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/emirnurkovic/Documents/Fakultet/OOP/Predavanja_i_Labovi_JavaOOP/FileManipulations-Iterators-UnitTesting/arrayOutput"));

        System.out.println(bufferedReader.readLine());
    }

    //ovo koristis ako imas veci fajl za procitati
    public static void fullRead() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/emirnurkovic/Documents/Fakultet/OOP/Predavanja_i_Labovi_JavaOOP/FileManipulations-Iterators-UnitTesting/arrayOutput"));
        String tempString;

        while((tempString = bufferedReader.readLine()) != null){
            System.out.println(tempString);
        }

        bufferedReader.close();
    }

    //ovo koristis kad su manji fajlovi to jeste velicina fajla manja i ima manje stvari za citati jer ovaj overloada ram
    public static void readWholeFile() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/emirnurkovic/Documents/Fakultet/OOP/Predavanja_i_Labovi_JavaOOP/FileManipulations-Iterators-UnitTesting/arrayOutput"));

        List<String> lineList = bufferedReader.lines().collect(Collectors.toList());

        for(String line : lineList){
            System.out.println(line);
        }

        bufferedReader.close();
    }
}
