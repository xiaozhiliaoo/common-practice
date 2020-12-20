package org.lili.google.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2020/8/18 0:20
 * @description Message driven - Guava (by Google)
 * @notes
 */
class EventListener {

    private static int eventsHandled;

    @Subscribe
    public void stringEvent(String event) {
        eventsHandled++;
    }

    public int getEventsHandled() {
        return eventsHandled;
    }
}


public class EventBusTest {

    @Test
    public void test() throws InterruptedException {
        EventBus eventBus = new EventBus();
        EventListener object = new EventListener();
        eventBus.register(object);
        for (int i = 0; i < 100; i++) {
            eventBus.post("String Event");
        }

        Thread alibaba = new Thread(() -> {
            eventBus.post("alibaba");
        });
        alibaba.start();

        Thread alibaba2 = new Thread(() -> {
            eventBus.post("alibaba2");
        });
        alibaba2.start();

        alibaba.join();
        alibaba2.join();

        System.out.println(object.getEventsHandled());
    }
}
