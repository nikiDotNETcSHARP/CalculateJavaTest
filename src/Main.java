import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математические выражение. Например, 30 + 47 или III + VII: ");
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

        boolean isRoman = isRomanNumeral(parts[0]) && isRomanNumeral(parts[2]);
        boolean isArabic = !isRoman;

        if (isArabic && isRoman)
        {
            throw new Exception("Числа должны быть либо только арабскими, либо только римскими!");
        }

        double number1 = isRoman ? romanToArabic(parts[0]) : Double.parseDouble(parts[0]);
        String operator = parts[1];
        double number2 = isRoman ? romanToArabic(parts[2]) : Double.parseDouble(parts[2]);

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
        return isRoman ? arabicToRoman(result) : String.valueOf(result);
    }

    private static boolean isRomanNumeral(String s)
    {
        return s.matches("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static int romanToArabic(String roman)
    {
        int result = 0;

        switch(roman)
        {
            case "I":
                result = 1;
                break;
            case "II":
                result = 2;
                break;
            case "III":
                result = 3;
                break;
            case "IV":
                result = 4;
                break;
            case "V":
                result = 5;
                break;
            case "VI":
                result = 6;
                break;
            case "VII":
                result = 7;
                break;
            case "VIII":
                result = 8;
                break;
            case "IX":
                result = 9;
                break;
            case "X":
                result = 10;
                break;
        }
        return result;
    }

    private static String arabicToRoman(int arabic)
    {
        String result = null;

        switch(arabic)
        {
            case 1:
                result = "I";
                break;
            case 2:
                result = "II";
                break;
            case 3:
                result = "III";
                break;
            case 4:
                result = "IV";
                break;
            case 5:
                result = "V";
                break;
            case 6:
                result = "VI";
                break;
            case 7:
                result = "VII";
                break;
            case 8:
                result = "VIII";
                break;
            case 9:
                result = "IX";
                break;
            case 10:
                result = "X";
                break;
        }
        return result;
    }
}