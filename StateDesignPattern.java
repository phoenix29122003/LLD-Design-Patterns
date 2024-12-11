interface MusicPlayerStateInterface{
    void displayMsg();
}

class PlayStateConcreteClass implements MusicPlayerStateInterface{
    public void displayMsg(){
        System.out.println("Play the music");
    }
}

class PauseStateConcreteClass implements MusicPlayerStateInterface{
    public void displayMsg(){
        System.out.println("Pause the music");
    }
}

class StopStateConcreteClass implements MusicPlayerStateInterface{
    public void displayMsg(){
        System.out.println("Stop the music");
    }
}

class MusicPlayer{
    private MusicPlayerStateInterface currentState;
    
    void setState(MusicPlayerStateInterface state){
        this.currentState=state;
    }
    void stateCommand(){
        currentState.displayMsg();
    }
}

class Main {
    public static void main(String[] args) {
        MusicPlayer myPlayer=new MusicPlayer();
        
        myPlayer.setState(new PlayStateConcreteClass());
        myPlayer.stateCommand();
        
        myPlayer.setState(new PauseStateConcreteClass());
        myPlayer.stateCommand();
        
        myPlayer.setState(new StopStateConcreteClass());
        myPlayer.stateCommand();
    }
}
