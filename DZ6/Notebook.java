package DZ6;

import java.util.Comparator;

public class Notebook implements Comparator<Notebook> {
    public Notebook() {

    }
    
    public Notebook(String name) {
        this.name = name;
    }

    public Notebook(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public String name;
    public String color;
    public int memory;
    public double price;
    public int year;
    public int hdd_size;
    public String cpu_type;

    @Override
    public String toString() {
        return name + "CPU: " + cpu_type + ", Ram: " + memory + "," + " Hdd: " + hdd_size + " color: " + color
                + " year: " + year + " = " + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Notebook note = (Notebook) obj;
        return name == note.name && color == note.color && memory == note.memory && price == note.price
                && year == note.year &&
                hdd_size == note.hdd_size && cpu_type == note.cpu_type;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + color.hashCode() + memory + (int) price * 100000 + year * 2 + hdd_size
                + cpu_type.hashCode();
    }

    @Override
    public int compare(Notebook o1, Notebook o2) {
        return o1.name.compareTo(o2.name);
    }

}