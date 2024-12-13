import java.util.*;

interface FighterProtoType{
    FighterProtoType clone();
}

class Warrior implements FighterProtoType{
    private int warriorHealth;
    private List<String>warriorSkills=new ArrayList<>();
    
    public Warrior(int health,List<String>skills){
        this.warriorHealth=health;
        this.warriorSkills=new ArrayList<>(skills);;
    }
    
    public void setHealth(int health){
        this.warriorHealth=health;
    }
    
    public void addSkill(String skill){
        this.warriorSkills.add(skill);
    }
    
    public FighterProtoType clone(){
        return new Warrior(this.warriorHealth,this.warriorSkills);
    }
    
    public void display(){
        System.out.println("Warrior Health: "+warriorHealth);
        System.out.print("Warrior Skills: ");
        for(String skill:warriorSkills){
            System.out.print(skill+" ");
        }
        System.out.println();
    }
}

class Mage implements FighterProtoType{
    private int mageIntelligence;
    private List<String>mageSkills=new ArrayList<>();
    
    public Mage(int intelli,List<String>skills){
        this.mageIntelligence=intelli;
        this.mageSkills=new ArrayList<>(skills);;
    }
    
    public void setIntelligence(int intelli){
        this.mageIntelligence=intelli;
    }
    
    public void addSkill(String skill){
        this.mageSkills.add(skill);
    }
    
    public FighterProtoType clone(){
        return new Mage(this.mageIntelligence,this.mageSkills);
    }
    
    public void display(){
        System.out.println("Mage Intelligence: "+mageIntelligence);
        System.out.print("Mage Skills: ");
        for(String skill:mageSkills){
            System.out.print(skill+" ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        FighterProtoType warrior=new Warrior(100,Arrays.asList("Sword Slash", "Shield Block"));
        FighterProtoType mage=new Mage(200,Arrays.asList("Fireball", "Teleport"));
        
        Warrior warriorClone=(Warrior)warrior.clone();
        warriorClone.setHealth(150);
        warriorClone.addSkill("Berserk");
        
        Mage mageClone=(Mage)mage.clone();
        mageClone.setIntelligence(250);
        mageClone.addSkill("Teleport");
        
        System.out.println("Original Warrior: ");
        ((Warrior) warrior).display();
        
        System.out.println("Original Mage: ");
        ((Mage) mage).display();
        
        System.out.println("Cloned Warrior: ");
        warriorClone.display();
        
        System.out.println("Cloned Mage: ");
        mageClone.display();
    }
}
