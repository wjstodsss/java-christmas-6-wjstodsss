package christmas.model.event;

public class BadgeAwardEvent {
    public static String awardBadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= 20000) {
            return "산타";
        }
        if (totalBenefitAmount >= 10000) {
            return "트리";
        }
        if (totalBenefitAmount >= 5000) {
            return "별";
        }
        return "없음";
    }
}
