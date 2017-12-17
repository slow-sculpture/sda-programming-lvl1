package pl.sda.poznan.collections.tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    //tutaj extends oznacza implementuje (głupia skladnia)
    //klasa BST jest typu generycznego czyli moze pracowac z dowolnym typem
    //ktory implementuje interfejs Comparable i klasa BST implementuje
    //interfejs Tree
    //<T extends Comparable<T>> ograniczenie przyjmowanego typu generycznego
    //do takiego ktory implementuje interfejs Comparable
    //dzieki temu zapisowi na obiekcie root mozemy wywolac metode compareTo()
    private Node<T> root;

    @Override
    public boolean contains(T data) {
        if (root == null) {
            throw new IllegalArgumentException("Brak elementow w drzewie");
            //lub return false
        } else {
            return contains(root, data);
        }
        /*
        ze wzgledu na pierwszego if w metodzie prywatnej if(root == null) bedzie obsluzony
        wystarczy wpisac:
        return contains(root, data);
         */
    }

    //wraper dla metody contains(T data)
    private boolean contains(Node<T> node, T data) {
        //bo wywola null.getData() ->NullPointerException
        //dlatego trzeba obsluzyc jak bedzie null
        //czyli nie bedzie takiego elementu
        //ten if zalatwia z glownej metody if (root == null)
        if (node == null){
            return false;
        }
        //szukana wartosc zgadza sie z elementem drzewa
        if (data.compareTo(node.getData()) == 0) {
            return true;
            //szukamy w lewym poddrzewie i rekurencyjnie spr czy 0
        } else if (data.compareTo(node.getData()) < 0) {
            return contains(node.getLeft(), data);
            //szukamy w prawym poddrzewie i rekurencyjnie spr czy 0
        } else {
           return contains(node.getRight(), data);
        }
    }


    @Override
    public void insert(T data) {
        //czy drzewo jest puste?
        if (root == null) {
            this.root = new Node<>(data);
        } else {
            //jak nie to:
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {
        //czy wstawiany element jest wiekszy czy mniejszy
        //potrzebna metoda compareTo ale T do jakis obiekt i nie ma tej metody - nie implementuje Comparable
        //wiec w public class BinarySearchTree<T> implements Tree<T> {
        //piszemy: public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
        // i wtedy metoda jest dostepna

        //porownujemy wstawiany element z danym wezlem
        //jezeli data.compareTo(node.getDara()) zwroci wartpsc ujemna
        //to znaczt ze jest mniejszy i musi trafic do lewego poddrewa
        //w przeciwnym przypadku do prawego

        //lewe:
        if (data.compareTo(node.getData()) < 0) {
            //wstawiamy do lewego poddrzewa
            if (node.getLeft() != null) {
                //jezeli dany wezel na lewego syna
                //to nie mozemy wstawic w to miejsce
                //musimy rekurencyjnie wywolac jeszcze raz to funkcje
                insert(data, node.getLeft());
            } else {
                //wezel nie ma lewego syna wiec wstawiamy w to miejsca
                Node<T> newNode = new Node<>(data);
                node.setLeft(newNode);
            }

            //prawe:
        } else {
            if (node.getRight() != null) {
                insert(data, node.getRight());
            } else {
                Node<T> newNode = new Node<>(data);
                node.setRight(newNode);
            }
        }
    }

    @Override
    public void delete(T data) {
        if (root == null) {
            throw new IllegalArgumentException("Brak elementow w drzewie");
        } else {
            delete(root, data);
        }
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        //jesli kasowany element jest mniejszy od wezla to szukaj w lewym poddrzewie
        if (data.compareTo(node.getData()) < 0) {
            //lewym synem bedzie rekurencja tej metody
            node.setLeft(delete(node.getLeft(), data));
            //jesli kasowany element jest wiekszy od wezla to szukaj w prawym poddrzewie
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(delete(node.getRight(), data));
        } else {
            //znalezlismy element do usuniecia
            //usuniecie liscia nie skutkuje przesunieciem innych (dalszych) elementow bo ich nie ma
            //usuniecie elementu posiadajacego synow skutkuje przesuniecie elementow j.n.
            //wstawiamy w miejsce usuwanego elementu najwiekszy element z lewego poddrzewa lub najmniejszy z prawego
            //3 przypadki:
            // a) usuwanie liscia
            if (node.getLeft() == null && node.getRight() == null) {
                System.out.println("Removing leaf...");
                return null;
                //garbage collector sprzatnie obiekt
            }

            // b) usuwanie rodzica z 1 dzieckiem
            if (node.getLeft() == null) {
                System.out.println("Removing right...");
                Node<T> tempNode = node.getRight();
                node = null;
                return tempNode;
            } else if (node.getRight() == null) {
                System.out.println("Removing left...");
                Node<T> tempNode = node.getLeft();
                node = null;
                return tempNode;
            }

            // c) usuwanie rodzica z 2 dzieci
            System.out.println("Removing with 2 items");
            Node<T> tempNode = getPredecessor(node.getLeft());
            node.setData(tempNode.getData());
            node.setLeft(delete(node.getLeft(), tempNode.getData()));
        }
        return node;
    }

    /////// moj pomysl (niedokonczony)\\\\\\\\\\\
    /*private void delete(T data, Node<T> node) {
        if (data.compareTo(node.getData()) == 0) {

            if (node.getLeft() != null){

            }
            if (node.getRight() != null){
         //       node.getRight().setLeft();
            }
            node.setData(null);

        } else if (data.compareTo(node.getData()) < 0) {
            if (node.getLeft() != null) {
                delete(data, node.getLeft());
            }
        } else { //>0 strona prawa
            if (node.getRight() != null) {
                delete(data, node.getRight());
            }

        }
    }*/

    /**
     * Metoda znajdujaca poprzednika
     */
    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRight() != null) {
            getPredecessor(node.getRight());
        }
        return node;
    }

    @Override
    public T getMax() {
        if (root == null)
            return null;
        if (root.getRight() == null) {
            return root.getData();
        } else {
            return getMax(root);
        }
    }

    private T getMax(Node<T> node) {
        if (node.getRight() != null)
            return getMax(node.getRight());
        return node.getData();
    }

    @Override
    public T getMin() {
        if (root == null)
            return null;
        if (root.getLeft() == null) {
            return root.getData();
        } else {
            return getMin(root);
        }
    }

    private T getMin(Node<T> node) {
        if (node.getLeft() != null)
            return getMin(node.getLeft());
        return node.getData();
    }

    @Override
    public void traversal() {
        if (root != null) {
            inorderTraversal(root);
            System.out.println();
            preorderTraversal(root);
            System.out.println();
            postorderTraversal(root);
        }
    }


    /**
     * Przejscie in-order przez drzewo LVR
     */
    private void inorderTraversal(Node<T> node) {
        if (node.getLeft() != null) {
            //jak jest lewy syn to wywolujemy rekurnecyjnie ponownie funkcje na tym lewym synu
            //i sprawdzamy czy ten ma lewego
            inorderTraversal(node.getLeft());
        }
        //odwiedz rodzica
        System.out.println(node.getData().toString());

        //odwiedz prawego syna
        if (node.getRight() != null) {
            inorderTraversal(node.getRight());
        }
    }

    /**
     * Przejscie pre-order przez drzewo VLR
     */
    private void preorderTraversal(Node<T> node) {
        //rodzic
        System.out.println(node.getData().toString());
        //lewy
        if (node.getLeft() != null) {
            preorderTraversal(node.getLeft());
        }
        //prawy
        if (node.getRight() != null) {
            preorderTraversal(node.getRight());
        }
    }

    /**
     * Przejscie post-order przez drzewo LRV
     */
    private void postorderTraversal(Node<T> node) {
        //lewy
        if (node.getLeft() != null) {
            postorderTraversal(node.getLeft());
        }
        //prawy
        if (node.getRight() != null) {
            postorderTraversal(node.getRight());
        }
        //rodzic
        System.out.println(node.getData().toString());
    }


}
