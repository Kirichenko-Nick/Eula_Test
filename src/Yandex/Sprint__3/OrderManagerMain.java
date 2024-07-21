package Yandex.Sprint__3;


public class OrderManagerMain {

    public static void main(String[] args) {
        OrdersManager ordersManager = new OrdersManager();

        ordersManager.printAllOrders();
        System.out.println("Всего заказов на сумму: " + ordersManager.getOrdersSum());

        String maxOrderCustomerName = ordersManager.getMaxOrderCustomerName();
        System.out.println("Самая большая сумма заказов у " + maxOrderCustomerName);
        ordersManager.printCustomerOrders(maxOrderCustomerName);

        ordersManager.removeUnprofitableOrders();

        System.out.println();
        System.out.println("Успех!\n" +
                "Да пребудет с вами Spring! Двигайтесь дальше ->");
    }
}