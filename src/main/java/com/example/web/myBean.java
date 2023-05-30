package com.example.web;

import com.example.web.MBeans.Area;
import com.example.web.MBeans.Pointx;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import javax.management.*;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
@Named
public class myBean implements Serializable {
    private static final float[] X_VALUES = {-3, -2, -1, 0, 1, 2, 3};
    private static final float Y_MIN = -3;
    private static final float Y_MAX = 5;
    private static final float[] R_VALUES = {1, 2, 3, 4, 5};
    private List<Point> storage = new ArrayList();
    private String x;
    private String y;
    private String r;
    Area area;
    Pointx points;
// comment 2
    private String message;

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getR() {
        return r;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public void setR(String r) {
        this.r = r;
    }

    public void execute() {
        if(!validateX(x) || !validateY(y) || !validateR(r)){
            Point crt = new Point(getX(), getY(), getR());
            System.out.println(getX() + getY() + getR());
            points.addPoint(crt);
            area.setCrtPoint(crt);
            area.setCrtArea(area.areaFigure());
            storage.add(crt);
            DatabaseHandle dbHandle = new DatabaseHandle();
            String message = dbHandle.insertPoint(crt);
            System.out.println(message);
        }
    }

    public boolean validateX(String xstr) {
        float x = Float.parseFloat(xstr);
        if(Float.isFinite(x)||
                Float.isNaN(x)||
                !Arrays.asList(X_VALUES).contains(x)) return false;
        return true;
    }

    public boolean validateY(String ystr) {
        float y = Float.parseFloat(ystr);
        if(Float.isFinite(y)||
                Float.isNaN(y)||
                y > Y_MAX||
                y < Y_MIN) {

            return false;
        }
        return true;
    }

    public boolean validateR(String rstr) {
        float r = Float.parseFloat(rstr);
        if(Float.isFinite(r)||
                Float.isNaN(r)||
                !Arrays.asList(R_VALUES).contains(r)) return false;
        return true;
    }

    public List<Point> getStorage() {
        return this.storage;
    }

    @PostConstruct
    public void  connectMBean() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanException, ReflectionException, AttributeNotFoundException, InstanceNotFoundException, InvalidAttributeValueException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName namePoints = new ObjectName("com.example.web.MBeans.Model:type=Pointx");
        ObjectName nameArea = new ObjectName("com.example.web.MBeans.Model:type=AreaMBean");
        area = new Area();
        points = new Pointx();
        // Register the MBean with the MBeanServer
        mbs.registerMBean(points, namePoints);
        mbs.registerMBean(area, nameArea);
    }
}