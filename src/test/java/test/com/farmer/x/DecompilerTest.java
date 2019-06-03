package test.com.farmer.x;


import com.farmer.x.utils.DecompilerUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class DecompilerTest {

    private String classPath;

    @Before
    public void init() {
        URL targetClasses = this.getClass().getClassLoader().getResource("");
        File file = new File(targetClasses.getPath());
        classPath = file.getParent() + File.separator + "classes" + File.separator;
    }

    @Test
    public void testInnerClass() {
        String innerClass = "java.io.StringWriter";
        String decompileJava = DecompilerUtils.decompile(innerClass);
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", innerClass);
        System.out.println(decompileJava);
    }

    @Test
    public void testCustomClass() {
        String customClass = "com.farmer.x.samples.ReadTools";
        String decompileJava = DecompilerUtils.decompile(customClass);
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", customClass);
        System.out.println(decompileJava);
    }

    @Test
    public void testCustomClassFile() {
        String customClassFile = classPath + "com/farmer/x/samples/PrintTools.class";
        String decompileJava = DecompilerUtils.decompile(customClassFile);
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", customClassFile);
        System.out.println(decompileJava);
    }

    @Test
    public void testCustomClassBytes() throws IOException {
        String customClassFile = classPath + "com/farmer/x/samples/ReadTools.class";
        String decompileJava = DecompilerUtils.decompile(DecompilerUtils.read2Bytes(customClassFile));
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", customClassFile);
        System.out.println(decompileJava);
    }

    @Test
    public void testCustomClassInputStream() throws FileNotFoundException {
        String customClassFile = classPath + "com/farmer/x/samples/ReadTools.class";
        String decompileJava = DecompilerUtils.decompile(new FileInputStream(customClassFile));
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", customClassFile);
        System.out.println(decompileJava);
    }

    @Test
    public void testOutClassFile() {
        String customClassFile = classPath + "CompilerAndJarTools.class";
        String decompileJava = DecompilerUtils.decompile(customClassFile);
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", customClassFile);
        System.out.println(decompileJava);
    }

    @Test
    public void testOutClassFileBytes() throws IOException {
        String customClassFile = classPath + "CompilerAndJarTools.class";
        String decompileJava = DecompilerUtils.decompile(DecompilerUtils.read2Bytes(customClassFile));
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", customClassFile);
        System.out.println(decompileJava);
    }
}
