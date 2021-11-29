package corejava.v1ch03;

public class Example2 {
    public static void main(String[] args) {
        names();
        vars();
        consts();
        enums();
    }

    private static void names() {
        int test;
        int тест;

        // Зарезервированные слова запрещены в наименовании переменных
        //int do;

        // Разрешаются буквы (в том числе из Юникода), цифры, _, $. Наименование не должно начинаться с цифры.
        // $ и _ не рекомендуются применять в имени переменной.
        // $ используется компилятором, а _ может в будущем стать метасимволом
        int abcABC123абвАБВ_$;

        // Начиная с Java 9 единственный символ _ запрещён в имени переменной
        // int _;

        // Как можно проверить, что символ допустим в имени переменной
        System.out.println(Character.isJavaIdentifierStart('1'));
        System.out.println(Character.isJavaIdentifierPart('1'));
    }

    private static void vars() {
        int vacationDays;
        // Ошибка! Переменная не инициализирована
        // System.out.println(vacationDays);

        // var был добавлен в Java 10
        var workDays = 12;      // тип int
        var greeting = "Hello"; // Тип String
    }

    private static void consts() {
        final double CM_PER_INCH = 2.54;    // Константа
        double paperWidth = 8.5;
        double paperHeight = 11;
        System.out.println(
                "Paper size in centimeters: " + paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH
        );
    }

    private static void enums() {
        Size size1 = Size.EXTRA_LARGE;
        Size size2 = null;

        System.out.println(size1);
        System.out.println(size2);
    }
}

// Перечисление
enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE }