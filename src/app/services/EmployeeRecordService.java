package app.services;

import app.entities.EmployeeRecord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author axereliat on 3.10.22
 */
public class EmployeeRecordService {

    public List<EmployeeRecord> readEmployeeRecordData() throws IOException {

        String line = "";
        String splitBy = ", ";

        List<EmployeeRecord> employeeRecords = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("src/app/resources/data.csv"));
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(splitBy);

            int employeeId = Integer.parseInt(tokens[0]);
            int projectId = Integer.parseInt(tokens[1]);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

            LocalDate startDate;
            if (tokens[2].equalsIgnoreCase("null")) {
                startDate = LocalDate.now();
            } else {
                startDate = LocalDate.parse(tokens[2], formatter);
            }

            LocalDate endDate;
            if (tokens[3].equalsIgnoreCase("null")) {
                endDate = LocalDate.now();
            } else {
                endDate = LocalDate.parse(tokens[3], formatter);
            }
            EmployeeRecord employee = new EmployeeRecord(employeeId, projectId, startDate, endDate);

            employeeRecords.add(employee);
        }

        return employeeRecords;
    }
}
