package peopleVsPeople;


public class GameProcess {
    public static void main(String[] args) {
        Field field = new Field();
        field.eraseField();
        field.showField();
        field.doChar('X');
        field.showField();
    }
}
