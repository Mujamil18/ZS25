package com.zs25.programs;


class ZoomMeeting {
    private static int participantsCount = 0;
    private static final int MAX_PARTICIPANTS = 10;
    private static ZoomParticipant[] participants = new ZoomParticipant[MAX_PARTICIPANTS];

    public static void addParticipant(String displayName, boolean audioStatus, boolean videoStatus) {
        if (participantsCount < MAX_PARTICIPANTS) {
            participants[participantsCount] = new ZoomParticipant(displayName, audioStatus, videoStatus);
            participantsCount++;
        } else {
            System.out.println("Meeting is full. Cannot add more participants.");
        }
    }
    public static int getParticipantsCount() {
        return participantsCount;
    }

    public static ZoomParticipant getParticipant(int index) {
        if (index >= 0 && index < participantsCount) {
            return participants[index];
        }
        return null;
    }
}

class ZoomUtils {
    public static void displayMeetingParticipants(ZoomMeeting meeting) {
        System.out.println("Total participants: " + meeting.getParticipantsCount());
        for (int i = 0; i < meeting.getParticipantsCount(); i++) {
            ZoomParticipant participant = meeting.getParticipant(i);
            System.out.println("Participant: " + participant.getDisplayName() + ", Audio: " + participant.getAudioStatus() + ", Video: " + participant.getVideoStatus());
        }
    }
}
class ZoomParticipant {
    private String displayName;
    private boolean audioStatus;
    private boolean videoStatus;
    public ZoomParticipant(String displayName, boolean audioStatus, boolean videoStatus) {
        this.displayName = displayName;
        this.audioStatus = audioStatus;
        this.videoStatus = videoStatus;
    }
    public String getDisplayName() {
        return displayName;
    }
    public boolean getAudioStatus() {
        return audioStatus;
    }
    public boolean getVideoStatus() {
        return videoStatus;
    }
}

public class Main {
    public static void main(String[] args) {
        ZoomMeeting meeting = new ZoomMeeting();
        meeting.addParticipant("Alice", true, true);
        meeting.addParticipant("Bob", false, true);
        ZoomUtils.displayMeetingParticipants(meeting);
    }
}
