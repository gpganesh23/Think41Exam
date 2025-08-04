package com.example.trail.coverter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * A custom JPA AttributeConverter to convert between Java's Instant and a String
 * representation in the database.
 * This is useful when the database column stores the timestamp as a human-readable
 * string instead of a numeric timestamp or a native TIMESTAMP type.
 */
@Converter
public class InstantToStringConverter implements AttributeConverter<Instant, String> {

    // Using a specific formatter for the new database string format with a space and a timezone offset.
    // The format 'yyyy-MM-dd HH:mm:ssXXX' handles the date, time, and UTC offset (+00:00).
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX").withZone(ZoneOffset.UTC);

    @Override
    public String convertToDatabaseColumn(Instant instant) {
        // If the Instant is null, store a null value in the database.
        if (instant == null) {
            return null;
        }
        // Format the Instant into the custom string format.
        return formatter.format(instant);
    }

    @Override
    public Instant convertToEntityAttribute(String s) {
        // If the database string is null or empty, return a null Instant object.
        if (s == null || s.isEmpty()) {
            return null;
        }
        try {
            // Parse the string from the database back into an Instant object.
            return Instant.from(formatter.parse(s));
        } catch (DateTimeParseException e) {
            // Handle parsing errors, e.g., if the format is unexpected.
            System.err.println("Failed to parse date string: " + s + " with error: " + e.getMessage());
            return null;
        }
    }
}
