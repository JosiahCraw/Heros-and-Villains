package Heroes_Villains.entities;

public class Item {

    public int id;
    public String name;
    public int count = 0;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
    //Setter
    public void setCount(int count) {
        this.count = count;
    }
}
