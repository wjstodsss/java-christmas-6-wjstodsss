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
import static christmas.model.event.MenuDiscountEvent.*;
import static christmas.model.event.MenuDiscountEvent.menuDiscount;
import static christmas.model.event.SpecialStarEvent.specialDiscount;

import static christmas.util.Date.getDayOfWeekFromDate;
import static christmas.view.MessageManager.*;


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
        this.inputDate = inputView.readDate();
        this.inputOrder = inputView.readMenuAndQuantity();
        inputOrder = validateInputOrderLoop(inputOrder);

        outputView.printBenefitsPreview(inputDate);

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
            outputView.printBoundaryEmptyLine();
            getPrintBenefitsDetails();
            System.out.println(NOTHING);
        }
    }

    private void totalAmountView(int totalAmount) {
        outputView.printBoundaryEmptyLine();
        getPrintTotalOrderAmount();
        outputView.printTotalAmountFormat(totalAmount);
    }

    private void freeAwardView(int totalAmount) {
        outputView.printBoundaryEmptyLine();
        getPrintFreeAward();
        outputView.printFreeAwardFormat(freeChampagneEvent(totalAmount));
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
        outputView.printBoundaryEmptyLine();
        getPrintOrderMenu();

        Iterator<String> itemsIterator = itemsSet(inputOrder).iterator();
        Iterator<Integer> quantitiesIterator = quantitiesList(inputOrder).iterator();

        while (itemsIterator.hasNext() && quantitiesIterator.hasNext()) {
            String item = itemsIterator.next();
            int quantity = quantitiesIterator.next();

            outputView.printOrderMenuFormat(item, quantity);
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
            outputView.printBoundaryEmptyLine();
            getPrintBenefitsDetails();
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
            outputView. printAwardEvent(freeAward);
        }
    }

    private void freeAwardDetailView(int specialDiscount) {
        if (specialDiscount != 0) {
            outputView.printSpecialDiscount(specialDiscount);
        }
    }

    private void totalDiscountAmountOutputView() {
        outputView.printBoundaryEmptyLine();
        getPrintTotalBenefitsAmount();
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
        getPrintExpectedDiscountedPaymentAmount();
        outputView.printTotalAmountFormat(totalAmount - totalDiscountAmount);
    }

    private void decemberBadgeAward() {
        outputView.printBoundaryEmptyLine();
        getPrintDecemberBadgeAward();
        String badge = awardBadge(totalDiscountAmount);
        outputView.printDecemberBadgeAward(badge);
    }
}


