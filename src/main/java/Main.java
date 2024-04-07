import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*
        Почему сортировка так называется? Сортировка методом вставки придумана для случаев, когда массив уже частично отсортирован,
        и отсортированная часть находится в левой части массива. Согласно алгоритму в эту отсортированную
        часть вставляются в нужные места числа из неотсортированной части массива. В отличие
        от bubble и insertion сортировок, эта сортированная часть изменяемая. Для этого алгоритма необязательно чтобы отсортированная
        часть состояла из нескольких элементов. На самом первом шаге считаем что отсортированная часть состоит из одного элемента.
        При этом мы:
        - из несортированной части берем первое число;
        - если оно больше самого правого числа из сортированной части, то всё ок, переходим к следующему числу;
        - если меньше, то мы:
            - сохраняем его в переменную;
            - одновременно сдвигаем по одному элементу вправо и ищем место для сохраненного во временную переменную числа;
            - находим это место и вставляем туда сохраненное число;
        - делаем так, пока всё не будет отсортировано.
        */

        int[] arr = new int[]{4, 8, 2, 6, 0, 1, 5};
        System.out.println(Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] arr) {

        int indexOfFirstUnsortedElement = 1;
        int indexOfPreviousSortedElement;

        int savedFirstUnsortedElement;

        while (indexOfFirstUnsortedElement < arr.length) {

            savedFirstUnsortedElement = arr[indexOfFirstUnsortedElement];
            indexOfPreviousSortedElement = indexOfFirstUnsortedElement - 1;

            while (indexOfPreviousSortedElement >= 0 && savedFirstUnsortedElement < arr[indexOfPreviousSortedElement]) {
                arr[indexOfPreviousSortedElement + 1] = arr[indexOfPreviousSortedElement];
                indexOfPreviousSortedElement--;
            }

            arr[indexOfPreviousSortedElement + 1] = savedFirstUnsortedElement;
            indexOfFirstUnsortedElement++;
        }

        return arr;
    }
}
