package nativa;

import java.io.*;
import modelo.Product;

public class Ejemplo1 {
    public static void main(String[] args) {
        // Crear un objeto Product
        Product product = new Product(1, 19.99, "Producto de ejemplo");

        // Serializar el objeto y guardarlo en un archivo
        try {
            FileOutputStream fileOut = new FileOutputStream("product.t");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(product);
            out.close();
            fileOut.close();
            System.out.println("El objeto Product se ha serializado y guardado en el archivo 'product.txt'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserializar el objeto desde el archivo y mostrarlo en la consola
        try {
            FileInputStream fileIn = new FileInputStream("product.t");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Product deserializedProduct = (Product) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("El objeto Product se ha deserializado desde el archivo 'product.txt':\n" + deserializedProduct.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
