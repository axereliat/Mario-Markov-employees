package app.services;

import app.entities.EmployeeRecord;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author axereliat on 4.10.22
 */
public class CalculationService {

    public long calculateOverlapDays(EmployeeRecord firstRecord, EmployeeRecord secondRecord) {
        if ((firstRecord.getStartDate().isBefore(secondRecord.getEndDate())
                || firstRecord.getStartDate().isEqual(secondRecord.getEndDate()))
                && (firstRecord.getEndDate().isAfter(secondRecord.getStartDate())
                || firstRecord.getEndDate().isEqual(secondRecord.getStartDate()))) {
            LocalDate periodStartDate =
                    firstRecord.getStartDate().isBefore(secondRecord.getStartDate()) ?
                            secondRecord.getStartDate() : firstRecord.getStartDate();

            LocalDate periodEndDate =
                    firstRecord.getEndDate().isBefore(secondRecord.getEndDate()) ?
                            firstRecord.getEndDate() : secondRecord.getEndDate();

            return Math.abs(ChronoUnit.DAYS.between(periodStartDate, periodEndDate));
        }

        return 0;
    }
}
