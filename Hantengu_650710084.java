public class Hantengu_650710084 {
    public void main(String[] args) {
        Hantengu htg = new Hantengu();
        ScaredHantengu scaredH = new ScaredHantengu(); 
        
        scaredH.abilities();
        AngryHantengu angryH = new AngryHantengu();
        angryH.abilities();
        
        RelishHantengu relishH = new RelishHantengu();
        relishH.abilities();
        
        SadHantengu sadH = new SadHantengu();
        sadH.abilities();
        
        HappyHantengu happyH = new HappyHantengu();
        happyH.abilities();
        
        if (angryH.absorbed()){
            HatefulHantengu hateH = new HatefulHantengu();
            hateH.transforms(scaredH);
        }
        if (scaredH.getAlive().equalsIgnoreCase("died")){
            System.out.print("Not died ");
            htg = new AngryHantengu();
            htg = new RelishHantengu();
            htg = new SadHantengu();
            htg = new HappyHantengu();
        }
    }
    class Hantengu{
    
        public Hantengu(){
            System.out.println("Hantengu มาแล้ว!");
        }
        public void abilities(){};
    }
    
    class ScaredHantengu extends Hantengu{

        private String alive;

        public ScaredHantengu(){
            this.alive = "alive";
        }
        public void abilities(){
            System.out.println("Hantengu uses blood demon magic to create four clones and almost completely erase his own aura. It's the ultimate in escapism.");
        }

        public void setAlive(String alive){
            this.alive = alive;
        }

        public String getAlive(){
            return alive;
        }
    }
    
    class HappyHantengu extends Hantengu{

        private boolean eaten = false;
        public void abilities(){
            System.out.println("Urami creates intense sound waves. Used to attack enemies unconscious. And can fly with the wings on the back.");
        }

        public void setEaten(boolean eaten){
            this.eaten = eaten;
        }

        public boolean getEaten(){
            return eaten;
        }
    }
    
    class AngryHantengu extends Hantengu{

        private RelishHantengu rHantengu;
        private SadHantengu sadHantengu;
        private HappyHantengu hHantengu;

        public void abilities(){
            System.out.println("Sekido creates a bolt of lightning that paralyzes enemies. Attack in a wide area But it cannot flow through those that have the same cell like other clones. This body also has the ability to absorb people.");
        }

        public boolean absorbed(){
            try {
                if (rHantengu.getEaten() && sadHantengu.getEaten() && hHantengu.getEaten()){
                    return true;
                }
                else {
                    return false;
                } 
            } catch(Exception e){
                return false;
            }
        }
    }
    
    class RelishHantengu extends Hantengu{
    
        private boolean eaten = false;
        public void abilities(){
            System.out.println("Karaku creates violent winds and storms from his fan-shaped weapons. Therefore, if anyone holds the fan, they will be able to use the same power.");
        }

        public void setEaten(boolean eaten){
            this.eaten = eaten;
        }

        public boolean getEaten(){
            return eaten;
        }
    }
    
    class HatefulHantengu extends Hantengu{
    
        private AngryHantengu aHantengu;

        public void abilities(){
            System.out.println("Zohakuten uses every power of his four bodies in a form that is exponentially stronger. You can also use the unique Blood Demon Mantra. “Endless Danger Dragon” which can cause death at the Pillar level.");
        }

        public void transforms(ScaredHantengu sHantengu){
            if (aHantengu.absorbed()){
                if (sHantengu.getAlive().equalsIgnoreCase("died")){
                    new HatefulHantengu();
                }
                else if (sHantengu.getAlive().equalsIgnoreCase("alive")){
                    System.out.println("Main body is not dead yet.");
                }
            }
        }
    }
    
    class SadHantengu extends Hantengu{
    
        private boolean eaten = false;
        public void abilities(){
            System.out.println("Aizetsu uses his spear to create a long-range attack wave.");
        }

        public void setEaten(boolean eaten){
            this.eaten = eaten;
        }

        public boolean getEaten(){
            return eaten;
        }
    }
}
