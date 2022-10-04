package app;

import app.core.ConsoleWriter;
import app.core.Runnable;
import app.core.Engine;
import app.core.Writer;
import app.services.CalculationService;
import app.services.EmployeeRecordService;

public class Main {

    public static void main(String[] args) {
        Writer writer = new ConsoleWriter();
        CalculationService calculationService = new CalculationService();
        EmployeeRecordService employeeRecordService = new EmployeeRecordService();

        Runnable engine = new Engine(writer, employeeRecordService, calculationService);

        engine.run();
    }
}
