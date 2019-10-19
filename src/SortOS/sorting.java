package SortOS;

public class sorting {
    public static void quickSort(ListaLigada<Alumno> input, int initial, int last) {
        if (initial < last) {
            int q = partition(input, initial, last);
            quickSort(input, initial, q - 1);
            quickSort(input, q + 1, last);
        }
    }

    private static int partition(ListaLigada<Alumno> input, int initial, int last) {
        int pivot = (int) input.encontrarNodoEnElndice(last).getElemento().getCalif();
        int i = initial - 1;
        for (int j = initial; j < last - 1; j++) {
            if ((int) input.encontrarNodoEnElndice(j).getElemento().getCalif() <= pivot) {
                i++;
                input.intercambiar(i, j);
            }
        }
        //000       011     110
        //001       100     111
        //010       101
        input.intercambiar(i + 1, last);
        return (i + 1);
    }

    public static ListaLigada bogoSort (ListaLigada input){
        System.out.println("Not available");
        return input;
    }
}
