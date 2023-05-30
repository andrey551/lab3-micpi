package com.example.web.MBeans;

import com.example.web.Point;

import javax.management.*;
import java.util.ArrayList;
import java.util.List;

public class Pointx extends NotificationBroadcasterSupport implements PointxMBean{

    private List<Point> pointList;
    private int sum;
    private int miss;
    private int hit;
    private int sequenceNumber;

    public Pointx() {
        pointList = new ArrayList<>();
        miss = 0;
        hit = 0;
        sum = 0;
        sequenceNumber = 0;
    }
    public void addPoint(Point res) {

//        pointArrayList.add(point);
        if(res.getResult().equals("Hit")) {
            ++hit;
        }
        else {
            if(pointList.size() >= 1 &&pointList.get(pointList.size() - 1).getResult().equals("Miss"))
                this.sendNotification(new Notification(
                        "Double miss",
                        this,
                        ++sequenceNumber,
                        System.currentTimeMillis(),
                        "Double miss"
                        ));
            ++miss;
        }
        pointList.add(res);
        ++sum;
    }

//    @Override
    public int countPoints() {
        return hit + miss;
    }

//    @Override
    public int countHit() {
        return hit;
    }

//    @Override
    public int countMiss() {
        return miss;
    }

    public int getHit() {
        return hit;
    }

    public int getMiss() {
        return miss;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    @Override
    public int getSum() {
        return this.sum;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public void setMiss(int miss) {
        this.miss = miss;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

}
