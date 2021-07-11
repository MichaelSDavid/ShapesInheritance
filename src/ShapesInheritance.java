@SuppressWarnings("unused")
abstract class Shape {
    protected double area, perimeter;

    protected void printInfo() {
        System.out.println("area = " + this.area
                + " perimeter = " + this.perimeter);
    }
}

@SuppressWarnings("unused")
class Quadrilateral extends Shape {
    @SuppressWarnings("FieldCanBeLocal")
    protected double width, height;

    public Quadrilateral() {}

    public Quadrilateral(double width, double height) {
        this.width = width;
        this.height = height;
        this.area = width * height;
        this.perimeter = 2 * (width + height);
    }

    public void printInfo() {
        if (!((this instanceof Square) || (this instanceof Rhombus)
                || (this instanceof Trapezoid))) {
            System.out.println("The width of this quadrilateral is = "
                    + this.width);
            System.out.println("The height of this quadrilateral is = "
                    + this.height);
        }
        super.printInfo();
    }
}

@SuppressWarnings("unused")
class Square extends Quadrilateral {
    public Square(double side) {
        super(side, side);
    }

    public void printInfo() {
        System.out.println("The side length of this square is = "
                + this.width);
        super.printInfo();
    }
}

@SuppressWarnings("unused")
class Rhombus extends Quadrilateral {
    public Rhombus(double base, double height) {
        super(base, height);
        this.area = base * height;
        this.perimeter = 4 * base;
    }

    public void printInfo() {
        System.out.println("The base of this rhombus is = "
                + this.width);
        System.out.println("The height of this rhombus is = " + this.height);
        super.printInfo();
    }
}

@SuppressWarnings("unused")
class Trapezoid extends Quadrilateral {
    public Trapezoid(double base1, double base2,
                     double height, double legLeft, double legRight) {
        super(base1, height);
        this.area = height * (base1 + base2) / 2;
        this.perimeter = base1 + base2 + legLeft + legRight;
    }

    public void printInfo() {
        System.out.println("The lower base of this trapezoid is = "
                + this.width);
        System.out.println("The higher base of this trapezoid is = "
                + ((2 * this.area) / this.height - this.width));
        System.out.println("The height of this trapezoid is = "
                + this.height);
        super.printInfo();
    }
}

@SuppressWarnings("unused")
class Ellipse extends Shape {
    @SuppressWarnings("FieldCanBeLocal")
    protected double sMinAxis, sMajAxis, h;

    public Ellipse() {}

    public Ellipse(double sMinAxis, double sMajAxis) {
        this.sMinAxis = sMinAxis;
        this.sMajAxis = sMajAxis;
        this.h = Math.pow(sMajAxis - sMinAxis, 2) / Math.pow(sMajAxis + sMinAxis, 2);
        this.area = Math.PI * sMinAxis * sMajAxis;
        this.perimeter = Math.PI * (sMajAxis + sMinAxis) * ((135168 - 85760 * h - 5568 * Math.pow(h, 2)
                + 3867 * Math.pow(h, 3)) / (135168 - 119552 * h
                + 22208 * Math.pow(h, 2) - 345 * Math.pow(h, 3)));
    }

    public void printInfo() {
        if (!(this instanceof Circle)) {
            System.out.println("The semi-minor axis of this ellipse is = "
                    + this.sMinAxis);
            System.out.println("The semi-major axis of this ellipse is = "
                    + this.sMajAxis);
        }
        super.printInfo();
    }
}

@SuppressWarnings("unused")
class Circle extends Ellipse {
    @SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})

    public Circle(double radius) {
        super(radius, radius);
    }

    public void printInfo() {
        System.out.println("The radius of this circle is = "
                + this.sMinAxis);
        super.printInfo();
    }
}

@SuppressWarnings("unused")
class Triangle extends Shape {
    @SuppressWarnings("FieldCanBeLocal")
    protected double base, height, sideLeft, sideRight;

    public Triangle() {}

    public Triangle(double base, double sideLeft, double sideRight) {
        this.base = base;
        this.sideLeft = sideLeft;
        this.sideRight = sideRight;
        this.area = Math.sqrt(((sideLeft + sideRight + base) / 2)
                * (((sideLeft + sideRight + base) / 2) - sideLeft)
                * (((sideLeft + sideRight + base) / 2) - sideRight)
                * (((sideLeft + sideRight + base) / 2) - base));
        this.perimeter = sideLeft + sideRight + base;
    }

    public void printInfo() {
        if (!(this instanceof RightAngledTriangle)) {
            System.out.println("The base of the triangle is = "
                    + this.base);
            System.out.println("The left-diagonal side of the triangle is = "
                    + this.sideLeft);
            System.out.println("The right-diagonal side of the triangle is = "
                    + this.sideRight);
            System.out.println("The height of the triangle is = "
                    + this.height);
        }
        super.printInfo();
    }
}

@SuppressWarnings("unused")
class RightAngledTriangle extends Triangle {
    @SuppressWarnings("SuspiciousNameCombination")
    public RightAngledTriangle(double base, double height) {
        this.base = base;
        this.sideLeft = height;
        this.area = (base * height) / 2;
        this.perimeter = base + height + Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    }

    public void printInfo() {
        System.out.println("The base of the right-triangle is = "
                + this.base);
        System.out.println("The height of the right-triangle is = "
                + this.sideLeft);
        super.printInfo();
    }
}

@SuppressWarnings("unused")
public class ShapesInheritance {
    // Driver (TEMP)
    public static void main(String[] args) {
        Quadrilateral q = new Quadrilateral(1,2);
        q.printInfo();
    }
}
