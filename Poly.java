class Car {
    public void soundHorn() {
        System.out.println("Beep Beep!");
    }
}

class Maruti extends Car {
    @Override
    public void soundHorn() {
        System.out.println("Maruti Horn: Beep Beep!");
    }
}

class Calculator {
    // Overloading: Same name, different inputs
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

class Poly {
    public static void main(String[] args) {
        Maruti myCar = new Maruti();
        myCar.soundHorn(); // Outputs: Maruti Horn: Beep Beep!

        Calculator calc = new Calculator();
        System.out.println("Integer Addition: " + calc.add(5, 10)); // Outputs: 15
        System.out.println("Double Addition: " + calc.add(5.5, 10.2)); // Outputs: 15.7
        demonstrate();
    }

    public void demonstrate() {
        System.out.println("This is a demonstration of polymorphism.");
    }
}