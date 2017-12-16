package pl.sda.poznan.collections.tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

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
            delete(data, root);
        }
    }

    private void delete(T data, Node<T> node) {
        if (data.compareTo(node.getData()) == 0) {
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
