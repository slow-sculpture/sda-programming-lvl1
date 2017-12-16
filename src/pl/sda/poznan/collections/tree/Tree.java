package pl.sda.poznan.collections.tree;

//struktura danych gdzie wyrozniwaym
//korzen root (element drzewa) - rodzic dla synow a sam nie ma rodzica
//binarny - posiada dwa elementy -> synowie -> lewy syn i prawy syn
//syn nie majacy dzieci to lisc - leaf
//syn moze miec 1 lub 2 potomkow (nie wiecej bo binarne - sa tez inne)

//drzewo BST Binary Search Tree
//nasteony element na lewo mniejszy od rodzica na prawo wiekszy

//bardzo szybkie wyszukiwani

//przechodzenie przez drzewo - traversal of the tree note
//1. pre-order -> zasada VLR visit-left-right
//2. in-order -> LVR -> najbardziej istotny
//3. post-order -> LRV

//example
//        15
//      /    \
//  10          20
// /  \       /    \
//5     13  28      23

//1. -> 15,10,,5,13,20,18,23
//2. -> 5,10,13,15,18,20,23 -> uporzadkowanie
//3. -> 5,13,10,18,23,20,15

public interface Tree<T> {
    /**
     * Metoda dodajaca element
     * @param data
     */
    void insert(T data);

    /**
     * Metoda usuwajaca element
     * @param data
     */
    void delete(T data);

    /**Metoda znajdujaca najwiekszy element
     *@return
     */
    T getMax();

    /**
     * Metoda znajdujaca najmniejsz element
     * @return
     */
    T getMin();

    /**
     * Metoda przechodzaca przez drzewo
     */
    void traversal();
}

