public class SeniorInstructor extends Instructor {

    private String hiringTeam;

    public SeniorInstructor(String name, String cohort, String moduleTeam, String hiringTeam) {
        super(name, cohort, moduleTeam);
        this.hiringTeam = hiringTeam;
    }

    public String getHiringTeam() {
        return hiringTeam;
    }

    public void setHiringTeam(String hiringTeam) {
        this.hiringTeam = hiringTeam;
    }
}
