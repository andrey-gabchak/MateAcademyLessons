package academy.mate.lesson3;

public class Cat {

    private String name;
    private String breed;

    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (name != null ? !name.equals(cat.name) : cat.name != null) return false;
        return breed != null ? breed.equals(cat.breed) : cat.breed == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (breed != null ? breed.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska", "regular");
        Cat cat2 = new Cat("Vaska", "regular");

        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());



    }
}
