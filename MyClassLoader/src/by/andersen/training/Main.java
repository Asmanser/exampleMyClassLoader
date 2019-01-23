package by.andersen.training;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        MyClassLoader myClassLoader1 = new MyClassLoader(
"D:\\WORK\\Andersen\\MyClass.class");
        myClassLoader1.cashLoad("by.andersen.training.MyClass");
        Class<?> aClass1 = myClassLoader1.loadClass("by.andersen.training.MyClass");
        MyInterface o = (MyInterface) aClass1.newInstance();
        o.print();
        MyClassLoader myClassLoader2 = new MyClassLoader("" +
                "D:\\WORK\\Andersen\\exampleAlgorithms\\Algorithms\\out\\production\\Algorithms\\by\\andersen\\training\\QuickSort\\QuickSort.class");
        myClassLoader2.cashLoad("by.andersen.training.QuickSort.QuickSort");
        Class<?> aClass2 = myClassLoader2.loadClass("by.andersen.training.QuickSort.QuickSort");
        Object o1 = aClass2.newInstance();

        Class<?> bClass = myClassLoader2.loadClass("by.andersen.training.QuickSort.QuickSort");
        Object o2 = bClass.newInstance();
    }

}
