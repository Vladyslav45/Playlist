public class Media{
    private String name;
    private Type_list typeList;

    public Media(String name, Type_list typeList) {
        this.name = name;
        this.typeList = typeList;
    }

    @Override
    public String toString() {
        return typeList + " : " + name;
    }
}
