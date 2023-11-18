package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.counter.OrderValidator;
import christmas.model.counter.PointOfSale;
import christmas.view.InputView;
import christmas.view.OutputView;


import java.time.DayOfWeek;
import java.util.Iterator;

import static christmas.model.counter.PointOfSale.itemsSet;
import static christmas.model.counter.PointOfSale.quantitiesList;
import static christmas.model.event.BadgeAwardEvent.awardBadge;
import static christmas.model.event.ChristmasDDay.dDayDiscount;
import static christmas.model.event.FreeChampagneEvent.*;
import static christmas.model.event.MenuDiscountEvent.menuDiscount;
import static christmas.model.event.SpecialStarEvent.specialDiscount;

import static christmas.util.Date.getDayOfWeekFromDate;

public class AppIODataController {
    private String inputDate;
    private String inputOrder;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private OrderValidator orderValidator = new OrderValidator();
    private PointOfSale pointOfSale = new PointOfSale();
    private int totalAmount = 0;
    private int totalDiscountAmount = 0;
    private final int MIN_AMOUNT = 10000;
    private final String NOTHING = "없음";


    public AppIODataController() {
        outputView.getPrintGreetingMessage();
        this.inputDate = inputView.readDate();
        this.inputOrder = inputView.readMenuAndQuantity();
        inputOrder = validateInputOrderLoop(inputOrder);

        outputView.getPrintBenefitsPreview(inputDate);

        printOrderMenu(inputOrder);

        totalAmount = pointOfSale.calculateTotalOrderAmount(inputOrder);
        totalAmountView(totalAmount);

        freeAwardView(totalAmount);

        eventEntry(totalAmount);
        benefitsDetailsValue();
        benefitsDetailView();


        totalDiscountAmountOutputView();
        expectedDiscountedPaymentAmount();
        decemberBadgeAward();
    }

    public void eventEntry(int totalAmount) {
        if (totalAmount < MIN_AMOUNT) {
            outputView.getPrintBoundaryEmptyLine();
            outputView.getPrintBenefitsDetails();
            System.out.println(NOTHING);
        }
    }

    private void totalAmountView(int totalAmount) {
        outputView.getPrintBoundaryEmptyLine();
        outputView.getPrintTotalOrderAmount();
        outputView.getPrintTotalAmountFormat(totalAmount);
    }

    private void freeAwardView(int totalAmount) {
        outputView.getPrintBoundaryEmptyLine();
        outputView.getPrintFreeAward();
        outputView.getPrintFreeAwardFormat(freeChampagneEvent(totalAmount));
    }

    private String validateInputOrderLoop(String inputOrder) {

        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {
            try {
                orderValidator.orderValidatorBundle(inputOrder);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputOrder = Console.readLine();
                attempts++;
            }
        }
        return inputOrder;
    }


    private void printOrderMenu(String inputOrder) {
        outputView.getPrintBoundaryEmptyLine();
        outputView.getPrintOrderMenu();

        Iterator<String> itemsIterator = itemsSet(inputOrder).iterator();
        Iterator<Integer> quantitiesIterator = quantitiesList(inputOrder).iterator();

        while (itemsIterator.hasNext() && quantitiesIterator.hasNext()) {
            String item = itemsIterator.next();
            int quantity = quantitiesIterator.next();

            outputView.getPrintOrderMenuFormat(item, quantity);
        }
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
            outputView.getPrintBoundaryEmptyLine();
            outputView.getPrintBenefitsDetails();
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
            outputView.getPrintDDayDiscount(dDayDiscount);
        }
    }

    private void weekendDiscountDetailView(int weekDiscount, String inputDate) {
        DayOfWeek dayOfWeek = getDayOfWeekFromDate(inputDate);
        if (weekDiscount != 0 && dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            outputView.getPrintWeekendDiscount(weekDiscount);
        }
    }

    private void weekdayDiscountDetailView(int weekDiscount, String inputDate) {
        DayOfWeek dayOfWeek = getDayOfWeekFromDate(inputDate);
        if (weekDiscount != 0 && !dayOfWeek.equals(DayOfWeek.FRIDAY) && !dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            outputView.getPrintWeekdayDiscount(weekDiscount);
        }
    }

    private void specialDiscountDetailView(int freeAward) {
        if (freeAward != 0) {
            outputView.getPrintAwardEvent(freeAward);
        }
    }

    private void freeAwardDetailView(int specialDiscount) {
        if (specialDiscount != 0) {
            outputView.getPrintSpecialDiscount(specialDiscount);
        }
    }

    private void totalDiscountAmountOutputView() {
        outputView.getPrintBoundaryEmptyLine();
        outputView.getPrintTotalBenefitsAmount();
        totalDiscountAmount();
        totalDiscountAmountZeroView();
        totalDiscountAmountView();
    }

    private void totalDiscountAmount() {
        totalDiscountAmount = dDayDiscount + weekDiscount + specialDiscount + freeAward;
    }

    private void totalDiscountAmountZeroView() {
        if (totalDiscountAmount == 0) {
            outputView.getPrintTotalDiscountAmountZeroFormat();
        }
    }

    private void totalDiscountAmountView() {
        if (totalDiscountAmount != 0) {
            outputView.getPrintTotalDiscountAmountFormat(totalDiscountAmount);
        }
    }

    private void expectedDiscountedPaymentAmount() {
        outputView.getPrintBoundaryEmptyLine();
        outputView.getPrintExpectedDiscountedPaymentAmount();
        outputView.getPrintTotalAmountFormat(totalAmount - totalDiscountAmount);
    }

    private void decemberBadgeAward() {
        outputView.getPrintBoundaryEmptyLine();
        outputView.getPrintDecemberBadgeAward();
        String badge = awardBadge(totalDiscountAmount);
        outputView.getPrintDecemberBadgeAward(badge);
    }
}


