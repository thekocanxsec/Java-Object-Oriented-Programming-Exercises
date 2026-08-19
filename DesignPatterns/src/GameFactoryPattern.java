
interface Weapon {
    void useWeapon();
}

interface Armor {
    void protect();
}

class Sword implements Weapon {
    @Override
    public void useWeapon() {
        System.out.println("Swinging a sharp steel sword!");
    }
}

class MagicShield implements Armor {
    @Override
    public void protect() {
        System.out.println("Blocking with a glowing magic shield!");
    }
}

class LaserGun implements Weapon {
    @Override
    public void useWeapon() {
        System.out.println("Shooting a plasma laser gun!");
    }
}

class EnergyShield implements Armor {
    @Override
    public void protect() {
        System.out.println("Activating high-tech energy shield!");
    }
}


interface GameFactory {
    Weapon createWeapon();
    Armor createArmor();
}


class FantasyGameFactory implements GameFactory {
    @Override
    public Weapon createWeapon() {
        return new Sword();
    }

    @Override
    public Armor createArmor() {
        return new MagicShield();
    }
}

class SciFiGameFactory implements GameFactory {
    @Override
    public Weapon createWeapon() {
        return new LaserGun();
    }

    @Override
    public Armor createArmor() {
        return new EnergyShield();
    }
}