import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математические выражение. Например, 30 + 47: ");
        String input = scanner.nextLine();

        try
        {
            System.out.println("Результат: " + calc(input));
        }
        catch(Exception e)
        {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    public static String calc(String input) throws Exception
    {
        String[] parts = input.split(" ");

        if(parts.length != 3)
        {
            throw new Exception("Не соответствует требованиям - два операнда и один оператор!");
        }

        double number1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double number2 = Double.parseDouble(parts[2]);

        int result = 0;

        if(number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10)
        {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10 включительно!");
        }
        else if (number1 % 1 != 0 || number2 % 1 != 0)
        {
            throw new Exception("Число должно быть целочисленным!");
        }

        switch(operator)
        {
            case "+":
                result = (int)(number1 + number2);
                break;
            case "-":
                result = (int)(number1 - number2);
                break;
            case "*":
                result = (int)(number1 * number2);
                break;
            case "/":
                if(number2 != 0)
                {
                    result = (int)(number1 / number2);
                }
                else
                {
                    throw new Exception("Делить на ноль нельзя!");
                }
                break;
            default:
                throw new Exception("Неверно введен оператор вычисления!");
        }
        return String.valueOf(result);
    }
}