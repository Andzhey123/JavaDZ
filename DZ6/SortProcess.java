package DZ6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SortProcess {
    public SortProcess(Set<Notebook> notes) {
        base_notes = notes;
        sorted_notes = notes;

        params = new HashMap<String, String>();
        params.put("name", "str");
        params.put("color", "str");
        params.put("memory", "num");
        params.put("price", "num");
        params.put("year", "num");
        params.put("hdd_size", "num");
        params.put("cpu_type", "str");
    }

    private Set<Notebook> base_notes;
    private Set<Notebook> sorted_notes;
    private Map<String, String> params;

    /**
     * Возвращает отфильтрованное мгожество
     * @return
     */
    public Set<Notebook> get_sorted() {
        return sorted_notes;
    }

    /**
     * Возвращает словарь с параметрами сортировки, где key - параметр сортировки, а value - тип занчения (строковый или числовой)
     * @return
     */
    public Map<String, String> get_params() {
        return params;
    }

    
    public void reset() {
        sorted_notes = base_notes;
    }

    /**
     * Метод для фильтрации по параметру
     * @param sort_param параметр по которому фильтруем
     * @param arg значение фильтра (строка)
     * @return true - если все ОК фильтр применен!
     */
    public Boolean sort(String sort_param, String arg) {
        if (!params.containsKey(sort_param))
            return false;
        if (params.get(sort_param) == "str")
            return string_filter(sort_param, arg);
        else
            return num_filter(sort_param, arg);
    }

    /**
     * Филбтрация по строковому параметру (name, cpu_type...)
     * @param sort_param
     * @param arg
     * @return true - если все ОК фильтр применен!
     */
    private boolean string_filter(String sort_param, String arg) {
        Set<Notebook> newsort = new HashSet<Notebook>();
        String[] args = arg.split(",", 0);
        for (Notebook note : sorted_notes) {
            switch (sort_param) {
                case "name":
                    if (find_args_in_string_conteins(note.name, args))
                        newsort.add(note);
                    break;
                case "color":
                    if (find_args_in_string_conteins(note.color, args))
                        newsort.add(note);
                    break;
                case "cpu_type":
                    if (find_args_in_string_conteins(note.cpu_type, args))
                        newsort.add(note);
                    break;
            }

        }
        sorted_notes = newsort;
        return true;
    }

    /**
     * Ищет вхождения строк args в строку str
     * 
     * @param str
     * @param args
     * @return true, если строка str содержит хотябы 1 строку из args
     */
    private boolean find_args_in_string_conteins(String str, String[] args) {
        for (String arg : args) {
            if (str.contains(arg))
                return true;
        }
        return false;

    }

    /**
     * Фильтр по числовым полям Notebook.
     * 
     * @param sort_param поле Notebook по которому работает фильтр
     * @param arg        строка, содержащая минимальное и максимальное числовые
     *                   значения, разделенные запятой.
     * @return true, если аргументы заданы верно
     */
    private boolean num_filter(String sort_param, String arg) {
        Set<Notebook> newsort = new HashSet<Notebook>();
        arg.replace(" ", "");
        String[] args = arg.split(",", 0);
        if (args.length != 2)
            return false;
        double min, max;
        try {
            min = Double.parseDouble(args[0]);
            max = Double.parseDouble(args[1]);
        } catch (Exception ex) {
            return false;
        }
        for (Notebook note : sorted_notes) {
            switch (sort_param) {
                case "memory":
                    if ((note.memory >= min) && (note.memory <= max))
                        newsort.add(note);
                    break;
                case "price":
                    if ((note.price >= min) && (note.price <= max))
                        newsort.add(note);
                    break;
                case "year":
                    if ((note.year >= min) && (note.year <= max))
                        newsort.add(note);
                    break;
                case "hdd_size":
                    if ((note.hdd_size >= min) && (note.hdd_size <= max))
                        newsort.add(note);
                    break;
            }

        }
        sorted_notes = newsort;
        return true;
    }
}