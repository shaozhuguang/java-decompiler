# java-decompiler
java反编译


### 简要说明
 + 1、该库主要是封装了procyon相关的反编译库，这个库可以处理Java1.8的代码。
 + 2、该库补充了procyon没有处理InputStream及byte[]的情况。
 


### 使用方法

详细可参考test.com.farmer.x.DecompilerTest
```java
String customClassFile = classPath + "CompilerAndJarTools.class";
String decompileJava = DecompilerUtils.decompile(customClassFile);
System.out.printf("\r\n----- %s 反编译结果： -----\r\n\r\n", customClassFile);
System.out.println(decompileJava);
```
