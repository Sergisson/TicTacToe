package peopleVsPeople;

import java.util.Scanner;

public class Field {

    private static final char DEFAULT_CELL_VALUE = ' ';

    private static final int DEFAULT_FIELD_SIZE = 3;

    private static final int MAX_FIELD_SIZE = 100;

    private static final int MIN_FIELD_SIZE = 0;

    private int fieldSize = DEFAULT_FIELD_SIZE;

    private char[][] field;

    private boolean endCycle = false;

    Scanner sc = new Scanner(System.in); // создаём объект класса Scanner для ввода данных

    public Field() {
        this(DEFAULT_FIELD_SIZE);
    }

    public Field(int size) {
        do {
            System.out.print("Please enter the size of the game (square) of the field: ");//Пожалуйста, введите размер игрового поля (игровое поле квадратное)

            if (sc.hasNextInt()) {  // возвращает истинну если с потока ввода можно считать целое число
                size = sc.nextInt();// считывает целое число с потока ввода и сохраняем в переменную
            } else {
                System.out.println("Error, please enter an integer");
            }

            if (size < MAX_FIELD_SIZE && size > MIN_FIELD_SIZE) {
                fieldSize = size;
                endCycle = true;
            } else {
                System.out.println("Error, please enter another dimension value that is in the range of 0 to 100");
            }

        } while (!endCycle);
        field = new char[fieldSize][fieldSize];
    }

    public void eraseField() {
        for (int i = 0; i < fieldSize; i++) {
            for (int i2 = 0; i2 < fieldSize; i2++) {
                field[i][i2] = DEFAULT_CELL_VALUE;
            }
        }
    }

    private void showCell(int x, int y) {
        System.out.print("[" + field[x][y] + "]");
    }

    public void showField() {
        System.out.println("y");
        System.out.println("^");
        for (int i = 0; i < fieldSize; i++) {
            System.out.print("|");
            for (int i2 = 0; i2 < fieldSize; i2++) {
                showCell(i, i2);
            }
            System.out.println();
        }
        System.out.print("0");
        for (int i = 0; i < fieldSize; i++) {
            System.out.print("---");
        }
        System.out.println(">x");
    }

    public void doChar(char x_Or_0) {
        int x = 0;
        int y = 0;
        do {
            System.out.print("Make a move, select the field and write it on the coordinate axis x, and press Enter: "); //Сделай ход, выберите поле и напишите его координату по оси x, и нажмите "Enter".
            if (sc.hasNextInt()) {
                x = sc.nextInt() - 1;
            } else {
                System.out.println("Error, please enter an integer");
            }
            System.out.print("And now, write it on the coordinate axes and, and press Enter: "); //А теперь напишите его координату по оси и и нажмите "Enter".
            if (sc.hasNextInt()) {
                y = sc.nextInt() - 1;
            } else {
                System.out.println("Error, please enter an integer");
            }
            if (field[x][y] == ' ') {
                field[x][y] = x_Or_0;
                endCycle = true;
            } else {
                System.out.println("Error, this cell is already occupied"); //Ошибка, данная клетка уже занята
            }

        } while (!endCycle);
    }
}