package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
        Team myTeam = gradeDB.getMyTeam();
        String[] members = myTeam.getMembers();
        float total = 0;
        float head = 0;
        for (String utorid : members) {
            total += gradeDB.getGrade(utorid, course).getGrade();
            head += 1;
        }

        return total / head;
    }
}
