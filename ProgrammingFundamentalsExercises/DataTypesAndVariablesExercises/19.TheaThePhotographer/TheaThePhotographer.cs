using System;

class TheaThePhotographer
{
    static void Main(string[] args)
    {
        int takenPictures = int.Parse(Console.ReadLine());
        int filterTimeInSecondsPerPicture = int.Parse(Console.ReadLine());
        int percentageGoodPhotos = int.Parse(Console.ReadLine());
        int uploadingTimeInSecondsPerGoodPicture = int.Parse(Console.ReadLine());

        int goodPictures = (int)(Math.Ceiling(takenPictures * (percentageGoodPhotos / 100d)));
        long filterTime = (long)filterTimeInSecondsPerPicture * takenPictures;
        long uploadTime = (long)goodPictures * uploadingTimeInSecondsPerGoodPicture;
        long totalTimeInSeconds = filterTime + uploadTime;

        int days = (int)(totalTimeInSeconds / 86400);
        int hours = (int)(totalTimeInSeconds % 86400 / 3600);
        int minutes = (int)(totalTimeInSeconds % 86400 % 3600 / 60);
        int seconds = (int)(totalTimeInSeconds % 86400 % 3600 % 60);

        Console.WriteLine("{0}:{1}:{2}:{3}", days, hours.ToString().PadLeft(2, '0'), minutes.ToString().PadLeft(2, '0'), seconds.ToString().PadLeft(2, '0'));
    }
}