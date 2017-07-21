package com.cft.pts.curr.service;

import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Generate names for physical files.
 * Created by Andrey.Tsvetkov on 7/20/2017.
 */
public class FileNameUtils {

    public static final int UUID_LENGTH = 5;
    public static final String DATE_TIME_PATTERN = "yyyy-MM-ddHHmmssSSS";
    public static final String SEPARATOR = "-";

    /**
     * Generates file names based on predefined pattern for stored PhysicalFiles.
     *
     * @param prefix
     * @return
     */
    public static String createFileName(String prefix) {
        Assert.hasText(prefix, "File name prefix should not be empty");
        StringBuilder buffer = new StringBuilder();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

        String formattedDateTime = dateTime.format(formatter);
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.substring(0, UUID_LENGTH);

        return buffer.append(prefix).append(SEPARATOR).append(formattedDateTime).append(SEPARATOR).append(uuid).toString();

    }

}
