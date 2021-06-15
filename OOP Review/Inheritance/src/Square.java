public class Square extends Shape{
    double side;

    public Square(double side, String name) {
        super(name);
        this.side = side;
    }

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public double getPerimeter() {
        return 4 * this.side;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj.getClass() != this.getClass()) {
            return false;
        }

        Square other = (Square) obj;
        if(!this.name.equals(other.name)) {
            return false;
        }

        if(this.side != other.side){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.side;
    }
}