package SortOS;

import java.util.List;

public class ListaLigada<T extends Comparable<T>> {
    private Nodo<T> inicial;

    public Nodo<T> getInicial() {
        return inicial;
    }

    public void setInicial(Nodo<T> inicial) {
        this.inicial = inicial;
    }

    public boolean estaVacia() {
        return inicial == null;
    }

    public ListaLigada(List lista){
        Nodo<T> primero= new Nodo<T>((T)lista.get(0));
        setInicial(primero);
        for (int i=1; i<=lista.size(); i++){
            insertarAlUltimo((T)lista.get(i));
        }
    }

    public void insertarAlInicio(T elemento) {
        Nodo<T> aInsertar = new Nodo<>(elemento);
        aInsertar.setSiguiente(inicial);
        inicial = aInsertar;
    }

    public void insertarAlUltimo(T elemento) {
        if (estaVacia())
            insertarAlInicio(elemento);
        else {
            Nodo<T> temp = inicial;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(new Nodo<T>(elemento));
        }
    }

    public int contarElementos() {
        if (estaVacia()) {
            return 0;
        } else {
            Nodo<T> temp = inicial;
            int contador = 0;
            while (temp != null) {
                contador++;
                temp = temp.getSiguiente();
            }
            return contador;
        }
    }

    public void quitarElPrimero() {
        if (estaVacia())
            System.out.println("No puedes quitar elementos");
        else {
            inicial = inicial.getSiguiente();
        }
    }

    public void quitarAlFinal() {
        if (estaVacia()) {
            System.out.println("No puedes quitar elementos");
        } else {
            Nodo<T> temp = inicial;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(null);
        }
    }

    public void quitarAlFinalIndice() {
        if (contarElementos() == 0) {
            System.out.println("No puedes quitar elementos");
        } else if (contarElementos() == 1)
            quitarElPrimero();
        else {
            Nodo<T> penultimo = encontrarNodoEnElndice(contarElementos() - 2);
            penultimo.setSiguiente(null);
        }

    }

    public Nodo<T> encontrarNodoEnElndice(int indice) {
        if (indice < contarElementos()) {
            Nodo<T> temp = inicial;
            for (int i = 0; i < indice; i++) {
                temp = temp.getSiguiente();
            }
            return temp;
        } else {
            System.out.println("Index out of bounds");
            return null;
        }
    }

    public void insertarEnElIndice(int index, T elemento) {
        if (estaVacia())
            insertarAlInicio(elemento);
        else {
            if (index >= contarElementos()) {
                System.out.println("No puedes insertar en ese índice");
                return;
            }
            if (index == contarElementos() - 1) {
                insertarAlUltimo(elemento);
                return;
            }
            if (index == 0) {
                insertarAlInicio(elemento);
                return;
            }
            Nodo<T> anterior = encontrarNodoEnElndice(index - 1);
            Nodo<T> aInsertar = new Nodo<>(elemento);
            aInsertar.setSiguiente(anterior.getSiguiente());
            anterior.setSiguiente(aInsertar);

        }
    }

    public void imprimeLista() {
        if (estaVacia())
            System.out.println("Lista vacía");
        else {
            Nodo<T> temp = inicial;
            while (temp != null) {
                System.out.println("Nodo: " + temp.getElemento().toString());
                temp = temp.getSiguiente();
            }
        }
    }

    public void imprimeRec() {
        imprimeRecursivo(inicial);
    }

    private void imprimeRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.println("Nodo: " + nodo.getElemento().toString());
            imprimeRecursivo(nodo.getSiguiente());
        }
    }

    //Search Algorithms
    @SuppressWarnings("unused")
    private int busquedaLinear(T busca) throws Exception {
        Nodo<T> temp = inicial;
        if (estaVacia())
            throw new Exception("Lista vacía");
        int index = 0;
        while (temp != null) {
            if (0 == temp.getElemento().compareTo(busca))
                return index;
            else {
                temp = temp.getSiguiente();
                index++;
            }
        }
        throw new Exception("Elemento no encontrado");
    }

    public int busquedaBinaria(T elemento) throws Exception {
        int inicio = 0;
        int fin = contarElementos() - 1;
        while (inicio <= fin) {
            int mitad = (inicio + fin) / 2;
            if (encontrarNodoEnElndice(mitad).getElemento().compareTo(elemento) == 0)
                return mitad;
            else {
                if (0 < encontrarNodoEnElndice(mitad).getElemento().compareTo(elemento)) {
                    fin = mitad - 1;
                } else
                    inicio = mitad + 1;
            }

        }
        throw new Exception("Elemento no encontrado");
    }


    //Sort Algorithms
    /*
     * Bubble sort 			DONE
     * Insertion sort		DONE
     * selection sort		DONE
     * merge sort
     * quick sort
     *
     * shell sort
     * tree sort
     * heap sort
     * bogo sort
     * bucket sort
     * gnome sort
     * gravity sort
     * counting sort
     * [FIND OTHERs]
     *
     * */
    public void bubbleSort() {
        for (int i = 0; i < contarElementos() - 1; i++) {
            boolean intercambiado = false;
            for (int j = 0; j < contarElementos() - 1; j++) {
                if (encontrarNodoEnElndice(j).getElemento().compareTo(encontrarNodoEnElndice(j + 1).getElemento()) > 0) {
                    intercambiar(j, j + 1);
                    intercambiado = true;
                }
            }
            if (!intercambiado) {
                break;
            }
        }
    }

    private void intercambiar(int index1, int index2) {
        System.out.println("Se intercambia " + encontrarNodoEnElndice(index1) + " con: " + encontrarNodoEnElndice(index2));
        Nodo<T> temp = encontrarNodoEnElndice(index1);
        T tempT = temp.getElemento();
        Nodo<T> temp2 = encontrarNodoEnElndice(index2);
        temp.setElemento(temp2.getElemento());
        ;
        temp2.setElemento(tempT);
    }


    public void selectionSort() {
        for (int i = 0; i < contarElementos() - 1; i++) {
            int masPequenio = i;
            for (int j = i + 1; j < contarElementos() - 1; j++) {
                if (encontrarNodoEnElndice(j).getElemento().compareTo(encontrarNodoEnElndice(masPequenio).getElemento()) < 0) {
                    masPequenio = j;
                }
            }
            intercambiar(masPequenio, i);
        }
    }

    public void insertionSort() {
        int i = 1;
        while (i < contarElementos()) {
            int j = i;
            while (j > 0 && encontrarNodoEnElndice(j - 1).getElemento().compareTo(encontrarNodoEnElndice(j).getElemento()) > 0) {
                intercambiar(i, j - 1);
                j--;
            }
            i++;
        }
    }

    public void mergeSort() throws Exception {
        inicial = mergeSort(inicial);
    }

    private Nodo<T> mergeSort(Nodo<T> inicial) throws Exception {
        Nodo<T> incioAnterior = inicial;
        int mid = contarElementos() / 2;
        if (contarElementos() == 0)
            throw new Exception("Ya está ordenada");
        if (contarElementos() == 1)
            return inicial;
        Nodo<T> inicioAnterior = inicial;
        if (inicioAnterior.getSiguiente() == null)
            return inicial;
        while (mid - 1 > 0) {

            inicioAnterior = inicioAnterior.getSiguiente();
            mid--;
        }
        Nodo<T> nuevoInicio = inicioAnterior.getSiguiente();
        inicioAnterior.setSiguiente(null);
        inicioAnterior = inicial;
        Nodo<T> temp1 = mergeSort(inicioAnterior);
        Nodo<T> temp2 = mergeSort(nuevoInicio);
        return merge(temp1, temp2);
    }

    public Nodo<T> merge(Nodo<T> a, Nodo<T> b) {
        Nodo<T> resultado;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.getElemento().compareTo(b.getElemento()) > 0) {
            resultado = b;
            resultado.setSiguiente(merge(a, b.getSiguiente()));
        } else {
            resultado = a;
            resultado.setSiguiente(merge(resultado, b));
        }
        return resultado;
    }
}