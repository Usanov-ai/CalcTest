import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //Обьявляем переменные классов чисел и операций
        ArabicNumber aNums = new ArabicNumber();
        RomaNumber rNums = new RomaNumber();
        Operations operations = new Operations();
        //Инструкция для пользователя
        System.out.println("Введите строку для вычисления результата по образцу: \"a+b\", " +
                "где 'a' и 'b' ваши операнды, а '+' ваш оператор.\n" +
                "Калькулятор работает с римскими и арабскими цифрами в диапазоне от 1 до 10:");
        //Считываем строку
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        sc.close();
        //Сплитим и азабираем первые 3 элемента
        String[] numsAndOpArray = operations.splitString(in);
        //Берем колекции из классов чисел
        List<String> aNumList = aNums.getArabNums();
        List<String> rNumList = rNums.getRomNums();
        String a = numsAndOpArray[0];
        String b = numsAndOpArray[2];
        //забираем результат в зависимости от типа числа
        String result = operations.getResult(numsAndOpArray, aNumList, rNumList, a, b);
        System.out.println(result);
    }


}

