package pl.sda.poznan.sort.measure;

import pl.sda.poznan.sort.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Program wypelniajacy losowymi wartosciami tablice
 * i mierzacy czas sorotwania
 * z wykorzystaniem zaimplementowynych metod sorotwania
 */

public class App {
    public static void main(String[] args) {
        //sout -> podaj ile el wylosowac
        System.out.println("Podaj ilosc elementow do wylosowania:");
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        //utworzyc tablice o takim rozmiarze
        int[] array = new int[arraySize];
        //wypelnic ja losowymi wartosciami
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(100);
            //System.out.print(array[i] + " | ");
        }

        //pomocnicza tablica zeby obie metody sortowania otrzymaly te same tablice
        //a nie juz posortowane
        //w celu porownania
        //kopiujemy do pomocniczej tablicy -> toSort i toMergeSort


        //posortowac babelkowo - wyswietlic czas
        System.out.println("Sortowanie babelkowe");
        int[] toSort = Arrays.copyOf(array, arraySize);
        long startTime = System.currentTimeMillis();
        BubbleSort.sort(toSort);
        long endTime = System.currentTimeMillis();
        long bubbleTime = endTime - startTime;
        System.out.println("Czas operacji to: " + bubbleTime);
        System.out.println();

        //posortowac mergeSort - wyswietlic czas

        System.out.println("Sortowanie przez scalanie");
        int[] toMergeSort = Arrays.copyOf(array, arraySize);
        MergeSort mergeSort = new MergeSort();
        long startMergeTime = System.currentTimeMillis();
        mergeSort.sort(toMergeSort);
        long endMergeTime = System.currentTimeMillis();
        long mergeTime = endMergeTime - startMergeTime;
        System.out.println("Czas operacji to: " + mergeTime);
        System.out.println();


        //posortowac kubałkowo - wyswietlic czas
        System.out.println("Sortowanie kubelkowe");
        int[] toBucketSort = Arrays.copyOf(array, arraySize);
        long startBucketTime = System.currentTimeMillis();
        BucketSort.sort(toBucketSort, 100);
        long endBucketTime = System.currentTimeMillis();
        long bucketTime = endBucketTime - startBucketTime;
        System.out.println("Czas operacji to: " + bucketTime);
        System.out.println();

        //posortowac przez wstawianie - wyswietlic czas
        System.out.println("Sortowanie przez wstawianie");
        int[] toInsertionSort = Arrays.copyOf(array, arraySize);
        long startInsertionTime = System.currentTimeMillis();
        InsertionSort.sort(toInsertionSort);
        long endInsertionTime = System.currentTimeMillis();
        long insertionTime = endInsertionTime - startInsertionTime;
        System.out.println("Czas operacji to: " + insertionTime);
        System.out.println();

        //posortowac przez qucikSort - wyswietlic czas
        QuickSort quickSort = new QuickSort();
        System.out.println("Sortowanie przez quickSort");
        int[] toQuickSort = Arrays.copyOf(array, arraySize);

        long startQuickTime = System.currentTimeMillis();
        quickSort.sort(toQuickSort);
        long endQuickTime = System.currentTimeMillis();
        long quickTime = endQuickTime - startQuickTime;
        System.out.println("Czas operacji to: " + quickTime);
        System.out.println();

        System.out.println();
        System.out.println("Ranking metod sortowania:");
        long[] rank = {bubbleTime, mergeTime, bucketTime, insertionTime, quickTime};

        System.out.println("bubbleTime | mergeTime | bucketTime | insertionTime | quickTime");
        for (int i = 0; i < rank.length; i++)
            System.out.print(rank[i] + "      |    ");

        /*BucketSort bucketRank = new BucketSort();
        bucketRank.sort(rank);*/
    }
}
