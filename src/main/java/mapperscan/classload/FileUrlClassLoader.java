package mapperscan.classload;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class FileUrlClassLoader extends URLClassLoader {
    public FileUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public FileUrlClassLoader(URL[] urls) {
        super(urls);
    }

    public static void main(String[] args) throws Exception {
        String rootDir = "D:/code/spring-customized-master/spring-aop/target/classes";
        //创建自定义文件类加载器
        File file = new File(rootDir);
        //File to URI
        URI uri = file.toURI();
        URL[] urls = {uri.toURL()};
        FileUrlClassLoader loader = new FileUrlClassLoader(urls);
        Class classs = loader.loadClass("com.baomw.dao.IndexDao");

    }

}
