package com.example.web.MBeans;

import com.example.web.MBeans.AreaMBean;
import com.example.web.Point;

@javax.management.MXBean
public class Area implements AreaMBean {
    Point crtPoint;
    double crtArea;

    public void setCrtPoint(Point crtPoint) {
        this.crtPoint = crtPoint;
        this.crtArea = areaFigure();
    }

    @Override
    public double areaFigure() {
        return Math.pow(
                Double.parseDouble(
                        this.crtPoint.getR()),2)*
                (1 + 0.25 + 0.25*3.14);
    }


    public Point getCrtPoint() {
        return crtPoint;
    }

    public void setCrtArea(double crtArea) {
        this.crtArea = crtArea;
    }

    public double getCrtArea() {
        return crtArea;
    }
}
