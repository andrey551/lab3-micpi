package com.example.web.MBeans;

import com.example.web.Point;

import javax.management.ListenerNotFoundException;
import javax.management.NotificationEmitter;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import java.util.List;

public interface PointxMBean extends NotificationEmitter {
    public int countPoints();
    public int countHit();
    public int countMiss();

    public int getHit();

    public int getMiss();

    public int getSequenceNumber();
    public int getSum();
}
