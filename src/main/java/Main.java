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

        int[] arr = {4, 8, 2, 6, 0, 1, 5};
        System.out.println(Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] arr) {

        int indexOfPreviousSorted;
        int savedFirstUnsorted;

        for (int indexOfFirstUnsorted = 1; indexOfFirstUnsorted < arr.length; indexOfFirstUnsorted++) {

            indexOfPreviousSorted = indexOfFirstUnsorted - 1;
            savedFirstUnsorted = arr[indexOfFirstUnsorted];

            while (indexOfPreviousSorted >= 0 && savedFirstUnsorted < arr[indexOfPreviousSorted]) {
                arr[indexOfPreviousSorted + 1] = arr[indexOfPreviousSorted];
                indexOfPreviousSorted--;
            }

            arr[indexOfPreviousSorted + 1] = savedFirstUnsorted;
        }

        return arr;
    }
}
