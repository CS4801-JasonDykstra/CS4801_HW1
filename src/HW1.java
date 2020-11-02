import java.util.LinkedList;

public class HW1 {
    public static void main(String args[]){
        // Program to find the period of any lfsr
        LinkedList<Integer> LFSR = new LinkedList<Integer>();
        LinkedList<Integer> LFSRGates = new LinkedList<Integer>();

        // 0th position is all the way to the right

        // Part i)
//        initializeLFSR(LFSR, "001011000");
//        initializeLFSR(LFSRGates, "110000101");

        // Part ii)
        initializeLFSR(LFSR, "001011000");
        initializeLFSR(LFSRGates, "110000100");


        System.out.println("LFSR: " + LFSR);

        LinkedList<Integer> LFSRCopy = (LinkedList<Integer>)LFSR.clone();


        int LFSRSize = LFSR.size();
        int maxPeriod = (int)(Math.pow(2, LFSRSize)) - 1;

        int period = 0;

        for(int i = 0; i < maxPeriod; i++){
            period++;
            int XOR = 0;
            for(int j = 0; j < LFSRSize; j++){
                if(LFSRGates.get(j) == 1){
                    XOR += LFSRCopy.get(j);
                }
            }

            // Calculate XOR
            XOR %= 2;

            LFSRCopy.removeLast();
            LFSRCopy.push(XOR);

            // Print the current LFSR
            System.out.println("Current LFSR: " + LFSRCopy);

            // See if LFSR repeats
            if(LFSRCopy.equals(LFSR)){
                System.out.println("Period: " + period);
                return;
            }
        }

        System.out.println("Period (max period): " + maxPeriod);
    }

    static void initializeLFSR(LinkedList<Integer> LFSR, String input){
        for(int i = 0; i < input.length(); i++){
            LFSR.add(Integer.parseInt(input.substring(i, i + 1)));
        }
    }



}
