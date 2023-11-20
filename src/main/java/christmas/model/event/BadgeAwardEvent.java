package christmas.model.event;

public class BadgeAwardEvent {
    private static final String SANTA_BADGE = "산타";
    private static final String TREE_BADGE = "트리";
    private static final String STAR_BADGE = "별";
    private static final String NOTHING = "없음";


    public static String awardBadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= 20000) {
            return SANTA_BADGE;
        }
        if (totalBenefitAmount >= 10000) {
            return TREE_BADGE;
        }
        if (totalBenefitAmount >= 5000) {
            return STAR_BADGE;
        }
        return NOTHING;
    }
}
