
package queuesched;

import java.util.Scanner;

public class QueueSched {

    public static void main(String[] args) {
Scanner reader = new Scanner(System.in);
    Qu1 q1 = new Qu1();
   Qu2 q2 = new Qu2();
   Qu3 q3 = new Qu3();
   
       System.out.println("Enter no.of proccesses");
        int n=reader.nextInt();
        int wt1=0 , wt2=0 , wt3=0 , rm=0;
        
        int BT[]= new int[n+1];
         System.out.println("Enter Burst time for processes"); 
        for (int i=0; i<n; i++){
            
            BT[i]=reader.nextInt();
        }
        
        
        for (int i =0; i<n; i++){
           
            int bt = BT[i];
         
             q1.insert(bt);
             
                 System.out.print("proccess " + i + " Entered q1 ");
                 if (bt<8){
                 System.out.println(" waited for " + wt1 + " ms , burst time = " + bt + " ms" + " , Total time = " + (wt1+bt));
                 wt1+=bt;
                 }
                 else  {    System.out.println(" waited for " + wt1 + " ms , burst time = " + 8 + " ms"+ " , Total time = " + (wt1+8));
                 wt1+=8;
                 }

                 System.out.println("");
             
             if (bt>8){
                 rm=bt-8;
                 q1.remove();
                 q2.insert(rm);
                 System.out.print("proccess " + i + " Entered q2");
                if (rm<16){
                      System.out.println(" waited for " + wt2 + " ms , burst time = " + rm + "ms" + " , Total time = " + (wt2+rm));
                wt2+=rm;
                }
                else  {System.out.println(" waited for " + wt2 + " ms , burst time = " + 16 + "ms" + " , total time = " + (wt2+16));
                wt2+=16;
                }
                 System.out.println("");
                 q2.remove();
                     
                 
                 if(rm>16){
                     rm-=16;
                    q2.remove();
                    q3.insert(rm);
                     System.out.print("proccess " + i + " Entered q3 ");
                 System.out.println(" waited for " + wt3 + " ms , burst time = " + rm + "ms" + " , Total time = " + (wt3+rm));
                 wt3+=rm;
                 System.out.println("");
                    q3.remove();
                   
                   
                 }
                
             }
          
          
        }
   
    }
    
}
