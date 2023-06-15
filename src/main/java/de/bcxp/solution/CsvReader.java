package de.bcxp.solution;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class CsvReader {
    public List<String[]> read(File file, char separator) {
        CSVReader reader = null;
        List<String[]> data = null;

        try {
            // Build reader
            reader = new CSVReaderBuilder(new FileReader(file))
                    .withCSVParser(new CSVParserBuilder()
                            .withSeparator(separator)
                            .build())
                    .build();

            // Read file and save data
            data = reader.readAll();

            // close reader
            if (reader != null) {
                reader.close();
            }
        } catch (Exception e) {
            System.out.printf("Error reading file. Error message: %s\n", e.getMessage());
        }
        return data;
    }
}
