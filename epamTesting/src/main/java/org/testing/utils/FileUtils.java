package org.testing.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static String readFileToString(String filePath) {
        try (var lines = Files.lines(Paths.get(filePath))) {
            return lines.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            logger.error("Error reading file: {} - {}", filePath, e.getMessage());
            return null;
        }
    }
}

