package lessons.lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Homework3 {

    /* example:
     * input: Mama mila ramu, Ramu mila mama!!!, [mama, ramu]
     * output: 4
     * use regex, split, lowerCase, replace methods
     * */
    public int countOfWordsFromDictionaryInString(String input, String[] dictionary) {
        //посчитать все слова из словаря в input
        //если одно слово встречается 5 раз его нужно посчитать 5 раз
        String[] words = input.toLowerCase().split("\\W+");
        int counter = 0;
        for (String word : words) {
            for (String dictWord : dictionary) {
                if (word.equals(dictWord.toLowerCase())) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    /* example:
     * input: [1,0,3,17,2,7,14,1,1,7], K = 6
     * output: 3
     * use sort
     * */
    public int kOrderValue(int[] array, int k) {
        //метод должен вернуть К по порядку элемент массива
        Arrays.sort(array);
        return array[k - 1];
    }

    /* example:
     * input: m.levin.main@mailg.spb.com
     * output: true
     *
     * use matches
     * */
    public boolean isEmail(String input) {
        return input.matches("\\w+(\\.?\\w+)*@\\w+(\\.?\\w+)*\\.?\\w+");
    }

    public void binarySearchGame() {
        int secretValue = new Random().nextInt(100);
        int userValue = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);
        for (int attempt = 0; attempt < 7; attempt++) {
            System.out.println("Input number from 0 to 99");
            userValue = scanner.nextInt();
            if (userValue == secretValue) {
                System.out.println("You win!");
                break;
            } else if (userValue > secretValue) {
                System.out.println("<");
            } else {
                System.out.println(">");
            } //мы печатаем в консоль наши предположения (в цикле), компютер отвечает > , < или =
            //на каждый наш вопрос
            //если задано более 7 вопросов и не угадано значение, мы проиграли
            //если компютер вывел =, мы выиграли
        }
        if (userValue != secretValue) {
            System.out.println("Secret value " + secretValue + "\nYou lose!");
        }
    }

    /*
    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
    омпьютер показывает буквы которые стоят на своих местах.
    apple – загаданное
    apricot - ответ игрока
    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно, можно пользоваться:
    String str = "apple";
    str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово
    Используем только маленькие буквы
    */
    public void wordsGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int secretWordIndex = new Random().nextInt(words.length);
        String secretWord = words[secretWordIndex];
        String userWord = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "Input word from:\n" +
                            "apple, orange, lemon, banana, apricot, avocado, broccoli, carrot, cherry,\n" +
                            "garlic, grape, melon, leak, kiwi, mango, mushroom, nut, olive, pea, peanut,\n" +
                            "pear, pepper, pineapple, pumpkin, potato");
            userWord = scanner.nextLine();
            if (userWord.equals(secretWord)) {
                System.out.println("You win!");
                break;
            } else {
                int minWordLength = Math.min(secretWord.length(), userWord.length());
                for (int index = 0; index < minWordLength; index++) {
                    if (secretWord.charAt(index) == userWord.charAt(index)) {
                        System.out.print(secretWord.charAt(index));
                    } else {
                        System.out.print("#");
                    }
                }
                for (int iteration = minWordLength; iteration < 15; iteration++) {
                    System.out.print("#");
                }
                System.out.println("\nTry again");
            }
        }
    }
}
