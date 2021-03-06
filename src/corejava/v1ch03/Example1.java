package corejava.v1ch03;

public class Example1 {
    public static void main(String[] args) {
        nums();
        chars();
    }

    public static void nums() {
        // Длинные целые числа указываются с суффиксом L
        long longNum = 400000000000000000L;

        // 16-ая запись числа: 0x...
        int num16 = 0xCAFE;

        // 8-ая запись числа: 0...
        int num8 = 010;

        // 2-ая запись числа (с Java 7): 0b...
        int num2 = 0b1001;

        // С Java 7
        int num = 1_000_000;

        float floatNum = 3.14f;
        double doubleNum1 = 3.14;
        double doubleNum2 = 3.14d;

        // 16 * 2^(-3) = 2.0
        double doubleNum3 = 0x10p-3;

        // 10 * 10^(-3) = 0.01
        double doubleNum4 = 10e-3;
    }

    // \u00A0 Ошибки никакой не будет
    public static void chars() {
        // Получится пустая строка ("" + ""), т.к. управляющие последовательности символов в Юникоде
        // обрабатываются перед синтаксическим анализом кода
        System.out.println("\u0022+\u0022");

        /*
            Кодировка в Юникоде (Unicode). Была разработана в 1991 году.
            Всего допускалось 65536 символов. Скоро этот резерв был исчерпан.
            Юникод 2.0 (1996) ввёл суррогатные пары для преодоления этого предела. Поддержка появилась в Java 5.

            Кодовая точка - значение, связанное с символом в кодировке. Записываются в 16-ой форме с префиксом U+.
            Пример: латинская буква 'A' - U+0041.

            Кодовые точки объединены в 17 кодовых плоскостей.
            Первая кодовая плоскость называется основной многоязыковой плоскостью или базовой плоскостью.
            Содержит кодовые точки: U+0000 .. U+FFFF.
            Остальные 16 - дополнительные плоскости. Содержит кодовые точки: U+10000 .. U+10FFFF.

            Кодировка UTF-16 - способ представления в Юникоде всех кодовых точек кодом переменной длины.
            Символы из основной многоязыковой плоскости кодируются двумя байтами (кодовая единица).
            Дополнительные символы (из дополнительных плоскостей) - двумя кодовыми единицами. Эти две кодовые единицы
            попадают в область 2048 неиспользуемых значений (область подстановки) из базовой плоскости.
            Первая кодовая единица использует значения U+D800 .. U+DBFF, вторая кодовая единица - U+DC00 .. U+DFFF.

            Тип char описывает кодовую единицу.
         */
        char chA = '\u0041';
        System.out.println(chA);
    }
}
