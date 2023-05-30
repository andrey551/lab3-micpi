//package com.example.web;
//
//import com.example.web.MBeans.Area;
//import com.example.web.MBeans.Pointx;
//
//import javax.management.*;
//import java.lang.management.ManagementFactory;
//import java.util.Scanner;
//
//public class index {
//    public static void main (String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
//        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//        ObjectName namePoints = new ObjectName("com.example.web.MBeans.Model:type=PointxMBean");
//        ObjectName nameArea = new ObjectName("com.example.web.MBeans.Model:type=AreaMBean");
//        Area area = new Area();
//        Pointx points = new Pointx();
//        // Register the MBean with the MBeanServer
//        mbs.registerMBean(points, namePoints);
//        mbs.registerMBean(area, nameArea);
//
//
//        Scanner scanner = new Scanner(System.in);
//        String command;
//        String[] arg;
//
//        double crtArea= 0.0;
//
//        while(true) {
//            command = scanner.nextLine();
//            arg = command.split(" ");
//            if(arg[0].compareTo("point") == 0) {
//                Point crt = new Point(arg[1], arg[2], arg[3]);
//                points.addPoint(crt);
//                area.setCrtPoint(crt);
//                crtArea = area.areaFigure();
//                System.out.println(crt.getResult());
//            } else break;
//        }
//    }
//}
