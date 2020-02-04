package testPackage;

import java.time.LocalDate;
import java.util.*;

public class OrderSystem {
    private static OrderSystem orderSystem;
    private OrderTask task;
    private Thread thread;

    private OrderSystem() {
        Set<Order> orders = new HashSet<>();
        //initializing 4 random orders
        orders.add(new Order(LocalDate.of(1995,3,3),"order 1 is ready", false));
        orders.add(new Order(LocalDate.of(2021,5,8),"order 2 is ready", false));
        orders.add(new Order(LocalDate.of(2015,1,1),"order 3 is ready", false));
        orders.add(new Order(LocalDate.of(1996,11,9),"omer is ready", true));
        task = new OrderTask(orders);
        thread = new Thread(task);
        thread.setDaemon(true);
    }

    public static OrderSystem getInstance(){
        if (orderSystem == null) {
            orderSystem = new OrderSystem();
        }
        return orderSystem;
    }

    public static OrderSystem getOrderSystem() {
        return orderSystem;
    }

    public static void setOrderSystem(OrderSystem orderSystem) {
        OrderSystem.orderSystem = orderSystem;
    }

    public OrderTask getTask() {
        return task;
    }

    public void setTask(OrderTask task) {
        this.task = task;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public boolean addOrder (Order order) {
        Set<Order> newOne = new HashSet<>(task.getOrders());
        boolean didWork = newOne.add(order);
        task.setOrders(newOne);
        return didWork;
    }

    public List<Order> getOrders(){
        List<Order> orderList = new ArrayList<>(task.getOrders());
        Collections.sort(orderList);
        return orderList;
    }

}
