class Cp9_State_Alarm {
    protected void ring() {
    }
}

class Cp9_State_AlarmEmergency extends Cp9_State_Alarm {
    protected void ring() {
        System.out.println("Emergency");
    }
}

class Cp9_State_AlarmOff extends Cp9_State_Alarm {
    protected void ring() {
        System.out.println("AlarmOff");
    }
}

class Cp9_State_AlarmState {
    private Cp9_State_Alarm alarm00 = new Cp9_State_AlarmOff();

    public void alarmChangeState() {
        alarm00 = new Cp9_State_AlarmEmergency();
    }

    public void alarmRing() {
        alarm00.ring();
    }
}

public class Cp9_State {
    public static void main(String[] args) {
        Cp9_State_AlarmState alarmState = new Cp9_State_AlarmState();
        alarmState.alarmRing();
        alarmState.alarmChangeState();
        alarmState.alarmRing();
    }
}
