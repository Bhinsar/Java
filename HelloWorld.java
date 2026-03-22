class HelloWorld {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        String name = "World";
        System.out.println("Hello, " + name + "!"); 
        name = name.replace("o", "Java");
        System.out.println("Hello, " + name + "!");
    }
}