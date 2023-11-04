public class Timer extends WashingMachine implements Runnable {

    public void run() {
        try {
            Thread.sleep(5000);
            stopWorking();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
