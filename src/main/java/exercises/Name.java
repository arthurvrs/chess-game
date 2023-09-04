package exercises;

public class Name {

    String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        Name otherName = (Name)object;
        return name == otherName.name;
    }

    @Override
    public int hashCode() {
        return name.hashCode()*7;
    }
}
