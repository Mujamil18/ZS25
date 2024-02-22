package special.programs;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class RelativeTime {

    public static void main(String[] args) {
        // Create a Date object for the current time
        Date now = new Date();

        // Create a Date object for the time 10 minutes ago
        Date tenMinutesAgo = new Date(now.getTime() - (10 * 60 * 1000));

//        Date tenMinutesAgo = new Date(now.getTime());
        // Calculate the relative time between the two dates
        long relativeTime = now.getTime() - tenMinutesAgo.getTime();

        System.out.println(tenMinutesAgo);
        System.out.println(relativeTime);
        // Convert the relative time to a human-readable format
        String relativeTimeString = getRelativeTimeSpanString(relativeTime);

        // Print the relative time string to the console
        System.out.println(relativeTimeString);
    }

    private static String getRelativeTimeSpanString(long relativeTime) {
        // Calculate the number of seconds, minutes, hours, and days in the relative time
        int seconds = (int) (relativeTime / 1000);
        int minutes = seconds / 60;
        int hours = minutes / 60;
        int days = hours / 24;

        // Create a string to store the relative time string
        String relativeTimeString = "";

        // If the relative time is less than a minute, return "a few seconds ago"
        if (seconds < 60) {
            relativeTimeString = "a few seconds ago";
        }

        // If the relative time is less than an hour, return the number of minutes ago
        else if (minutes < 60) {
            relativeTimeString = minutes + " minutes ago";
        }

        // If the relative time is less than a day, return the number of hours ago
        else if (hours < 24) {
            relativeTimeString = hours + " hours ago";
        }

        // Otherwise, return the number of days ago
        else {
            relativeTimeString = days + " days ago";
        }

        // Return the relative time string
        return relativeTimeString;
    }
}