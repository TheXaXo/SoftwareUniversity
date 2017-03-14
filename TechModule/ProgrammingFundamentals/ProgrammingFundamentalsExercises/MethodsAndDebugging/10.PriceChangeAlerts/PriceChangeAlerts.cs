using System;

class PriceChangeAlert
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        double percentTreshold = double.Parse(Console.ReadLine());
        double lastPrice = 0;

        for (int i = 1; i <= n; i++)
        {
            double currentPrice = double.Parse(Console.ReadLine());
            if (i == 1)
            {
                lastPrice = currentPrice;
                continue;
            }
            double percentDifference = tresholdDifference(lastPrice, currentPrice);
            bool isSignificantDifference = IsThereSignificantDifference(percentDifference, percentTreshold);
            string message = GetMessage(currentPrice, lastPrice, percentDifference, isSignificantDifference);
            Console.WriteLine(message);

            lastPrice = currentPrice;
        }
    }

    static string GetMessage(double currentPrice, double lastPrice, double difference, bool isSignificantDifference)
    {
        string result = null;
        if (difference == 0)
        {
            result = string.Format("NO CHANGE: {0}", currentPrice);
        }
        else if (!isSignificantDifference)
        {
            result = string.Format("MINOR CHANGE: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference * 100);
        }
        else if (isSignificantDifference && (difference > 0))
        {
            result = string.Format("PRICE UP: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference * 100);
        }
        else if (isSignificantDifference && (difference < 0))
            result = string.Format("PRICE DOWN: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference * 100);
        return result;
    }

    static bool IsThereSignificantDifference(double percentDifference, double percentTreshold)
    {
        if (Math.Abs(percentDifference) >= percentTreshold)
        {
            return true;
        }
        return false;
    }

    static double tresholdDifference(double last, double current)
    {
        double percent = (current - last) / last;
        return percent;
    }
}
