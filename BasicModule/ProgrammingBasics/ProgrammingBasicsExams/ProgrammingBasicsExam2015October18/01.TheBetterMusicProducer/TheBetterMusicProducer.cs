using System;

class TheBetterMusicProducer
{
    static void Main(string[] args)
    {
        int albumsSoldInEurope = int.Parse(Console.ReadLine());
        decimal priceOfAlbumEUR = decimal.Parse(Console.ReadLine());
        int albumsSoldInNorthAmerica = int.Parse(Console.ReadLine());
        decimal priceOfAlbumUSD = decimal.Parse(Console.ReadLine());
        int albumsSoldInSouthAmerica = int.Parse(Console.ReadLine());
        decimal priceOfAlbumPesos = decimal.Parse(Console.ReadLine());
        int numberOfConcerts = int.Parse(Console.ReadLine());
        decimal profitFromOneConcert = decimal.Parse(Console.ReadLine());

        decimal profitFromAlbums = ((albumsSoldInEurope * priceOfAlbumEUR * 1.94m + albumsSoldInNorthAmerica * priceOfAlbumUSD * 1.72m + albumsSoldInSouthAmerica * priceOfAlbumPesos / 332.74m) * 0.65m) * 0.80m;

        decimal profitFromConcerts = profitFromOneConcert * numberOfConcerts * 1.94m;
        if (profitFromConcerts > 100000)
        {
            profitFromConcerts *= 0.85m;
        }

        if (profitFromAlbums > profitFromConcerts)
        {
            Console.WriteLine("Let's record some songs! They'll bring us {0:f2}lv.", profitFromAlbums);
        }
        else
        {
            Console.WriteLine("On the road again! We'll see the world and earn {0:f2}lv.", profitFromConcerts);
        }
    }
}