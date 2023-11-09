public class Timer extends WashingMachine {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            stopWorking();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
