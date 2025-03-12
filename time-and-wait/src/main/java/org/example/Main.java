package org.example;
import java.util.Arrays;

public class Main {

    //calculates the wait times in an array of process burst times, assuming the order of processes as given
    public static int[] wait_times(int[] burst_times) {
        int time_passed = 0;
        int[] wait_times = new int[burst_times.length];

        for (int i = 0; i < burst_times.length; i++) {
            if (i==0) {
                wait_times[i] = 0;
            } else {
                time_passed += burst_times[i-1];
                wait_times[i] = time_passed;
            }
        }
        return wait_times;
    }

    //calculates the turnaround times in an array of process burst times, assuming the order of processes as given
    public static int[] turnaround_times(int[] burst_times) {
        int[] t_times = new int[burst_times.length]; //just shorthand

        int[] wait_times = wait_times(burst_times);
        for (int i = 0; i < burst_times.length; i++) {
            t_times[i] = wait_times[i] + burst_times[i];
        }
        return t_times;
    }

    public static void main(String[] args) {
        int[] burst_times = {2, 1, 8, 4, 5};

        //computing times for FCFS
        int[] wait_times_fcfs = wait_times(burst_times);
        int[] turnaround_times_fcfs = turnaround_times(burst_times);

        //sort tasks for SJF
        Arrays.sort(burst_times);
        int[] wait_times_sjf = wait_times(burst_times);
        int[] turnaround_times_sjf = turnaround_times(burst_times);

        System.out.println("------------------- FCFS -------------------");
        System.out.println(" Process ID |  Waiting Time | Turnaround Time");
        for (int i = 0; i < burst_times.length; i++) {
            System.out.println("\t"+i+"\t\t|\t\t"+wait_times_fcfs[i]+"\t\t|\t\t"+turnaround_times_fcfs[i]);
        }

        System.out.println("------------------- SJF -------------------");
        System.out.println(" Process ID |  Waiting Time | Turnaround Time");
        for (int i = 0; i < burst_times.length; i++) {
            System.out.println("\t"+i+"\t\t|\t\t"+wait_times_sjf[i]+"\t\t|\t\t"+turnaround_times_sjf[i]);
        }

    }
}