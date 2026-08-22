interface AttackStrategy{
    void attack();
}

class SwordAttack implements AttackStrategy{
    @Override
    public void attack(){
        System.out.println("Swinging a heavy steel sword!");
    }
}

class BowAttack implements AttackStrategy{
    @Override
    public void attack(){
        System.out.println("Shooting an arrow from afar!");
    }
}

class MagicAttack implements AttackStrategy{
    @Override
    public void attack(){
        System.out.println("Casting a powerful fireball spell!");
    }
}

class Hero{
    private AttackStrategy attackStrategy;

    public void setAttackStrategy(AttackStrategy attackStrategy){
        this.attackStrategy = attackStrategy;
    }

    public void attack(){
        if(attackStrategy == null){
            System.out.println("Hero has no weapon equiped");
            return;
        }
        attackStrategy.attack();
    }
}
