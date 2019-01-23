package by.andersen.training;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyClassLoader extends ClassLoader {

    private Map<String,Class<?>> cash = new HashMap<>();
    private String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    /*private Map<String,String> classes = new HashMap<>();

    public MyClassLoader(Map<String,String> classes) {
        this.classes = classes;
    }*/

    public void cashLoad(String name) {
        try {
            FileInputStream fin = new FileInputStream(path);
            byte[] bbuf = new byte[(int) (new File(path).length())];
            fin.read(bbuf);
            fin.close();
            this.cash.put(name,defineClass(name, bbuf, 0, bbuf.length));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(cash.containsKey(name)) {
            return cash.get(name);
        }
        return super.loadClass(name);

    }
}
