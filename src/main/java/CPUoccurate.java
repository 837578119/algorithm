public class CPUoccurate {
    public static void main(String[] args) {
        int busyTime = 90;
        int idleTime = busyTime;
        double startTime = 0;
        while(true){
            startTime = System.currentTimeMillis();
            while(System.currentTimeMillis() - startTime<busyTime){

            }
            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
