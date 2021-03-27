public class Game {
    public String[] playerschoice = new String[2];

    public void player_input(int player_number,String choice){
        if(player_number != 1 && player_number != 0){
            throw new IllegalArgumentException("Bad Player!");
        }

        playerschoice[player_number] = choice;

        if(!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissors")){
            throw new IllegalArgumentException("Bad Choice!");
        }
    }

    public String who_win(){
        if(playerschoice[0].equals(playerschoice[1])){
            return "Draw!";
        }
        if(playerschoice[0].equals("rock") && playerschoice[1].equals("paper")){
            return "Player 2 win!";
        }
        if(playerschoice[0].equals("scissors") && playerschoice[1].equals("rock")){
            return "Player 2 win!";
        }
        if(playerschoice[0].equals("paper") && playerschoice[1].equals("scissors")){
            return "Player 2 win!";
        }
        return "Player 1 win!";
    }
}
