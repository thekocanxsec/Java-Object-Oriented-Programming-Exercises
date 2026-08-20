class AbstractFactory {
}


interface Sofa{
    void sit();
}

interface Table{
    void put();
}


class ModernSofa implements Sofa{
    @Override
    public void sit(){
        System.out.println("We sat on MODERN sofa");
    }
}

class ModernTable implements Table{
    @Override
    public void put(){
        System.out.println("We put things on MODERN table");
    }
}

class IndustrialSofa implements Sofa{
    @Override
    public void sit(){
        System.out.println("We sat on INDUSTRIAL sofa");
    }
}

class IndustrialTable implements Table{
    @Override
    public void put(){
        System.out.println("We put things on INDUSTRIAL table");
    }
}

interface FurnitureFactory{
    Sofa createSofa();
    Table createTable();
}

class ModernFurnitureFactory implements FurnitureFactory{
    public Sofa createSofa(){
        return new ModernSofa();
    }

    public Table createTable(){
        return new ModernTable();
    }
}

class IndustrialFurnitureFactory implements FurnitureFactory{
    public Sofa createSofa(){
        return new IndustrialSofa();
    }
    public Table createTable(){
        return new IndustrialTable();
    }
}

class MainRun4{
    static void main() {
        FurnitureFactory furniture = new ModernFurnitureFactory();

        Sofa sofa = furniture.createSofa();
        Table table = furniture.createTable();

        sofa.sit();
        table.put();

    }
}