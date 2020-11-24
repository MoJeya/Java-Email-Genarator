import java.util.Random;
import java.util.Scanner;

public class Email {
    //Hier Kommen die Verarbeiteung
   private String firstname;
   private String lastname;
   private String department;
   private String Password;
   //<Firstname>.<lastname>@<department>.com
   private String AlternetEmail;
   private String email;
   private int MaxCapacity;
   private int passLenght = 8;
   
   
   
   //Construcktor
   public Email (String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;

        System.out.println("Name for EMAIL SAVED:"+" "+"Firstname:"+" "+this.firstname+" "+"Lastname:"+" "+this.lastname);
        //Methode rufen um Department einzugeben
        this.department = setDepartment();
        //Methode rufen um Random Passwort zu bekommen
        this.Password = GenaratePassword(passLenght);
        System.out.println("PASSWORT: "+" "+this.Password);

        // combine Elements for EmailString
        this.email = emailGenartor(this.firstname, this.lastname, this.department); 

        //System.out.println("EMAIL:"+" "+ email );

       
   }

   //Methode um Department einzugeben

    private String setDepartment() {
       //Department wird hier eingegben
       System.out.println("Hi"+" "+firstname+" "+"ENTER DEPARTMENTCODE:\n1 for Sale\n2 for Devolopment\n3 for Accounting\n4 for none\nEnter CODE: ");
       //eingabe
       Scanner in = new Scanner(System.in);
       int depchois = in.nextInt();
       switch(depchois){
           case 1:
            this.department = "Sales";
            Check(true);
            in.close();
            return this.department;
           case 2:
            this.department = "Devolopment";
            Check(true);
            in.close();
            return this.department;
           case 3:
            this.department = "Accounting";
            Check(true);
            in.close();
            return this.department;
           case 4:
            this.department = " ";
            Check(false);
            in.close();
            return this.department;   
       }
       in.close();
      return this.department;
       
    }

    // Check if input was Valid
    private boolean Check(boolean valid){
        if(valid == true){
            //System.out.println("The input is valid");
            
            return true;

        }else{
            System.err.println("The iput ist not valid");
           
            return false;
        }
    }

    //Methode die randome passwort erstellt
    private String GenaratePassword(int lenght){
        
        String passwortSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ!&#€%";

        Random rand = new Random();
        //Char array mit einer bestimmten länge
        char[] password = new char[lenght];

            for(int i = 0; i<lenght; i++){
                // auf char index i wird vom passwortSet innerhalb der anngegebenen Länge 
                // ein Random Char vim String Deklariert
                // i0 = F; i1 = L usw...  
                password[i] = passwortSet.charAt(rand.nextInt(passwortSet.length()));
                
            }

            /*for(int i = 0; i< password.length; i++){
                // in dem Random String wird das Passwort array abgespeichert
                randomString += password[i];
                
            }*/

            //return randomString;
            return new String(password);
    
        

        }

        private String emailGenartor(String firstname, String lastname, String Department){
            String CompanySufixx = "-AnyCompeny.com";

            String emailTEMPSAVE = firstname.toLowerCase() +"."+lastname.toLowerCase()+"@"+department+CompanySufixx;

            return emailTEMPSAVE;
        }
        
    // set Mailbox cap soll eine öffentliche api werden
    // Mann nennt das Encapsulasation
    public void setMailboxCapacity(int capacity){
        this.MaxCapacity = capacity;
    }

    // set the alternativ email
    public void setAlternetEmail(String altEmail){
        this.AlternetEmail = altEmail;
    }

   

    // Change the password
    public void setPassword(String newPassword){

        if(CapLetter(newPassword) == true && SOzeichen(newPassword)== true && zahl(newPassword)== true){
            System.out.println("Your Password has benn succsessfully changed");
            this.Password = newPassword;
        }    
        
    }

       //Soll überprüfen ob:
        /**
         * min ein Großbuchstabe drin ist 
         * min ein zeichen
         * min eine Zahl
         * Wichtig Passwort muss max 8 zeichen lanng sein
         */

    // schaut nach Gorßbuchstaben
    private boolean CapLetter(String newPassword){
    
        
        for(int i = 0; i<this.passLenght; i++){
            if(Character.isUpperCase(newPassword.charAt(i))){
                return true;
            }
        }
        return false;

    }

    // Schaut nach Sonderzeichen
    private boolean SOzeichen(String newPassword){
       

        for(int i = 0; i<this.passLenght; i++){
            if(newPassword.charAt(i)=='!'
            || newPassword.charAt(i)=='%'
            || newPassword.charAt(i)=='#'
            || newPassword.charAt(i)=='%'
            || newPassword.charAt(i)=='€'
            || newPassword.charAt(i)==')'
            || newPassword.charAt(i)=='('){
                return true;
            }

        }
        return false;

    }

    // Schaut nach zahl
    private boolean zahl(String newPassword){
        for (int i = 0; i< passLenght; i++){
            if(Character.isDigit(newPassword.charAt(i))){
                return true;
            }
        }
        return false;
    }



    //Get methoden
    public int getMailboxCap(){return MaxCapacity;}
    public String getAltEmail(){return AlternetEmail;}
    public String getfirstname(){return firstname;}
    public String getlastname(){return lastname;}
    public String getPasswort(){return Password;}



    public String Diplay(){
        return "DISPLAY NAME: " + firstname+" "+ lastname+"\n"+
        "COMPANY EMAIL: " + email +"\n"+"MAILBOX CAPACITY: "+ MaxCapacity+ "mb";
        }
    }
    

