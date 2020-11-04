import Exceptions.DoNotHaveNeedsElementsException;
import Exceptions.IDontKnowThisOperatorException;
import Exceptions.WrongInputExceptions;

import java.util.List;

public class Operations {
    //Возвращаем результат в зависимости от типа числа
    public String getResult(String[] numsAndOpArray, List<String> aNumList, List<String> rNumList, String a, String b) {
        String result;
        //Узнаем принадлежность коллекциям
        if (aNumList.contains(a) && aNumList.contains(b)) {
            result = String.valueOf(getResult(numsAndOpArray, aNumList, a, b));
        } else if (rNumList.contains(a) && rNumList.contains(b)) {
            result = new RomaNumber().getRomanNumber(getResult(numsAndOpArray, rNumList, a, b));
        } else {
            System.out.println("Введенные данные не соотвествуют образцу: \"a+b\"");
            throw new WrongInputExceptions();
        }
        return result;
    }
    //Возвращаем результат в зависимости от оператора
    private int getResult(String[] numsAndOpArray, List<String> aNumList, String a, String b) {
        int result;
        switch (numsAndOpArray[1]) {
            case "+":
                result = (aNumList.indexOf(a) + 1) + (aNumList.indexOf(b) + 1);
                break;
            case "/":
                result = (aNumList.indexOf(a) + 1) / (aNumList.indexOf(b) + 1);
                break;
            case "*":
                result = (aNumList.indexOf(a) + 1) * (aNumList.indexOf(b) + 1);
                break;
            case "-":
                result = (aNumList.indexOf(a) + 1) - (aNumList.indexOf(b) + 1);
                break;
            default:
                throw new IDontKnowThisOperatorException();
        }
        return result;
    }

    //Сплитим строку и берем первые 3 элемента
    public String[] splitString(String in) {
        String[] tempArray = in.replace(" ", "").split("(((?<=\\W)|(?=\\W)))");
        String[] numsAndOpArray = new String[3];
        if (tempArray.length > 2) {
            for (int i = 0; i < 3; i++) {
                numsAndOpArray[i] = tempArray[i];
            }
        } else {
            try {
                throw new DoNotHaveNeedsElementsException();
            } catch (DoNotHaveNeedsElementsException e) {
                System.out.println("Недостаточно элементов");
            }
        }
        return numsAndOpArray;
    }
}
