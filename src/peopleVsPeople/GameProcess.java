package peopleVsPeople;

public class GameProcess {

    private boolean endCycle = false;

    Field field = new Field();

    private void PlayersMove(int playerNumber, char X_Or_0) {
        field.showField();
        System.out.println("Progress Player" + playerNumber + "(X)");
        field.doChar(X_Or_0);
    }

    public void StartGame() {
        field.eraseField();
        do {
            PlayersMove(1, 'X');
            PlayersMove(2, '0');
        } while (!Field.endGame);     // :(
        System.out.println("End game!");
    }


}
