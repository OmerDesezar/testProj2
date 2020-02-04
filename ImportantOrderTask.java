package testPackage;

public class ImportantOrderTask implements Runnable{
    private Order order;

    public ImportantOrderTask(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 3 ; i++){
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(order.getText());
        }
    }
}
