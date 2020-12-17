public class Media{
    private String name;
    private TypeMedia typeList;

    public Media(String name, TypeMedia typeList) {
        this.name = name;
        this.typeList = typeList;
    }

    @Override
    public String toString() {
        return typeList + " : " + name;
    }
}
