package com.farmer.x.utils;

import com.farmer.x.loaders.BytesTypeLoader;
import com.strobel.decompiler.Decompiler;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.PlainTextOutput;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class DecompilerUtils {

    public static String decompile(String classPath) {

        String decompileJava;

        try (StringWriter stringWriter = new StringWriter()) {

            final DecompilerSettings settings = DecompilerSettings.javaDefaults();

            Decompiler.decompile(
                    classPath,
                    new PlainTextOutput(stringWriter),
                    settings
            );
            decompileJava = stringWriter.toString();
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
        return decompileJava;
    }

    public static String decompile(byte[] classBytes) {

        String decompileJava;

        try (StringWriter stringWriter = new StringWriter()) {

            BytesTypeLoader bytesTypeLoader = new BytesTypeLoader(classBytes);

            String name = bytesTypeLoader.getName();

            final DecompilerSettings settings = DecompilerSettings.javaDefaults();

            settings.setTypeLoader(bytesTypeLoader);

            Decompiler.decompile(
                    name,
                    new PlainTextOutput(stringWriter),
                    settings
            );
            decompileJava = stringWriter.toString();
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
        return decompileJava;
    }

    public static String decompile(InputStream in) {
        try {
            return decompile(IOUtils.toByteArray(in));
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static byte[] read2Bytes(String filePath) throws IOException {
        return FileUtils.readFileToByteArray(new File(filePath));
    }
}
