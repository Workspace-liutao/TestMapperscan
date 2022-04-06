package mapperscan.classload;

import mapperscan.service.Impl.Telephone2ProductImpl;

import java.io.*;

/**
 * Created by zejian on 2017/6/18.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
//自定义ClassLoader，完整代码稍后分析
class FileClassLoader extends ClassLoader {
    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    // 编写获取类的字节码并创建class对象的逻辑
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] a = this.getClassData(name);
        return defineClass(a, 0, a.length);
    }

    //编写读取字节流的方法
    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        ByteArrayOutputStream baos = null;
        InputStream ins = null;
        try {
            ins = new FileInputStream(new File(path));
            baos = new ByteArrayOutputStream();
            byte[] bufferByte = new byte[1024];
            int max = 0;
            while ((max = ins.read(bufferByte)) != -1) {
                baos.write(bufferByte, 0, max);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }

    /**
     * 类文件的完全路径
     *
     * @param className
     * @return
     */
    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) throws ClassNotFoundException {

        String rootDir = "D:/code/spring-customized-master/spring-aop/target/classes";
        //创建自定义文件类加载器
        FileClassLoader loader = new FileClassLoader(rootDir);

        try {
            //加载指定的class文件
            Class<?> object1 = loader.loadClass("com.baomw.dao.IndexDao");
           System.out.println(object1.newInstance().toString());

            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

