package Model; // неправильное именование пакета
import com.example.controller.Controller;

public class CheckWin {
    public boolean checkWin(char ch) { // нужно завести енамку пох крестики и нолики
        // нельзя ссылаться на статические поля контроллера
        if (Controller.field[0][0] == ch && Controller.field[0][1] == ch && Controller.field[0][2] == ch)
            return true;
        if (Controller.field[1][0] == ch && Controller.field[1][1] == ch && Controller.field[1][2] == ch)
            return true;
        if (Controller.field[2][0] == ch && Controller.field[2][1] == ch && Controller.field[2][2] == ch)
            return true;
        if (Controller.field[0][0] == ch && Controller.field[1][0] == ch && Controller.field[2][0] == ch)
            return true;
        if (Controller.field[0][1] == ch && Controller.field[1][1] == ch && Controller.field[2][1] == ch)
            return true;
        if (Controller.field[0][2] == ch && Controller.field[1][2] == ch && Controller.field[2][2] == ch)
            return true;
        if (Controller.field[0][0] == ch && Controller.field[1][1] == ch && Controller.field[2][2] == ch)
            return true;
        if (Controller.field[2][0] == ch && Controller.field[1][1] == ch && Controller.field[0][2] == ch)
            return true;
        return false;
    }

}