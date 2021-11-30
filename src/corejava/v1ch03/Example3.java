package corejava.v1ch03;

public class Example3 {
    public static void main(String[] args) {
        arithmetic();
        maths();
        types();
        incAndDec();
        bitwiseLogicalOperators();
        priority();
    }

    // strictfp - гарантирует одинаковые результаты арифметических операций с плавающей запятой на разных процессорах.
    // Минус: потеря производительности. Был введён в Java 2.
    // В Java 17 потерял свою значимость, т.к. режим sctrictfp стал работать всегда.
    // Может применяться для всего класса.
    private static strictfp void arithmetic() {
        System.out.println("Арифметические операции");
        System.out.println(15 / 2);     // 7
        System.out.println(15.0 / 2);   // 7.5
        System.out.println(15 / 2.0);   // 7.5

        // System.out.println(5 / 0);   // Вызовет исключение
        System.out.println(5.0 / 0);    // Infinity
    }

    private static void maths() {
        System.out.println("Класс Math");
        System.out.println(Math.sqrt(4));   // Корень квадратный из 4
        System.out.println(Math.pow(2, 3)); // 2 в 3 степени

        System.out.println("Проблема целочисленного деления с остатками");
        System.out.println(5 % 2);                  // 1
        System.out.println(-5 % 2);                 // -1
        // Поведение floorMod более правильное с математической точки зрения
        System.out.println(Math.floorMod(5, 2));    // 1
        System.out.println(Math.floorMod(-5, 2));   // 1
        System.out.println(Math.floorMod(5, -2));   // -1

        // Гарантирует идентичность результатов на всех платформах
        System.out.println("Класс StrictMath");
        System.out.println(StrictMath.sqrt(4));

        System.out.println("Переполнение");
        System.out.println(1_000_000_000 * 3);      // -1294967296
        try {
            System.out.println(Math.multiplyExact(1_000_000_000, 3));
        } catch (ArithmeticException e) {
            System.err.println("Произошло переполнение");
        }
    }

    private static void types() {
        /*
            В бинарной операции числа преобразовываются по следующим правилам в заданном порядке:
            1. если хотя бы один из операндов double, то второй в double;
            2. если хотя бы один из операндов float, то второй в float;
            3. если хотя бы один из операндов long, то второй в long;
            4. оба в int.
         */

        /*
            Допустимые преобразования числовых типов:
            byte -> short -> int -> long
                     char -> int
            int -> float    long -> float
            int -> double   long -> double

            Будет потеря точности в следующих случаях:
            int -> float    long -> float/double
         */

        System.out.println("Приведение типов");
        // Приведение типов (с возможной потерей данных)
        double x = 9.997;
        System.out.println((int) x);                // 9
        System.out.println((int) Math.round(x));    // 10

        System.out.println("Выход за пределы диапазона допустимых значений");
        System.out.println((byte) 300); // 44

        System.out.println(Math.round(9e150));  // 9223372036854775807  (Long.MAX_VALUE)

        // Сочетание арифметических операций с присваиванием
        System.out.println("Арифметические операции с присваиванием");
        int n = 4;
        n += 3.5;   // n = (int) (n + 3.5)
        System.out.println(n);  // 7
    }

    private static void incAndDec() {
        System.out.println("++ --");
        int i = 1;
        int j = 2;
        int c = i++ + ++j + ++i + j++;
        System.out.println(c);
    }

    private static void bitwiseLogicalOperators() {
        // &    И
        // |    ИЛИ
        // ^    исключающее ИЛИ
        // ~    НЕ

        // <<   сдвиг влево
        // >>   сдвиг вправо
        // >>>  сдвиг вправо с сохранением знака

        int x = -1;
        System.out.println(x >> 1);     // -1
        System.out.println(x >>> 1);    // 2147483647

        // В поразрядном сдвиге правая часть сокращается по модулю 32, для типа long - 64
        System.out.println(1 << 35);    // 8 (1 << 3)
    }

    private static void priority() {
        int i = 1;
        System.out.println(++i + --i);  // 3
    }
}
