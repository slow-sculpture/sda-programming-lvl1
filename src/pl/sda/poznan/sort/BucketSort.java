package pl.sda.poznan.sort;

//zalozenie ze mamy liczy z przedzialu 0 - max

public class BucketSort {
    public static void sort(int[] arr){
        //znalezc max
        int max = arr[0];
        for (int i = 1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //wywolac metode
        sort(arr, max);
    }

    public static void sort(int[] arr, int max) {
        //utworzyc tablice na kubelki
        int[] bucket = new int[max + 1];

        //przejsc przez tablice i zlicza ilosc wystapien elementow
        for (int i = 0; i < arr.length; i++) {
            //int index = arr[i];
            //bucket[index] = bucket[index] + 1;
            //bucket[index] += 1;
            //bucket[index]++;
            bucket[arr[i]]++;
        }

        //zmienna pomocnicza do iterowania po indexach tablicy arr (oryginalnej/wejsciowej)
        int k = 0;
        //zewnetrzna petla przechodzi przez tablice koszykow
        for(int i =0;i<bucket.length;i++ ){
            //wewnetrzna petla wykonuje sie tyle razy ile bylo el w koszyku
            for(int j=0; j<bucket[i];j++){
                arr[k] = i ;
                k++;
            }
        }

    }
}
