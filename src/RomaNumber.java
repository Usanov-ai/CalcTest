import java.util.List;

import static java.util.Collections.nCopies;

public class RomaNumber {
    private  List<String> romNums = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

    //Переводим в римское число
    public String getRomanNumber(int number) {
        return String.join("", nCopies(number, "I"))
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C");
    }
    public List<String> getRomNums() {
        return romNums;
    }
}
