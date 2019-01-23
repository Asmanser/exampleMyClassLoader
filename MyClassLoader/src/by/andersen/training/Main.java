package by.andersen.training;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        MyClassLoader myClassLoader = new MyClassLoader(
"D:\\WORK\\Andersen\\exampleMyClassLoader\\MyClass.class");
        myClassLoader.cashLoad("by.andersen.training.MyClass");
        Class<?> aClass = myClassLoader.loadClass("by.andersen.training.MyClass");
        MyInterface o1 = (MyInterface) aClass.newInstance();
        o1.print();
        Class<?> bClass = myClassLoader.loadClass("by.andersen.training.MyClass");
        MyInterface o2 = (MyInterface) bClass.newInstance();
        o2.print();
    }

}
