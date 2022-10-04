package app.entities;

public class ResultItem {

    private Integer firstEmployeeId;

    private Integer secondEmployeeId;

    private Integer projectId;

    private long daysTogether;

    public ResultItem(Integer firstEmployeeId, Integer secondEmployeeId, Integer projectId, long daysTogether) {
        this.firstEmployeeId = firstEmployeeId;
        this.secondEmployeeId = secondEmployeeId;
        this.projectId = projectId;
        this.daysTogether = daysTogether;
    }

    public Integer getFirstEmployeeId() {
        return this.firstEmployeeId;
    }

    public void setFirstEmployeeId(Integer firstEmployeeId) {
        this.firstEmployeeId = firstEmployeeId;
    }

    public Integer getSecondEmployeeId() {
        return this.secondEmployeeId;
    }

    public void setSecondEmployeeId(Integer secondEmployeeId) {
        this.secondEmployeeId = secondEmployeeId;
    }

    public long getDaysTogether() {
        return this.daysTogether;
    }

    public void setDaysTogether(long daysTogether) {
        this.daysTogether = daysTogether;
    }

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
