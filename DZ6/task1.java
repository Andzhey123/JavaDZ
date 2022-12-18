package DZ6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class task1 {
    public static void main(String[] args) {
        Set<Notebook> notes = new HashSet<>();
        for (int i = 0; i < 100; i++)
            notes.add(notebook_factory());


        Scanner in = new Scanner(System.in);
        sort = new SortProcess(notes);
        do {
            print_menu();
            String input = in.nextLine();

            if (input.equals("exit"))
                break;
            switch (input) {
                case "print":
                    for (Notebook notebook : sort.get_sorted())
                        System.out.println(notebook);
                    break;
                case "reset":
                    sort.reset();

                default:
                    if (sort.get_params().containsKey(input)) {
                        if (sort.get_params().get(input).equals("str")) {
                            System.out.println("Введите 1 или несколько значений фильтра разделенных запятой.");
                        } else {
                            System.out.println("Введите минимальное и максимальное зачения параметра через запятую.");
                        }
                        if (sort.sort(input, in.nextLine()))
                            System.out.println("OK");
                        else
                            System.out.println("Неверный фильтр!");
                    }
                    in.close();
                    break;
            }

        } while (true);
    }

    public static SortProcess sort;

    /**
     * Вывод меню пользователя
     */
    public static void print_menu() {
        System.out.println("\n\n\n------------------------------------------------");
        List<String> list = new ArrayList<>();
        list.add("reset - Сброс фильтра");
        list.add("print - Вывод результата");
        list.add("exit - Выход из программы");
        list.add("-------------------------");
        for (String par : sort.get_params().keySet()) {
            list.add(par + " - сортировка по параметру");
        }
        for (String string : list) {
            System.out.println(string);
        }
    }

    /**
     * Метод для генерации произвольного ноутбука..
     * @return
     */
    public static Notebook notebook_factory() {
        Random rnd = new Random();
        Notebook note = new Notebook();
        String[] colors = new String[] { "White", "Red", "Blue", "Green", "Black", "Magetta", "Gray" };
        note.color = colors[rnd.nextInt(colors.length)];

        String[] cpu_type = new String[] { "Ryzen 3", "Ryzen 5", "Ryzen 7", "Core i3", "Core i5", "Core i7" };
        note.cpu_type = cpu_type[rnd.nextInt(cpu_type.length)];

        int hdd_size[] = new int[] { 64, 128, 256, 512, 1024, 2048, 4096 };
        note.hdd_size = hdd_size[rnd.nextInt(hdd_size.length)];

        int manufactured_year[] = new int[] { 2019, 2020, 2021, 2022 };
        note.year = manufactured_year[rnd.nextInt(manufactured_year.length)];

        String[] name = new String[] { "Huawei MateBook 16S", "REALME CloudPro002", "Lenovo IdeaPad 3 ",
                "MSI GF63 Thin 11UC-207XRU",
                "Honor MagicBook X14", "HP 15s-fq0082ur" };
        note.name = name[rnd.nextInt(name.length)];

        int[] memory = new int[] { 4, 8, 16, 32 };
        note.memory = memory[rnd.nextInt(memory.length)];

        note.price = 40000 + rnd.nextInt(110) * 1000;

        return note;
    }
}