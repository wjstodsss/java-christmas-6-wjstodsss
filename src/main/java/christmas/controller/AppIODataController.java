package christmas.controller;

import christmas.model.counter.PointOfSale;
import christmas.view.OutputView;
import java.time.DayOfWeek;
import static christmas.model.event.BadgeAwardEvent.awardBadge;
import static christmas.model.event.ChristmasDDay.dDayDiscount;
import static christmas.model.event.FreeChampagneEvent.*;
import static christmas.model.event.MenuDiscountEvent.menuDiscount;
import static christmas.model.event.SpecialStarEvent.specialDiscount;
import static christmas.util.Date.getDayOfWeekFromDate;

public class AppIODataController {
    private String inputDate;
    private String inputOrder;
    private final OutputView outputView = new OutputView();
    private PointOfSale pointOfSale = new PointOfSale();
    private int totalAmount = 0;
    private int totalDiscountAmount = 0;
    private final int MIN_AMOUNT = 10000;
    private final String NOTHING = "없음";


    public AppIODataController() {
        visitInformationController();

        orderInformationController(inputOrder);

        freeAwardView(totalAmount);

        eventEntry(totalAmount);
        benefitsDetailsValue();
        benefitsDetailView();

        totalDiscountAmountOutputView();
        expectedDiscountedPaymentAmount();
        decemberBadgeAward();
    }

    public void visitInformationController() {
        VisitInformationController visitInformationController = new VisitInformationController();
        this.inputDate = visitInformationController.getDateInput();
        this.inputOrder = visitInformationController.getOrderInput();
    }

    public void orderInformationController(String inputOrder) {
        OrderInformationController orderInformationController = new OrderInformationController(inputOrder);
        this.totalAmount=orderInformationController.calculateTotalAmount();
    }

    public void eventEntry(int totalAmount) {
        if (totalAmount < MIN_AMOUNT) {
            outputView.printBoundaryEmptyLine();
            outputView.printBenefitsDetails();
            System.out.println(NOTHING);
        }
    }



    private void freeAwardView(int totalAmount) {
        outputView.printBoundaryEmptyLine();
        outputView.printFreeAward();
        outputView.printFreeAwardFormat(freeChampagneEvent(totalAmount));
    }


    private String freeChampagneEvent(int totalAmount) {
        if (validateFreeChampagne(totalAmount)) {
            return freeChampane() + " 1개";
        }
        return "없음";
    }

    private int dDayDiscount = 0;
    private int weekDiscount = 0;
    private int specialDiscount = 0;
    private int freeAward = 0;

    private void benefitsDetailsValue() {
        while (totalAmount >= MIN_AMOUNT) {
            outputView.printBoundaryEmptyLine();
            outputView.printBenefitsDetails();
            dDayDiscount = dDayDiscount(inputDate);
            weekDiscount = menuDiscount(inputDate, inputOrder);
            specialDiscount = specialDiscount(inputDate);
            freeAward = freeChampagneDiscount(totalAmount);
            break;
        }
    }

    private void benefitsDetailView() {
        dDayDiscountDetailView(dDayDiscount);
        weekendDiscountDetailView(weekDiscount, inputDate);
        weekdayDiscountDetailView(weekDiscount, inputDate);
        specialDiscountDetailView(freeAward);
        freeAwardDetailView(specialDiscount);
    }

    private void dDayDiscountDetailView(int dDayDiscount) {
        if (dDayDiscount != 0) {
            outputView.printDDayDiscount(dDayDiscount);
        }
    }

    private void weekendDiscountDetailView(int weekDiscount, String inputDate) {
        DayOfWeek dayOfWeek = getDayOfWeekFromDate(inputDate);
        if (weekDiscount != 0 && dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            outputView.printWeekendDiscount(weekDiscount);
        }
    }

    private void weekdayDiscountDetailView(int weekDiscount, String inputDate) {
        DayOfWeek dayOfWeek = getDayOfWeekFromDate(inputDate);
        if (weekDiscount != 0 && !dayOfWeek.equals(DayOfWeek.FRIDAY) && !dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            outputView.printWeekdayDiscount(weekDiscount);
        }
    }

    private void specialDiscountDetailView(int freeAward) {
        if (freeAward != 0) {
            outputView.printAwardEvent(freeAward);
        }
    }

    private void freeAwardDetailView(int specialDiscount) {
        if (specialDiscount != 0) {
            outputView.printSpecialDiscount(specialDiscount);
        }
    }

    private void totalDiscountAmountOutputView() {
        outputView.printBoundaryEmptyLine();
        outputView.printTotalBenefitsAmount();
        totalDiscountAmount();
        totalDiscountAmountZeroView();
        totalDiscountAmountView();
    }

    private void totalDiscountAmount() {
        totalDiscountAmount = dDayDiscount + weekDiscount + specialDiscount + freeAward;
    }

    private void totalDiscountAmountZeroView() {
        if (totalDiscountAmount == 0) {
            outputView.printTotalDiscountAmountZeroFormat();
        }
    }

    private void totalDiscountAmountView() {
        if (totalDiscountAmount != 0) {
            outputView.printTotalDiscountAmountFormat(totalDiscountAmount);
        }
    }

    private void expectedDiscountedPaymentAmount() {
        outputView.printBoundaryEmptyLine();
        outputView.printExpectedDiscountedPaymentAmount();
        outputView.printTotalAmountFormat(totalAmount - totalDiscountAmount);
    }

    private void decemberBadgeAward() {
        outputView.printBoundaryEmptyLine();
        outputView.printDecemberBadgeAward();
        String badge = awardBadge(totalDiscountAmount);
        outputView.printDecemberBadgeAward(badge);
    }
}


