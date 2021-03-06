public class Main01 {
    public static void main(String[] args) {
        runCode();
        // ожидаемый результат:
        // fourletters(names) = 2
    }

    /**
     * Реализуйте метод fourLetters
     */
    public static int fourLetters(String names) {
        // Напишите ваш код здесь...
        String[] namesArray = names.split("[\\s,.]+");
        int result = 0;
        for (String name:namesArray) {
            if (name.length() == 4) {
                result++;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void runCode() {
        // Данный метод будет вызван из метода main
        // Вы можете писать здесь произвольный код для дебага вашего кода
        String names = "Tror Gvigris Deriana Nori";
        System.out.println("fourletters(names) = " + fourLetters(names));
    }
}
