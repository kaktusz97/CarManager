package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {

    private static final String DELIMITER = ",";
    private static final String[] DELIMITER_PATTERN = {DELIMITER, ""};

    private FileHandler() {
    }

    public static void writeOut(List<List<String>> rows, String path) {
        String writable = createWritable(rows);
        writeToFile(writable, path);
    }

    private static String createWritable(List<List<String>> rows) {
        StringBuilder builder = new StringBuilder();
        String[] lineEndPattern = {System.lineSeparator(), ""};
        for (int i = 0; i < rows.size(); i++) {
            addRow(rows.get(i), builder);
            builder.append(lineEndPattern[(i + 1) / rows.size()]);
        }
        return builder.toString();
    }

    private static void addRow(List<String> row, StringBuilder builder) {
        for (int i = 0; i < row.size(); i++) {
            builder.append(row.get(i));
            builder.append(DELIMITER_PATTERN[(i + 1) / row.size()]);
        }
    }

    private static void writeToFile(String writable, String path) {
        try ( FileWriter writer = new FileWriter(path)) {
            writer.write(writable);
        } catch (IOException ex) {
        }
    }

    public static List<List<String>> readIn(String path) {
        List<List<String>> result = new ArrayList<>();
        try ( BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String rawRow;
            while ((rawRow = reader.readLine()) != null) {
                List<String> nextRow = readRow(rawRow);
                result.add(nextRow);
            }
        } catch (IOException ex) {
        }
        return result;
    }

    private static List<String> readRow(String rawRow) {
        List<String> result = new ArrayList<>();
        String[] rowArray = rawRow.split(DELIMITER);
        fillList(result, rowArray);
        return result;
    }

    private static void fillList(List<String> result, String[] row) {
        result.addAll(Arrays.asList(row));
    }
}
