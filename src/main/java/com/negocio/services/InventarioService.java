package com.negocio.services;

import com.negocio.models.Producto;
import java.util.ArrayList;
import java.util.List;

public class InventarioService {
    private List<Producto> productos;

    public InventarioService() {
        this.productos = new ArrayList<>();
        inicializarProductos();
    }

    private void inicializarProductos() {
        agregarProducto(new Producto(1, "Hamburguesa", 15.50, 20));
        agregarProducto(new Producto(2, "Pizza", 25.00, 15));
        agregarProducto(new Producto(3, "Tacos", 8.75, 30));
        agregarProducto(new Producto(4, "Refresco", 3.50, 50));
        agregarProducto(new Producto(4, "Refresco", 3.50, 50));

    }
    private void agregarProducto(Producto nuevo) {
        boolean existe = productos.stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase(nuevo.getNombre()));

        if (!existe) {
            productos.add(nuevo);
            System.out.println("Producto agregado: " + nuevo.getNombre());
        } else {
            System.out.println("El producto '" + nuevo.getNombre() + "' ya existe y no se agregó.");
        }
    }

    // ERROR 8: Bucle infinito potencial(check)
    public Producto buscarProductoPorId(int id) {
        int i = 0;
        while (i < productos.size()) { // Debería ser < en lugar de <= porque exede los limites
            if (productos.get(i).getId() == id) {
                return productos.get(i);
            }
            i++;
        }
        return null;
    }

    // ERROR 9: No actualiza el stock después de la venta (check)
    public boolean venderProducto(int id, int cantidad) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null && producto.hayStock(cantidad)) {
            producto.reducirStock(cantidad);   // No reduce el stock - ERROR LÓGICO (check)
            System.out.println("Venta realizada: " + producto.getNombre());
            return true;
        }
        return false;
    }

    // ERROR 10: Código duplicado y condición mal formulada
    public List<Producto> obtenerProductosDisponibles() {
        List<Producto> disponibles = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getStock() > 0) { // Debería ser > 0 (check)
                disponibles.add(producto);
            }
        }
        return disponibles;
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productos;
    }
}