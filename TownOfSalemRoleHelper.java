import java.util.Scanner;   
public class TownOfSalemRoleHelper
{
   static boolean town, checked;
   static String[] roles=new String[15];
   static String name="", role, option;
   static Scanner input = new Scanner(System.in);
   public static void resetAll()
   {
      checked=true;
      role="";
      for(int i=0; i<15; i++)
         roles[i]="";
   }
   public static void updateRole(int n1, int n2)
   {
      checked=true;
      option="";
      if(roles[n1].equals(""))
         roles[n1]=name+" The "+role;
      else
         if(roles[n2].equals(""))
            roles[n2]=name+" The "+role;
         else
            if(town&&roles[7].equals(""))
               roles[7]=name+" The "+role;
            else
               if(roles[14].equals(""))
                  roles[14]=name+" The "+role;
               else
                  while(!(option.contains("y")||option.contains("n")))
                  {
                     System.out.println("All slots where "+role+" would fit are filled. Would you like to replace a slot with "+name+"?");
                     option=input.nextLine().toLowerCase();
                     if(option.contains("y"))
                     {
                        System.out.println("Type the name of the person you would like to replace.");
                        option=input.nextLine();
                        for(int i=0; i<15; i++)
                           if(roles[i].contains(option+" The "))
                              roles[i]=name+" The "+role;
                        option="y";
                     }
                  }
   }
   public static void main(String[] args)
   {
      resetAll();
      while(!name.equals("exit"))
      {
         town=true;
         checked=false;
         System.out.println("1) Jailor: "+roles[0]);
         System.out.println("2) Town Investigative: "+roles[1]);
         System.out.println("3) Town Investigative: "+roles[2]);
         System.out.println("4) Town Support: "+roles[3]);
         System.out.println("5) Town Support: "+roles[4]);
         System.out.println("6) Town Protective: "+roles[5]);
         System.out.println("7) Town Killing: "+roles[6]);
         System.out.println("8) Random Town: "+roles[7]);
         System.out.println("9) Godfather: "+roles[8]);
         System.out.println("10) Mafioso: "+roles[9]);
         System.out.println("11) Random Mafia: "+roles[10]);
         System.out.println("12) Neutral Killing: "+roles[11]);
         System.out.println("13) Neutral Evil: "+roles[12]);
         System.out.println("14) Neutral Benign: "+roles[13]);
         System.out.println("15) Any: "+roles[14]);
         System.out.println("Enter a name: ");
         name=input.nextLine();
         if(name.equals("resetall")||name.equals("exit"))
            resetAll();
         else
         {
            System.out.println("Enter a role: ");
            role=input.nextLine().toLowerCase();
         }
         for(int i=0; i<15; i++)
            if(roles[i].contains(name+" The "))
               roles[i]="";
         if(role.equals("jailor"))
            updateRole(0, 7);
         if(role.equals("investigator")||role.equals("lookout")||role.equals("sheriff")||role.equals("spy"))
            updateRole(1, 2);
         if(role.equals("escort")||role.equals("mayor")||role.equals("medium")||role.equals("retributionist")||role.equals("transporter"))
            updateRole(3, 4);
         if(role.equals("bodyguard")||role.equals("doctor"))
            updateRole(5, 7);
         if(role.equals("veteran")||role.equals("vigilante")||role.equals("vampire hunter"))
            updateRole(6, 7);
         town=false;
         if(role.equals("godfather"))
            updateRole(8, 14);
         if(role.equals("mafioso"))
            updateRole(9, 14);
         if(role.equals("blackmailer")||role.equals("consigliere")||role.equals("consort")||role.equals("disguiser")||role.equals("forger")||role.equals("framer")||role.equals("janitor"))
            updateRole(10, 14);
         if(role.equals("arsonist")||role.equals("serial killer")||role.equals("werewolf"))
            updateRole(11, 14);
         if(role.equals("executioner")||role.equals("jester")||role.equals("witch"))
            updateRole(12, 14);
         if(role.equals("amnesiac")||role.equals("survivor"))
            updateRole(13, 14);
         if(!checked)
            updateRole(14, 14);
      }
   }
}