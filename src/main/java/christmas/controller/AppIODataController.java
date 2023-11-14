package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.counter.OrderValidator;
import christmas.model.counter.PointOfSale;
import christmas.model.menu.Dessert;
import christmas.model.menu.MainDish;
import christmas.model.menu.MenuItem;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static christmas.model.counter.PointOfSale.itemsSet;
import static christmas.model.counter.PointOfSale.quantitiesList;
import static christmas.model.event.ChristmasDDay.dDayDiscount;
import static christmas.model.event.FreeChampagneEvent.*;
import static christmas.model.event.MenuDiscountEvent.calculateMenuDiscount;
import static christmas.model.event.SpecialStarEvent.getSpecialStarDiscount;
import static christmas.util.Date.getDayOfWeekFromDate;
import static christmas.view.MessageManager.*;


public class AppIODataController {
    private String inputDate;
    private  String inputOrder;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private OrderValidator orderValidator = new OrderValidator();
    private PointOfSale pointOfSale = new PointOfSale();
    private  int totalAmount = 0;


    public AppIODataController() {
        this.inputDate = inputView.readDate();
        this.inputOrder = inputView.readMenuAndQuantity();
        outputView.printBenefitsPreview(inputDate);
        printOrderMenu(inputOrder);
        inputOrder = validateInputOrderLoop(inputOrder);
        totalAmount= pointOfSale.calculateTotalOrderAmount(inputOrder);
        totalAmountView(totalAmount);
        freeAwardView(totalAmount);
        benefitsDetailsView();

    }

    private void totalAmountView(int totalAmount) {
        outputView.printBoundaryEmptyLine();
        getPrintTotalOrderAmount();
        outputView.printTotalAmountFormat(totalAmount);
    }
    private void freeAwardView(int totalAmount){
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

    private int dDayDiscount;
    private int weekDiscount;
    private int specialDiscount;
    private int freeAward;

    private void benefitsDetailsView() {
        outputView.printBoundaryEmptyLine();
        getPrintBenefitsDetails();

        dDayDiscount = dDayDiscount(inputDate);
        outputView.printDDayDiscount(dDayDiscount(inputDate));
        weekDiscount = weekDiscount();
        specialDiscount = specialDiscount(inputDate);
        freeAward = freeAward();
    }


    private int weekDiscount() {
        DayOfWeek dayOfWeek = getDayOfWeekFromDate(inputDate);
        if(dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            MainDish mainDish = MainDish.T_BONE_STEAK;
            outputView.printWeekendDiscount(calculateMenuDiscount(inputOrder,mainDish));
            return calculateMenuDiscount(inputOrder,mainDish);
        }
        Dessert dessert = Dessert.CHOCO_CAKE;
        outputView.printWeekdayDiscount(calculateMenuDiscount(inputOrder,dessert));
        return calculateMenuDiscount(inputOrder,dessert);
    }

    private int specialDiscount(String inputDate) {
        ArrayList<String> specialDays = new ArrayList<>(Arrays.asList("3", "10", "17", "24", "25", "31"));
        for (String specialDay : specialDays) {
            if(inputDate.equals(specialDay)) {
                outputView.printSpecialDiscount(getSpecialStarDiscount());
                return getSpecialStarDiscount();
            }
        }
        return 0;
    }

    private int freeAward() {
        if (validateFreeChampagne(totalAmount)) {
            outputView.printAwardEvent(freeChampanePrice());
            return freeChampanePrice();
        }
        return 0;
    }
}


