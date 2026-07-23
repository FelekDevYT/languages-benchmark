package me.felek.fenix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

/**
 * @className: CommandUtils
 * @author: Felek
 * @date: 23.07.2026 13:16
 */

public class CommandUtils {
    public static long getCommandExecutionMillis(String cmd) throws IOException, InterruptedException {
        List<String> parts = new ArrayList<>();
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("win")) {
            parts.add("cmd");
            parts.add("/c");
            parts.add(cmd);
        } else {
            parts.add("/bin/sh");
            parts.add("-c");
            parts.add(cmd);
        }

        long current = System.nanoTime();
        ProcessBuilder pb = new ProcessBuilder(parts).inheritIO();
        int code = pb.start().waitFor();
        if (code != 0) {
            throw new RuntimeException("Critical error while executing command: " + cmd + " with exit code: " + code);
        }
        long end = System.nanoTime();
        return (end - current) / 1000000;
    }
}
