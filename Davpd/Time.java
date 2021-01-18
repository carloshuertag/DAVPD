import javax.swing.JPanel;

public class Time extends Thread {
    private boolean stop;
    private int s;
    private Contest contest;

    public Time(JPanel contest) {
        stop = false;
        this.contest = (Contest) contest;
    }
    
    @Override
    public void run(){
        while(!stop){
			try {
                sleep(1000);
                s++;		
                contest.timerJTextField.setText(String.valueOf(s));
			}
			catch(InterruptedException ie) {
				System.out.println(ie);
			}
		}
    }

    public void setStop(boolean stop){
        this.stop = stop;
        s = 0;
    }
}
