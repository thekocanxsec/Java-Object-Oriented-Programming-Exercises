import java.util.Optional;

record Wolf(String name, int age){

}

class WolfRegistry{
    public Optional<Wolf> findWolfByName(String name){
        if(name.equalsIgnoreCase("Huskey")){
            return Optional.of(new Wolf("Huskey", 14));
        }
        return Optional.empty();
    }
}

class MainRun5{
    static void main() {
        WolfRegistry registry = new WolfRegistry();

        registry.findWolfByName("Huskey").ifPresent(wolf -> System.out.println("Pronadjen vuk pod imenom: " + wolf.name()));
        Wolf fallbackWolf = registry.findWolfByName("Alfa")
                .orElse(new Wolf("Nepoznati Vuk", 0));

        System.out.println("Rezultat 2: " + fallbackWolf.name());

        Wolf missingWolf = registry.findWolfByName("Ghost")
                .orElseThrow(() -> new RuntimeException("Greška: Traženi vuk ne postoji!"));
    }
}
