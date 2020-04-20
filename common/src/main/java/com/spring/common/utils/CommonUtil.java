package com.spring.common.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;

public class CommonUtil {

    public static Map<String, Object> xmlStringToMap(String xml) {
        Map<String, Object> map = new HashMap<>();
        try {
            Document document = DocumentHelper.parseText(xml);
            Element element = document.getRootElement();
            List nodes = element.elements();
            for (Iterator its = nodes.iterator(); its.hasNext(); ) {
                Element node = (Element) its.next();
                if (node.isTextOnly()) {
                    map.put(node.getName(), node.getText());
                } else {
                    List list = xmlToList(node.asXML());
                    map.put(node.getName(), list);
                }
            }
            return map;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    private static List xmlToList(String xml) {
        try {
            List<Map<String, Object>> list = new ArrayList<>();
            Document document = DocumentHelper.parseText(xml);
            Element element = document.getRootElement();
            List nodes = element.elements();
            for (Iterator its = nodes.iterator(); its.hasNext(); ) {
                Element node = (Element) its.next();
                Map<String, Object> map = xmlToMap(node.asXML());
                list.add(map);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList();
    }

    private static Map<String, Object> xmlToMap(String xml) {
        try {
            Map<String, Object> map = new HashMap<>();
            Document document = DocumentHelper.parseText(xml);
            Element element = document.getRootElement();
            List nodes = element.elements();
            for (Iterator its = nodes.iterator(); its.hasNext(); ) {
                Element node = (Element) its.next();
                map.put(node.getName(), node.getText());
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashMap();
    }

}
