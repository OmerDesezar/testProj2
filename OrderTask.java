package testPackage;

import java.time.LocalDate;
import java.util.Set;

public class OrderTask implements Runnable{
    private Set<Order> orders;

    public OrderTask(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    private boolean shouldRemind(Order order) {
        //checking if it was in the past or today and if it was seen already
        return (order.getReadyOn().isBefore(LocalDate.now()) ||
                order.getReadyOn().equals(LocalDate.now())) &&
                !order.isPoped();
    }

    @Override
    public void run() {
        while (true) {
            for (Order order : orders) {
                if (shouldRemind(order)) {
                    System.out.println(order.getText());
                    order.setPoped(true);
                    if (order.isImportant()) {
                        Thread important = new Thread(new ImportantOrderTask(order));
                        important.start();
                    }
                }
            }
        }
    }
}
