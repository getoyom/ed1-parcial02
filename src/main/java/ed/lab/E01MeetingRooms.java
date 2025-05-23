package ed.lab;

import java.util.List;
import java.util.PriorityQueue;

public class E01MeetingRooms {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        //Ordenar de menor a mayor tiempo de inicio
        meetingIntervals.sort((a, b) -> a.startTime() - b.startTime());
        //Evaluar cada dato
        for (MeetingInterval interval : meetingIntervals) {
            //Si la pq no está vacía y el peek de la pq es <= que el tiempo de inicio del intevalo, sacarlo
            if (!pq.isEmpty() && pq.peek() <= interval.startTime()) {
                pq.poll();
            }
            //Si no se cumple, guardar el tiempo final de ese intevalo.
            pq.offer(interval.endTime());
        }
        return pq.size();
    }

}
