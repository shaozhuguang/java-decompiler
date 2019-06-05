package test.com.farmer.x;


import com.farmer.x.utils.DecompilerUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.List;

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

    @Test
    public void testOutJarFile() throws Exception {
        String jarFile = classPath + "contract.jar";
        String decompileJava = DecompilerUtils.decompileJarFile(jarFile, "com/jd/blockchain/contract/AssetContractImpl", true, null);
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", jarFile);
        System.out.println(decompileJava);
    }

    @Test
    public void readJarFile() throws Exception {
        String jarFile = classPath + "contract.jar";
        String decompileJava = DecompilerUtils.decompileJarFile(jarFile, DecompilerUtils.MANIFEST_MF, false, null);
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", jarFile);
        System.out.println(decompileJava);
    }

    @Test
    public void readManiFestFromJarFile() throws Exception {
        String jarFile = classPath + "contract.jar";
        List<String> decompileJava = DecompilerUtils.readManifest2Array(jarFile, null);
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", jarFile);
        for (String content : decompileJava) {
            System.out.println(content);
        }
    }

    @Test
    public void testMainClassFromJarFile() throws Exception {
        String jarFile = classPath + "contract.jar";
        String decompileJava = DecompilerUtils.decompileMainClassFromJarFile(jarFile);
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", jarFile);
        System.out.println(decompileJava);
    }

    @Test
    public void testMainClassFromBytes() throws Exception {
        String jarFile = classPath + "contract.jar";
        byte[] content = DecompilerUtils.read2Bytes(jarFile);
        String decompileJava = DecompilerUtils.decompileMainClassFromBytes(content);
        System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", jarFile);
        System.out.println(decompileJava);
    }
}
