package org.lili.jdk;

/**
 * @author lili
 * @date 2020/8/29 19:13
 * @description
 * @notes
 */
class ConstructOnce {
    static private boolean runOnce = false;

    public ConstructOnce() {
        if (runOnce) throw new IllegalStateException("run twice");
        runOnce = true;
    }
}

public class SimpleClassLoader extends ClassLoader {
    String[] directories;

    public SimpleClassLoader(String path) {
        directories = path.split(";");
    }

    public SimpleClassLoader(String path, ClassLoader parent) {
        super(parent);
        directories = path.split(";");
    }

    public synchronized Class findClass(String name) throws ClassNotFoundException {
        for (int i = 0; i < directories.length; i++) {
            byte[] buf = getClassData(directories[i], name);
            if (buf != null) return defineClass(name, buf, 0, buf.length);
        }
        throw new ClassNotFoundException();
    }

    protected byte[] getClassData(String directory, String fileName) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        SimpleClassLoader CL1 = new SimpleClassLoader("testclasses");
        Class c1 = CL1.loadClass("ConstructOnce");
        SimpleClassLoader CL2 = new SimpleClassLoader("testclasses");
        Class c2 = CL2.loadClass("ConstructOnce");
        Object x = c1.newInstance();
        try {
            Object y = c1.newInstance();
            throw new RuntimeException("Test Fails!!!");
        } catch (IllegalStateException e) {
        }
        Object z = c2.newInstance();
    }

}
