package ed.lab;

import java.util.HashMap;
import java.util.Map;

public class E02Logger {
    Map<String, Integer> map;
    public E02Logger() {
        map = new HashMap<>();

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        //Si ya existe el message
        if(map.containsKey(message)) {
            //Devolver si el tiempo que se ha dado - el tiempo inicial del mensaje es >=10
            return timestamp - map.get(message) >= 10;
        }
        //Si no, agregarlo al map
        map.put(message, timestamp);
        return true;
    }

}
