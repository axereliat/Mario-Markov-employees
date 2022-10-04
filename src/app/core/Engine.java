package app.core;

import app.entities.EmployeeRecord;
import app.entities.ResultItem;
import app.services.CalculationService;
import app.services.EmployeeRecordService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Engine implements Runnable {

    private final Writer writer;
    private final EmployeeRecordService employeeRecordService;
    private final CalculationService calculationService;

    public Engine(Writer writer, EmployeeRecordService employeeRecordService, CalculationService calculationService) {
        this.writer = writer;
        this.employeeRecordService = employeeRecordService;
        this.calculationService = calculationService;
    }

    @Override
    public void run() {
        List<ResultItem> matchedRecords = new ArrayList<>();

        Map<String, Long> resultMap = new HashMap<>();

        try {
            List<EmployeeRecord> employeeRecords = employeeRecordService.readEmployeeRecordData();

            for (int i = 0; i < employeeRecords.size() - 1; i++) {
                EmployeeRecord currentRecord = employeeRecords.get(i);
                for (int j = i + 1; j < employeeRecords.size(); j++) {
                    EmployeeRecord nextRecord = employeeRecords.get(j);

                    if (currentRecord.getProjectId().equals(nextRecord.getProjectId())) {
                        long daysTogether = calculationService.calculateOverlapDays(currentRecord, nextRecord);
                        if (daysTogether > 0) {
                            ResultItem ri = new ResultItem(currentRecord.getId(), nextRecord.getId(),
                                    currentRecord.getProjectId(), daysTogether);
                            String mapKey = ri.getFirstEmployeeId().toString() + ", " + ri.getSecondEmployeeId().toString();

                            long previousDaysTogether = resultMap.containsKey(mapKey) ? resultMap.get(mapKey) : 0;

                            resultMap.put(mapKey, previousDaysTogether + ri.getDaysTogether());

                            matchedRecords.add(ri);
                            break;
                        }
                    }
                }
            }
            if (!resultMap.entrySet().isEmpty()) {
                Map.Entry<String, Long> entry = resultMap.entrySet().stream()
                        .min((a, b) -> b.getValue().compareTo(a.getValue())).get();

                writer.write(String.format("%s, %d%n", entry.getKey(), entry.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
