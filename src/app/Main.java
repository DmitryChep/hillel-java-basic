package app;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = {
                new Rhombus(3.3, 2.5),
                new Trapezoid(3, 4, 3.5),
                new Circle(2),
                new Square(4),
                new Triangle(2,4,5)};
        double totalAreaFigures = TotalArea.getTotalAreaFigures(figures);
        for (Figure i: figures){
            Print.printResults(i.getClass().getSimpleName(), i.getAreaFigure());
        }
        Print.printTotalAreaFigures(totalAreaFigures);
    }
}

interface Figure {
    double getAreaFigure();
}

class Rhombus implements Figure {
    private double rhombusDiagonal_a;
    private double rhombusDiagonal_b;

    public Rhombus(double rhombusDiagonal1, double diagonalRhombus2) {
        this.rhombusDiagonal_a = rhombusDiagonal1;
        this.rhombusDiagonal_b = diagonalRhombus2;
    }

    public void setDiagonalRhombus1(double diagonalRhombus1) {
        this.rhombusDiagonal_a = diagonalRhombus1;
    }

    public double getDiagonalRhombus1() {
        return rhombusDiagonal_a;
    }

    public void setRhombusDiagonal_b(double rhombusDiagonal_b) {
        this.rhombusDiagonal_b = rhombusDiagonal_b;
    }

    public double getRhombusDiagonal_b() {
        return rhombusDiagonal_b;
    }

    @Override
    public double getAreaFigure() {
        return (rhombusDiagonal_a * rhombusDiagonal_b) / 2;
    }
}

class Trapezoid implements Figure {
    private double topTrapezoid;
    private double baseTrapezoid;
    private double highTrapezoid;

    public Trapezoid(double topTrapezoid, double baseTrapezoid, double highTrapezoid) {
        this.topTrapezoid = topTrapezoid;
        this.baseTrapezoid = baseTrapezoid;
        this.highTrapezoid = highTrapezoid;
    }

    public void setTopTrapezoid(double topTrapezoid) {
        this.topTrapezoid = topTrapezoid;
    }

    public double getTopTrapezoid() {
        return topTrapezoid;
    }

    public void setBaseTrapezoid(double baseTrapezoid) {
        this.baseTrapezoid = baseTrapezoid;
    }

    public double getBaseTrapezoid() {
        return baseTrapezoid;
    }

    public void setHighTrapezoid(double highTrapezoid) {
        this.highTrapezoid = highTrapezoid;
    }

    public double getHighTrapezoid() {
        return highTrapezoid;
    }


    @Override
    public double getAreaFigure() {
        return (baseTrapezoid + topTrapezoid) * highTrapezoid / 2;
    }
}

class Circle implements Figure {
    private double diameterCircle;

    public Circle(double diameterCircle) {
        this.diameterCircle = diameterCircle;
    }

    public void setDiameterCircle(double diameterCircle) {
        this.diameterCircle = diameterCircle;
    }

    public double getDiameterCircle() {
        return diameterCircle;
    }

    @Override
    public double getAreaFigure() {
        return (Math.PI * Math.pow(diameterCircle,2))/4;
    }
}

class Square implements Figure{
    private double squareSide;

    public Square(double squareSide){
        this.squareSide = squareSide;
    }

    public void setSquareSide(double squareSide) {
        this.squareSide = squareSide;
    }

    public double getSquareSide() {
        return squareSide;
    }

    @Override
    public double getAreaFigure() {
        return squareSide * squareSide;
    }
}

class Triangle implements Figure {
    private double triangleSide_a;
    private double triangleSide_b;
    private double triangleSide_c;

    public Triangle(double triangleSide_a, double triangleSide_b, double triangleSide_c) {
        this.triangleSide_a = triangleSide_a;
        this.triangleSide_b = triangleSide_b;
        this.triangleSide_c = triangleSide_c;
    }

    public void setTriangleSide_a(double triangleSide_a) {
        this.triangleSide_a = triangleSide_a;
    }

    public double getTriangleSide_a() {
        return triangleSide_a;
    }

    public void setTriangleSide_b(double triangleSide_b) {
        this.triangleSide_b = triangleSide_b;
    }

    public double getTriangleSide_b() {
        return triangleSide_b;
    }

    public void setTriangleSide_c(double triangleSide_c) {
        this.triangleSide_c = triangleSide_c;
    }

    public double getTriangleSide_c() {
        return triangleSide_c;
    }

    @Override
    public double getAreaFigure() {
        double semiperimeter = (triangleSide_a + triangleSide_b + triangleSide_c)/2;
        return Math.sqrt(semiperimeter * (semiperimeter - triangleSide_a) *
                (semiperimeter - triangleSide_b) * (semiperimeter - triangleSide_c));
    }
}

class TotalArea {
    public static double getTotalAreaFigures(Figure[] figures) {
        double totalAreaFigures = 0;
        for (Figure i: figures) {
            totalAreaFigures += i.getAreaFigure();
        }
        return totalAreaFigures;
    }
}

class Print {
    public static void printResults(String figure, double areaFigures) {
        System.out.printf("Area of %s: %.2f\n",figure , areaFigures);

    }
    public static void printTotalAreaFigures(double totalAreaFigures) {
        System.out.printf("Total area of figures: %.2f",totalAreaFigures);
    }
}