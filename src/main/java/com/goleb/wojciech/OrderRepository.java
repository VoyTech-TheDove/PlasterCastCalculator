package com.goleb.wojciech;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository extends Repository {
    public static final String LOG_FILE_NAME = "orderLog.dat";
    public static final String SUMMARY_FILE_NAME = "orderSUMMARY.txt";
    List<Order> orderLog = new ArrayList<>();
    Repository repository = new Repository();

    public void updateOrderLogFromFile() {
        repository.loadLogFromFile(LOG_FILE_NAME, orderLog);
    }

    public void addToOrderLogAndSaveToFile(Order newOrder) {
        orderLog.add(newOrder);
        repository.saveLogToFile(LOG_FILE_NAME, orderLog);
    }

    public void monthlyOrderReport() {
        monthlyOrderReportToFile(orderLog);
    }

    private void monthlyOrderReportToFile(List<Order> list) {
        try {
            PrintWriter out = new PrintWriter(timeAsStringForFile(LocalDateTime.now()) + SUMMARY_FILE_NAME);
            out.println("Number of sold Circles");
            out.println(countShapeInList(PossibleShapes.CIRCLE, list));
            out.println("Number of sold Squares");
            out.println(countShapeInList(PossibleShapes.SQUARE, list));
            out.println("Number of sold Triangles");
            out.println(countShapeInList(PossibleShapes.TRIANGLE, list));
            out.println("Total Earnings " + sumOrderPriceInList(list) + "zl");
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("cannot print to file");
        }
    }

    private BigDecimal sumOrderPriceInList(List<Order> list) {
        BigDecimal priceSum = BigDecimal.valueOf(0);
        for (Order order : list) {
            priceSum.add(order.price());
        }
        return priceSum;
    }

    private int countShapeInList(PossibleShapes shape, List<Order> list) {
        int counter = 0;
        for (Order order : list) {
            counter += order.list().stream()
                    .filter(figure -> figure.shape == shape)
                    .count();
        }
        return counter;
    }

    private static String timeAsStringForFile(LocalDateTime time) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("hhmmss_ddMMyyyy_");
        return time.format(dateFormat);
    }

}
