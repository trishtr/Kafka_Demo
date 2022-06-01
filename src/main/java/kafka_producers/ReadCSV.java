package kafka_producers;


import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;

public class ReadCSV {

    private String csvFileName;
    private List patientList;

    public ReadCSV(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    public List ReadCSVFile() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(csvFileName));
            CsvToBean csvToBean = new CsvToBeanBuilder(csvReader)
                    .withType(Patients.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            patientList = csvToBean.parse();
        } catch (Exception FileNotFoundException) {
            System.out.println("files not found");
        }
        return patientList;
    }
}
