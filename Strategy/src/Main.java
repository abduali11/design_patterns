public class Main {
    public static void main(String[] args) {

        /*  STRATEGY SUUNNITTELUMALLI
            Tässä tehdään kaksi taulukkoa, joista toinen on lyhyt ja toinen pitkä.
            Luvut ovat 0 - 99 välillä.
         */

        // Randomize a short array
        int shortLength = 100;
        int[] shortArray = createRandomArray(shortLength);

        // Randomize a long array
        int longLength = 300000;
        int[] longArray = createRandomArray(longLength);


        // Alusta Sorterit
        Sorter[] sorters = {new QuickSort(), new InsertionSort(), new PancakeSort()};
        Context context = new Context();

        // Järjestä lyhyt kaikilla ja mittaa aika
        System.out.println("Short array sorting times:");
        for (Sorter sorter : sorters) {
            context.setSorter(sorter);
            float time = timeToSort(shortArray, context);
            System.out.println(sorter.getClass().getSimpleName() + ": " + time + " ms");
        }

        System.out.println();

        // Järjestä pitkä kaikilla ja mittaa aika
        // PancakeSort voi olla hitaampi. Se ei ole tehokas suurilla taulukoilla.

        System.out.println("Long array sorting times:");
        for (Sorter sorter : sorters) {
            context.setSorter(sorter);
            float time = timeToSort(longArray, context);
            System.out.println(sorter.getClass().getSimpleName() + ": " + time + " ms");
        }



    }

    /**
     * Metodi, taulukolliset satunnaisia lukuja annetun pituuden mukaan.
     * @param length Taulukon pituus
     * @return Satunnainen taulukko
     */
    private static int[] createRandomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    private static float timeToSort(int[] arr, Context context) {
        long startTime = System.nanoTime();
        context.sort(arr);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000.0f;
    }

}