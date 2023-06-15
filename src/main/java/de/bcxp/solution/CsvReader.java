package de.bcxp.solution;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class CsvReader {
    public List<String[]> read(File file, char separator) throws Exception {
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
        } catch (Exception e) {


        } finally {
            // close reader
            if (reader != null) {
                reader.close();
            }
        }

        return data;
    }

    //TODO maybe implement interface for file reader (?)
}
