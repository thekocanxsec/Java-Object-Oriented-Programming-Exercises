interface State {
    void pressPlay(AudioPlayer player);
}

class PlayingState implements State{
    @Override
    public void pressPlay(AudioPlayer player){
        System.out.println("Music is playing. Pausing the music...");

        player.setState(new PausedState());
    }
}

class PausedState implements State{
    @Override
    public void pressPlay(AudioPlayer player){
        System.out.println("Music is paused. Resuming playback...");
        player.setState(new PlayingState());
    }
}

class AudioPlayer{
    private State currentState;

    public AudioPlayer(){
        this.currentState = new PausedState();
    }

    public void setState(State state){
        this.currentState = state;
    }

    public void pressPlayButton(){
        currentState.pressPlay(this);
    }
}

class MainStateTest{
    static void main() {
        AudioPlayer player = new AudioPlayer();

        player.pressPlayButton();

        player.pressPlayButton();

        player.pressPlayButton();
    }
}
