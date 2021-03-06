import java.util.*;

public class Main02 {
    public static void main(String[] args) {
        runCode();
    }

    /**
     * Реализуйте метод getTotalTime
     */
    public static int getTotalTime(List<Integer> heroes, int n) {
        // Напишите ваш код здесь...
        int result = 0;
        if (n == 1) {
            for (int hero : heroes) {
                result = result + hero;

            }
        } else if (n >= heroes.size()) {
            Collections.sort(heroes);
            result = heroes.get(heroes.size() - 1);

        } else if (n != heroes.size()) {
            int[] heroesArray = heroes.stream().mapToInt(i -> i).toArray();
            int[] fightArray = new int[n];
            int h = 0;  // счетчик героев
            int k = 0; // счетчик итераций

            //*********** печатаем шапку**************
            System.out.print("Iteration" + "\t");
            for (int j = 0; j < n; j++) {
                System.out.print("Centaur" + j + "\t");
            }
            System.out.println();

            // 1я итерация, заполняем массив кентавров героями
            System.out.print(k + "\t" + "\t" + "\t");
            for (int j = 0; j < n; j++) {
                fightArray[j] = heroesArray[h];
                h++;
                System.out.print(fightArray[j] + "\t" + "\t" + "\t");
            }

            // и находим максимальное значение времени героя в этом массиве
            // запоминаем его индекс
            int maximumValue = maxIndex(fightArray)[0];
            int maximumIndex = maxIndex(fightArray)[1];

            System.out.println("\t" + "Время боя = " + maximumValue + " у героя номер " + maximumIndex);

            //  в цикле отсчитываем итерации по оставшемуся времени
            while (sumArray(fightArray) > 0) { //пока не закончатся герои

                for (int j = 0; j < n; j++) { // пробегаем по арене с кентаврами и проверяем нет ли погибшего героя,
                    // у которого время боя = 0
                    if (fightArray[j] == 0) {
                        // если такой герой есть, то смотрим, можем ли его заменить следующим героем из неигравших
                        if (h < heroes.size()) {
                            // и добавляем героя на арену к кентаврам
                            fightArray[j] = heroesArray[h];
                            h++;
                        }
                        // выводим на печать значения времени на арене
                        System.out.print(k + "\t" + "\t" + "\t");
                        for (int m = 0; m < n; m++) {
                            System.out.print(fightArray[m] + "\t" + "\t" + "\t");
                        }
                        System.out.println();
                    }
                }
                k++;  // увеличиваем счетчик затраченного на бой времени
                System.out.print(k + "\t" + "\t" + "\t");

                // далее отнимаем у всех игроков арены по единице времени и все повторяется сначала
                for (int j = 0; j < n; j++) { // пробегаем по массиву кентавров и уменьшаем на 1 единицу время героев
                    if (fightArray[j] > 0) {
                        fightArray[j] = fightArray[j] - 1;
                    }
                    System.out.print(fightArray[j] + "\t" + "\t" + "\t");
                }
                System.out.println();

                result = k;
            }
            result -= 1;
        }
        return result;
    }

    //************** нахождение максимума и индекса максимального элемента в массиве
    public static int[] maxIndex(int[] array) {

        int maximum = array[0];
        int maxIndex = 0;

        for (int i = 0; i < array.length; i++)
            if (maximum < array[i]) {
                maximum = array[i];
                maxIndex = i;
            }
        int[] resultMax = {maximum, maxIndex};
        return resultMax;
    }

    //************** нахождение суммы элементов в массиве
    public static int sumArray(int[] array) {

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    public static void runCode() {
        // Данный метод будет вызван из метода main
        // Вы можете писать здесь произвольный код для дебага вашего кода
        List<Integer> heroes = new ArrayList<>();
        heroes.add(11);
        heroes.add(3);
        heroes.add(5);
        heroes.add(6);
        heroes.add(1);
        heroes.add(4);
        heroes.add(5);
        heroes.add(7);
        heroes.add(1);
        heroes.add(1);
        System.out.println("total_time --> " + getTotalTime(heroes, 4));
    }
}
