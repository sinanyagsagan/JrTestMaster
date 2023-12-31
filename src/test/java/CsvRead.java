import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CsvRead {
    private static final Logger log = LogManager.getLogger(CsvRead.class);

    public List<CSVRecord> readDataFromCSV(String filePath) throws IOException {
        try(Reader reader = new FileReader(filePath)) {
            CSVParser csvParser = CSVFormat.DEFAULT.parse(reader);
            return csvParser.getRecords();
        }
    }

    public String readData() throws IOException {
        List<CSVRecord> records =
                readDataFromCSV("C:\\Users\\SinanYagsagan\\Desktop\\JrTestMaster\\src\\test\\resources\\testData.csv");

        for (CSVRecord record : records){
            log.info("Read data from CSV: {}"+ record.get(0));
            return record.get(0);
        }
        return null;
    }
}
