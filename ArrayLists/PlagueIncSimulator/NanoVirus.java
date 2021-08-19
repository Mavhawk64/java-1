package PlagueIncSimulator;
import java.util.*;
/**
 * Write a description of class NanoVirus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NanoVirus implements Disease
{
   City city = new City();
    String u = "";
    String name = "";
    int infect = 1;
    int lethal = 0;
    public boolean nub = false;

    //Symptoms
    public boolean Nausea = false;
    public boolean Coughing = false;
    public boolean Rash = false;
    public boolean Insomnia = false;
    public boolean Cysts = false;
    public boolean Anaemia = false;
    public boolean Vomiting = false;
    public boolean Pneumonia = false;
    public boolean Sneezing = false;
    public boolean Sweating = false;
    public boolean Paranoia = false;
    public boolean HyperSensitivity = false;
    public boolean Abscesses = false;
    public boolean Haemophilia = false;
    public boolean PulmonaryOedema = false;
    public boolean Diarrhoea = false;
    public boolean PulmonaryFibrosis = false;
    public boolean ImmuneSuppression = false;
    public boolean Fever = false;
    public boolean SkinLesions = false;
    public boolean Seizures = false;
    public boolean Inflammation = false;
    public boolean Tumors = false;
    public boolean Dysentery = false;
    public boolean TotalOrganFailure = false;
    public boolean Necrosis = false;
    public boolean HemorrhagicShock = false;
    public boolean SystemicInfection = false;
    public boolean Coma = false;
    public boolean Paralysis = false;
    public boolean Insanity = false;
    public boolean InternalHaemorrhaging = false;

    //Transmission
    public boolean Bird = false;
    public boolean Rodent = false;
    public boolean Insect = false;
    public boolean Livestock = false; 
    public boolean ExtremeZoonosis = false;
    public boolean Blood = false;
    public boolean ExtremeHem = false;
    public boolean Air = false;
    public boolean Water = false;
    public boolean ExtremeBio = false;

    //Abilities
    public boolean Cold = false;
    public boolean Heat = false;
    public boolean Drug = false;
    public boolean GeneticHardening = false;
    //Nano-Virus
    public boolean ReplicationFactoryOverload = false;
    @Override
    public void Done()
    {
        System.out.println(name + " is the best disease!");
    }
    //Symptoms
    public void SymptomsOptions()
    {
        if(!Nausea)
            System.out.println("1. Nausea");
        if(!Coughing)
            System.out.println("2. Coughing");
        if(!Rash)
            System.out.println("3. Rash");
        if(!Insomnia)
            System.out.println("4. Insomnia");
        if(!Cysts)
            System.out.println("5. Cysts");
        if(!Anaemia)
            System.out.println("6. Anaemia");
        if(!Vomiting)
            System.out.println("7. Vomiting");
        if(!Pneumonia)
            System.out.println("8. Pneumonia");
        if(!Sneezing)
            System.out.println("9. Sneezing");
        if(!Sweating)
            System.out.println("10. Sweating");
        if(!Paranoia)
            System.out.println("11. Paranoia");
        if(!HyperSensitivity)
            System.out.println("12. Hyper Sensitivity");
        if(!Abscesses)
            System.out.println("13. Abscesses");
        if(!Haemophilia)
            System.out.println("14. Haemophilia");
        if(!PulmonaryOedema)
            System.out.println("15. Pulmonary Oedema");
        if(!Diarrhoea)
            System.out.println("16. Diarrhoea");
        if(!PulmonaryFibrosis)
            System.out.println("17. Pulmonary Fibrosis");
        if(!ImmuneSuppression)
            System.out.println("18. Immune Suppression");
        if(!Fever)
            System.out.println("19. Fever");
        if(!SkinLesions)
            System.out.println("20. Skin Lesions");
        if(!Seizures)
            System.out.println("21. Seizures");
        if(!Inflammation)
            System.out.println("22. Inflammation");
        if(!Tumors)
            System.out.println("23. Tumors");
        if(!Dysentery)
            System.out.println("24. Dysentery");
        if(!TotalOrganFailure)
            System.out.println("25. Total Organ Failure");
        if(!Necrosis)
            System.out.println("26. Necrosis");
        if(!SystemicInfection)
            System.out.println("27. Systemic Infection");
        if(!Coma)
            System.out.println("28. Coma");
        if(!Paralysis)
            System.out.println("29. Paralysis");
        if(!HemorrhagicShock)
            System.out.println("30. Hemorrhagic Shock");
        if(!Insanity)
            System.out.println("31. Insanity");
        if(!InternalHaemorrhaging)
            System.out.println("32. Internal Haemorrhaging");
        Scanner scan = new Scanner(System.in);
        int s = 0;
        try
        {
            s = scan.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("OOPS");
            SymptomsOptions();
        }

        if(s == 1 && !Nausea)
        {
            infect+=1;
            Nausea = true;
        }
        else if(s == 2 && !Coughing)
        {
            infect+=1;
            Coughing = true;
        }
        else if(s == 3 && !Rash)
        {
            infect+=1;
            Rash = (true);
        }
        else if(s == 4 && !Insomnia)
        {
            infect+=1;
            Insomnia = (true);
        }
        else if(s == 5 && !Cysts)
        {
            infect+=1;
            Cysts = (true);
        }
        else if(s == 6 && !Anaemia)
        {
            infect+=1;
            Anaemia = (true);
        }
        else if(s == 7 && !Vomiting)
        {
            infect+=2;
            Vomiting = (true);
        }
        else if(s == 8 && !Pneumonia)
        {
            infect+=2;
            Pneumonia = (true);
        }
        else if(s == 9 && !Sneezing)
        {
            infect+=2;
            Sneezing = (true);
        }
        else if(s == 10 && !Sweating)
        {
            infect+=1;
            Sweating = (true);
        }
        else if(s == 11 && !Paranoia)
        {
            infect+=1;
            Paranoia = (true);
        }
        else if(s == 12 && !HyperSensitivity)
        {
            infect+=1;
            HyperSensitivity = (true);
        }
        else if(s == 13 && !Abscesses)
        {
            infect+=3;
            Abscesses = (true);
        }
        else if(s == 14 && !Haemophilia)
        {
            infect+=3;
            Haemophilia = (true);
        }
        else if(s == 15 && !PulmonaryOedema)
        {
            infect+=3;
            lethal+=1;
            PulmonaryOedema = (true);
        }
        else if(s == 16 && !Diarrhoea)
        {
            infect+=3;
            lethal+=1;
            Diarrhoea = (true);
        }
        else if(s == 17 && !PulmonaryFibrosis)
        {
            infect+=2;
            lethal+=1;
            PulmonaryFibrosis = (true);
        }
        else if(s == 18 && !ImmuneSuppression)
        {
            infect+=2;
            lethal+=2;
            ImmuneSuppression = (true);
        }
        else if(s == 19 && !Fever)
        {
            infect+=3;
            lethal+=2;
            Fever = (true);
        }
        else if(s == 20 && !SkinLesions)
        {
            infect+=5;
            SkinLesions = (true);
        }
        else if(s == 21 && !Seizures)
        {
            infect+=1;
            lethal+=1;
            Seizures = (true);
        }
        else if(s == 22 && !Inflammation)
        {
            infect+=1;
            lethal+=1;
            Inflammation = (true);
        }
        else if(s == 23 && !Tumors)
        {
            infect+=1;
            lethal+=2;
            Tumors = (true);
        }
        else if(s == 24 && !Dysentery)
        {
            infect+=4;
            lethal+=4;
            Dysentery = (true);
        }
        else if(s == 25 && !TotalOrganFailure)
        {
            lethal+=10;
            TotalOrganFailure = (true);
        }
        else if(s == 26 && !Necrosis)
        {
            infect+=3;
            lethal+=5;
            Necrosis = (true);
        }
        else if(s == 27 && !SystemicInfection)
        {
            infect+=2;
            lethal+=2;
            SystemicInfection = (true);
        }
        else if(s == 28 && !Coma)
        {
            lethal+=1;
            Coma = (true);
        }
        else if(s == 29 && !Paralysis)
        {
            infect+=1;
            lethal+=1;
            Paralysis = true;
        }
        else if(s == 30 && !HemorrhagicShock)
        {
            lethal+=5;
            HemorrhagicShock = (true);
        }
        else if(s == 31 && !Insanity)
        {
            infect+=2;
            Insanity = true;
        }
        else if(s == 32 && !InternalHaemorrhaging)
        {
            lethal+=2;
            InternalHaemorrhaging = true;
        }
        else
        {
            System.out.println("NO");
        }

        try
        {
            Thread.sleep(2000);
            printer();
        }
        catch(Exception e)
        {
            System.err.println("YOU NUB!!!");
        }
        Options();
        //Infectivity = 54 max
        //Lethality = 41 max
    }

    NanoVirus()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Disease Name---");
        name = sc.nextLine();
        city.createCity();
        Options();
    }

    @Override
    public int randomness(int rand)
    {
        rand = 10;
        Random rando = new Random();
        rand = rando.nextInt(rand);
        if(rand == 4)
        {
            if(!Nausea)
            {
                infect+=1;
                Nausea = true;
            }
            else if(!Coughing)
            {
                infect+=1;
                Coughing = true;
            }
            else if(!Rash)
            {
                infect+=1;
                Rash = (true);
            }
            else if(!Insomnia)
            {
                infect+=1;
                Insomnia = (true);
            }
            else if(!Cysts)
            {
                infect+=1;
                Cysts = (true);
            }
            else if(!Anaemia)
            {
                infect+=1;
                Anaemia = (true);
            }
            else if(!Vomiting)
            {
                infect+=2;
                Vomiting = (true);
            }
            else if(!Pneumonia)
            {
                infect+=2;
                Pneumonia = (true);
            }
            else if(!Sneezing)
            {
                infect+=2;
                Sneezing = (true);
            }
            else if(!Sweating)
            {
                infect+=1;
                Sweating = (true);
            }
            else if( !Paranoia)
            {
                infect+=1;
                Paranoia = (true);
            }
            else if(!HyperSensitivity)
            {
                infect+=1;
                HyperSensitivity = (true);
            }
            else if(!Abscesses)
            {
                infect+=3;
                Abscesses = (true);
            }
            else if(!Haemophilia)
            {
                infect+=3;
                Haemophilia = (true);
            }
            else if(!PulmonaryOedema)
            {
                infect+=3;
                lethal+=1;
                PulmonaryOedema = (true);
            }
            else if(!Diarrhoea)
            {
                infect+=3;
                lethal+=1;
                Diarrhoea = (true);
            }
            else if(!PulmonaryFibrosis)
            {
                infect+=2;
                lethal+=1;
                PulmonaryFibrosis = (true);
            }
            else if(!ImmuneSuppression)
            {
                infect+=2;
                lethal+=2;
                ImmuneSuppression = (true);
            }
            else if(!Fever)
            {
                infect+=3;
                lethal+=2;
                Fever = (true);
            }
            else if(!SkinLesions)
            {
                infect+=5;
                SkinLesions = (true);
            }
            else if(!Seizures)
            {
                infect+=1;
                lethal+=1;
                Seizures = (true);
            }
            else if(!Inflammation)
            {
                infect+=1;
                lethal+=1;
                Inflammation = (true);
            }
            else if(!Tumors)
            {
                infect+=1;
                lethal+=2;
                Tumors = (true);
            }
            else if(!Dysentery)
            {
                infect+=4;
                lethal+=4;
                Dysentery = (true);
            }
            else if(!TotalOrganFailure)
            {
                lethal+=10;
                TotalOrganFailure = (true);
            }
            else if(!Necrosis)
            {
                infect+=3;
                lethal+=5;
                Necrosis = (true);
            }
            else if(!SystemicInfection)
            {
                infect+=2;
                lethal+=2;
                SystemicInfection = (true);
            }
            else if(!Coma)
            {
                lethal+=1;
                Coma = (true);
            }
            else if(!Paralysis)
            {
                infect+=1;
                lethal+=1;
                Paralysis = true;
            }
            else if(!HemorrhagicShock)
            {
                lethal+=5;
                HemorrhagicShock = (true);
            }
            else if(!Insanity)
            {
                infect+=2;
                Insanity = true;
            }
            else if(!InternalHaemorrhaging)
            {
                lethal+=2;
                InternalHaemorrhaging = true;
            }
            System.out.println("Added a new symptom!");
        }
        return rand;
    }

    @Override
    public void printer()
    {
        city.getPop(infect, lethal);
        if(city.checkDead())
        {
            nub = true;
            Options("end");
        }
    }

    //Transmission

    public void TransmissionOptions()
    {
        if(!Bird)
            System.out.println("1. Bird");
        if(!Rodent)
            System.out.println("2. Rodent");
        if(!Insect)
            System.out.println("3. Insect");
        if(!Livestock)
            System.out.println("4. Livestock");
        if(!ExtremeZoonosis)
            System.out.println("5. Extreme Zoonosis");
        if(!Blood)
            System.out.println("6. Blood");
        if(!ExtremeHem)
            System.out.println("7. Extreme Hematophagy");
        if(!Air)
            System.out.println("8. Air");
        if(!Water)
            System.out.println("9. Water");
        if(!ExtremeBio)
            System.out.println("10. Extreme Bioaerosol");

        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        if(s == 1 && !Bird)
        {
            infect+=2;
            Bird = true;
        }
        else if(s == 2 && !Rodent)
        {
            infect+=2;
            Rodent = true;
        }
        else if(s == 3 && !Insect)
        {
            infect+=3;
            Insect = true;
        }
        else if(s == 4 && !Livestock)
        {
            infect+=4;
            Livestock = true;
        }
        else if(s == 5 && !ExtremeZoonosis)
        {
            infect+=5;
            ExtremeZoonosis = true;
        }
        else if(s == 6 && !Blood)
        {
            infect+=2;
            Blood = true;
        }
        else if(s == 7 && !ExtremeHem)
        {
            infect+=4;
            ExtremeHem = true;
        }
        else if(s == 8 && !Air)
        {
            infect+=2;
            Air = true;
        }
        else if(s == 9 && !Water)
        {
            infect+=2;
            Water = true;
        }
        else if(s == 10 && !ExtremeBio)
        {
            infect+=5;
            ExtremeBio = true;
        }
        
        try
        {
            Thread.sleep(2000);
            printer();
        }
        catch(Exception e)
        {
            System.err.println("YOU NUB!!!");
        }
        Options();
    }

    //Abilities(Special too)
    public void AbilitiesOptions()
    {
        if(!Cold)
            System.out.println("A. Cold Resistance");
        if(!Heat)
            System.out.println("B. Heat Resistance");
        if(!Drug)
            System.out.println("C. Drug Resistance");
        if(Drug && !GeneticHardening)
            System.out.println("D. Genetic Hardening.");
        if(!ReplicationFactoryOverload)
            System.out.println("E. Replication Factory Overload");
        Scanner sc = new Scanner(System.in);
        String chdg = sc.nextLine();
        if(chdg.contains("a"))
        {
            infect+=2;
            Cold = true;
        }
        else if(chdg.contains("b"))
        {
            infect+=3;
            Heat = true;
        }
        else if(chdg.contains("c"))
        {
            infect+=3;
            Drug = true;
        }
        else if(chdg.contains("d"))
        {
            infect+=2;
            GeneticHardening = true;
        }
        else if(chdg.contains("e"))
        {
            infect+=10;
            ReplicationFactoryOverload = true;
        }
        else
        {
            AbilitiesOptions();
        }
        
        try
        {
            Thread.sleep(2000);
            printer();
        }
        catch(Exception e)
        {
            System.err.println("YOU NUB!!!");
        }
        Options();
    }

    //Options for the game
    public void Options()
    {
        System.out.println("A. Symptoms");
        System.out.println("B. Transmission");
        System.out.println("C. Abilities");
        Scanner sc = new Scanner(System.in);
        String op = sc.nextLine();
        op = op.toLowerCase();
        if(op.contains("a"))
        {
            randomness(5);
            SymptomsOptions();
        }
        else if(op.contains("b"))
        {
            randomness(5);
            TransmissionOptions();
        }
        else if(op.contains("c"))
        {
            randomness(5);
            AbilitiesOptions();
        }
        else if(op.equalsIgnoreCase("end"))
        {
            System.out.println("GAME TERMINATED");
        }
        else
        {
            System.out.println("I don't reckognize " + op + " try again...");
            Options();
        }
    }

    /**
     * Overwritten
     */
    public void Options(String o)
    {
        if(nub)
        System.out.println("Nano-Virus: " + name + " " + o + "ed the world! " + name + " is the best disease ever!");
    }
}
