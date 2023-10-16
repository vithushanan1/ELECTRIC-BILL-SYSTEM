import java.util.Scanner;
class Units
{
    private int unit;
    
    public int getuni()
    {
        return electri();
    }
    public void setuni(int unit)
    {
        this.unit=unit;
    }
    public int  electri()
    {
       
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the unit :");
        int unit=sc. nextInt();
        return unit;
    }
   
}
class Charge extends Units
{
    void diplay()
    {
       
        System.out.println("1: for the shop  ");
        System.out.println("2: form the home ");
        System.out.println("3:for the school ");
        System.out.println("4: for the temple ");
        System.out.println("for the factory");
       

    }
  
   int checkunitcharge()
   {
        int cho;
        Scanner sc=new Scanner(System.in);
        cho=sc.nextInt();  
      
      switch(cho)
      {
           case 1:

            return (electri()*200);
            
            case 2:
             return (electri()*800);
              

            case 3:
             return(electri()*1000);
              

            case 4:
             return(electri()*1500);
              

            default:
                System.out.println("enter the correct oppition : ");
                return 0;    
      }
      
   }
}
interface Elctricity
{
    void totalbill();
}
interface Tax{
    double cal_Tax();
}
class Electribill extends Charge implements Elctricity,Tax
{
        Electribill(){}
        int total=0;
        public void totalbill()
        {
             total=checkunitcharge();//+500;
            System.out.println("The total amount is : "+total); 
        }
        public double cal_Tax(){
            if(total<=8000){
                return (total*12.97);
            }
            else if(total>8000 && total<=48000){
                return (total*24.88);
            }
            else if(total>48000 && total<=80000){
                return (total*45.73);
            }
            return (total*58.71);
        }
}
class Advance extends Electribill{
    private double ad_pay;
    private String nic,billNo;
    Advance(){}
    Advance(String billNo,String nic,double ad_pay){
        this.ad_pay = ad_pay;
        this.nic = nic;
        this.billNo = billNo;
    }

    //creating getter and setter for advance class private members 
    public double getad(){
        return ad_pay;
    }
    public void setad(double ad_pay){
        this.ad_pay=ad_pay;
    }
    public String getnic(){
        return nic;
    }
    public void setnic(String nic){
        this.nic=nic;
    }
    public String getbill(){
        return billNo;
    }
    public void setbill(String bill){
        this.billNo=bill;
    }
    //conformation for calculate the bill
    String check()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("please again enter the nic number for conformation");
        nic=sc.next();
        return nic;
    }
}
//--------------------Main method-----------------------
class Mains
{
    public static void main(String args[])
    {
        String nics;
        System.out.println("\n-------- *****Electical Bill*****-------- \n");

        Scanner sc = new Scanner(System.in);
        Advance ad = new Advance();
        System.out.print("Bill Number : ");
        ad.setbill(sc.next());
        System.out.print("NIC Number  : ");
        ad.setnic(sc.next());
        System.out.print("Advance Payment   : ");
        ad.setad(sc.nextDouble());
       
      
        Advance adlist[] = new Advance[]{
            new Advance(ad.getbill(),ad.getnic(),ad.getad())
        };
        
        
       nics=ad.getnic();
       if(ad.check().contains(nics))
       {
            Charge charge=new Charge();
           charge.diplay();
        // charge.checkunitcharge();
        
           Electribill elc=new Electribill();
           elc.totalbill();
        //total payment after subtract the advance balance----------------------
           System.out.println("This Month Total Patment with Tax : "+(elc.cal_Tax()-ad.getad()));
        //System.out.print("FINAL PAYMENT : "+ad.adpay());

       }
       else
       {
          System.out.println("enter the valid nic number");
       }
        

        
    }
}
