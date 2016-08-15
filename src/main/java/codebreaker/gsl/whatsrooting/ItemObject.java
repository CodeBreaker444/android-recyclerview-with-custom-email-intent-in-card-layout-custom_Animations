package codebreaker.gsl.whatsrooting;

public class ItemObject {

    private String name,Desc;
    private int photo;

    public ItemObject(String name,  String Desc, int photo) {
        this.name = name;
        this.Desc = Desc;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc ;
    }


    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
