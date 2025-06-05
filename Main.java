import java.util.Scanner;

public class Main {
    public static void variantUser() {
        System.out.println("Выберите операцию и введите ее номер:");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать систему налогооблажения");
    }

    public static int taxEarningMinusSpendings(int earnings, int spendings) {
        int taxEMS = (earnings - spendings) * 15 / 100;
        if (taxEMS >= 0) {
            return taxEMS;
        } else {
            return 0;
        }
    }

    public static int taxEarning(int earnings) {
        int taxE = (earnings) * 6 / 100;
        if (taxE >= 0) {
            return taxE;
        } else {
            return 0;
        }
    }

    public static int earnings = 0; // доход
    public static int spendings = 0; // расход
    public static int taxE;
    public static int taxEMS;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            variantUser();
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода: ");
                    String income = scanner.nextLine();
                    int money1 = Integer.parseInt(income);
                    earnings += money1;
                    break;
                case 2:
                    System.out.println("Введите сумму рахода: ");
                    String consumption = scanner.nextLine();
                    int money2 = Integer.parseInt(consumption);
                    spendings += money2;
                    break;
                case 3: // расчитывается все что мы напрописывали ранее
                    taxEMS = taxEarningMinusSpendings(earnings, spendings);
                    taxE = taxEarning(earnings);
                    if (taxE < taxEMS) {
                        System.out.println("Мы советуем Вам УСН: Доходы");
                        System.out.println("Ваш налог составит: " + taxE + " рублей");
                        System.out.println("Налог на другой системе: " + taxEMS + " рублей");
                        System.out.println("Экономиия:" + (taxEMS - taxE) + " рублей");
                    } else {
                        System.out.println("Мы советуем Вам УСН: Доходы минус расходы");
                        System.out.println("Ваш налог составит: " + taxEMS + " рублей");
                        System.out.println("Налог на другой системе: " + taxE + " рублей");
                        System.out.println("Экономиия:" + (taxE - taxEMS) + " рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }
}
