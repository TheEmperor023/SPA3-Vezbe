package Vezbe1;

public class Vertex{
    int infor;

    Vertex(int infor){
        this.infor = infor;
    }

    @Override
    public int hashCode() {
        return this.infor;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
