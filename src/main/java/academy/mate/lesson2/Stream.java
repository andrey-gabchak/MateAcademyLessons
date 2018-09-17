package academy.mate.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Stream<T> {

    private Iterable<T> entry;

    public Stream(Iterable<T> entry) {
        this.entry = entry;
    }

    public Stream<T> filter(Predicate<T> p) {
        List<T> workList = new ArrayList<>();

        for (T t : entry) {
            if (p.test(t)) { //абстрактный класс предиката, благодаря которому можно использовать ->
                workList.add(t);
            }
        }
        return Stream.of(workList);
    }

    public List<T> toList() {
        List<T> workList = new ArrayList<>();
        for (T t : entry) {
            workList.add(t);
        }
        return workList;
    }




    private static <T> Stream<T> of(List<T> entry) {
        return new Stream<>(entry);
    }

    public <R> Stream<R> map(Function<T, R> f) {
        List<R> workList = new ArrayList<>();
        for (T t : entry) {
            workList.add(f.apply(t));
        }
        return Stream.of(workList);
    }

    public Optional<T> findFirst() {
        T t = entry.iterator().hasNext() ? entry.iterator().next() : null;

        return Optional.ofNullable(t); //Optional - обертка которая позволяет избежать null в чистом виде.
    }

    public void forEach(Consumer<T> c) {
        for (T t : entry) {
            c.accept(t); //accept реализуется в ->
        }
    }

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Alex");
        names.add("Dmitry");
        names.add("Natasha");

        /*List<Integer> result = Stream.of(names)
                .filter(n -> n.length() > 4)
                .map(string::length) //string to Integer. map(string::length) - обращение к методу string.length();
                .toList();*/

        String result = Stream.of(names)
                .filter(n -> n.length() > 4)
                .findFirst()
//                .orElse(getAlternativeString()); //-будет вызываться sout "TROLOLOLO", но не будет "alternative string"
                .orElseGet(() -> getAlternativeString()); //будет работать корректно. -> отложенное действие
        /**Если используется исполняемый метод, то лучше использовать .orElseGet().
         *  Для примитивов и string можно использовать .orElse().*/

        Stream.of(names)
                .filter(n -> n.length() > 4)
                .forEach(n -> System.out.println(n));


        /*List<string> list = new ArrayList<>();
        list.add("Alex");
        list.add("Dmitry");
        list.add("Vadim");
        List<Integer> result = list.stream()
                .filter(n -> n.length() > 4)
                .map(string::length)
                .collect(toList());

        Integer result2 = list.stream()
                .filter(n -> n.length() > 4)
                .map(string::length)
                .reduce(0, (l1, l2) -> l1 + l2);*/




    }

    private static String getAlternativeString() {
        System.out.println("TROLOLOLOLO");
        System.out.println("TROLOLOLOLO");
        System.out.println("TROLOLOLOLO");
        System.out.println("TROLOLOLOLO");
        System.out.println("TROLOLOLOLO");
        return "alternative string";
    }

}
