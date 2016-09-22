using System;

class Hospital
{
    static void Main(string[] args)
    {
        int days = int.Parse(Console.ReadLine());
        int doctors = 7;
        int treatedPatients = 0;
        int untreatedPatients = 0;
        int allTreated = 0;
        int allUntreated = 0;

        for (int i = 1; i <= days; i++)
        {
            if (i % 3 == 0)
            {
                if (allUntreated > allTreated)
                {
                    doctors++;
                }
            }
            int patients = int.Parse(Console.ReadLine());
            if (patients <= doctors)
            {
                treatedPatients = patients;
                untreatedPatients = 0;
            }
            else
            {
                treatedPatients = doctors;
                untreatedPatients = patients - doctors;
            }
            allTreated += treatedPatients;
            allUntreated += untreatedPatients;
        }

        Console.WriteLine("Treated patients: {0}.", allTreated);
        Console.WriteLine("Untreated patients: {0}.", allUntreated);
    }
}