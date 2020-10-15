import java.util.Scanner;

import data.ItemsData;
import entidades.Items;

public class Main {
    public static void main(String[] args) {
        ItemsData data = new ItemsData();
        Scanner input = new Scanner(System.in);
        int opt = 0;
        do {
            System.out.println("***** CRUD ITEMS *****");
            System.out.println("1 List ");
            System.out.println("2 New ");
            System.out.println("3 Delete ");
            System.out.println("4 Get byID ");
            System.out.println("5 Update ");
            System.out.println("0 Exit ");
            System.out.println("Choice option: ");
            opt = input.nextInt();
            System.out.println("You chosed: " + opt);
            input.nextLine(); 
            switch (opt) {
                case 1:
                    System.out.println("Listado de items ");
                    for (Items d : data.list("")) {
                        System.out.println(d.getId() + "\t" + d.getNombre() + "\t" + d.getCategoria() + "\t" + d.getFamilia() + "\t" + d.getPrecio());
                    }
                    break;
                case 2:
                    System.out.println("Nuevo items ");
                    Items p = new Items();
                    System.out.print("nombre: ");
                    p.setNombre(input.nextLine());
                    System.out.print("categoria: ");
                    p.setCategoria(input.nextLine());
                    System.out.print("familia: ");
                    p.setFamilia(input.nextLine());

                    System.out.print("precio: ");
                    try {
                        p.setPrecio(input.nextInt());
                        data.create(p);
                    } catch (Exception e) {
                        input.nextLine(); // Limpiar el buffer
                        System.out.print("el precio  debe ser entero, no se guardo");
                    }

                    break;
                case 3:
                    System.out.println("Eliminar items ");
                    System.out.print("id: ");
                    data.delete(input.nextInt());
                    break;
                case 4:
                    int b4 = 1;
                    do {
                        System.out.println("get items ");
                        System.out.print("id: ");
                        int id = 0;
                        try {
                            b4 = 0;
                            id = input.nextInt();
                            Items d = data.get(id);
                            if (d != null) {
                                System.out.println("Id: " + d.getId());
                                System.out.println("nombre: " + d.getNombre());
                                System.out.println("categoria: " + d.getCategoria());
                                System.out.println("familia: " + d.getFamilia());
                                System.out.println("precio: " + d.getPrecio());
                            } else {
                                System.out.print("el items no existe");
                            }
                        } catch (Exception e) {
                            input.nextLine(); // Limpiar el buffer
                            System.out.print("id no valido, debe ser un numero");
                            b4 = 1;
                        }

                    } while (b4 != 0);

                    break;
                case 5:
                    System.out.println("update items ");
                    System.out.print("id: ");

                    Items per = data.get(input.nextInt());

                    if (per != null) {
                        System.out.println("nombre current: " + per.getNombre());
                        System.out.println("categoria current: " + per.getCategoria());
                        System.out.println("familia current: " + per.getFamilia());
                        System.out.println("precio current: " + per.getPrecio()) ;


                        input.nextLine(); // Limpiar el buffer
                        System.out.print("new nombre: ");
                        per.setNombre(input.nextLine());

                        System.out.print("new categoria: ");
                        per.setCategoria(input.nextLine());

                        System.out.print("new familia: ");
                        per.setFamilia(input.nextLine());


                        System.out.print("new precio: ");
                        try {
                            per.setPrecio(input.nextInt());
                            data.update(per);
                        } catch (Exception e) {
                            // per.setAge(0);
                            input.nextLine(); // Limpiar el buffer
                            System.out.print(" el precio debe ser entero, no se guardo");
                        }

                    } else {
                        System.out.println("NO encontrado");
                    }

                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        } while (opt != 0);
    }
}
