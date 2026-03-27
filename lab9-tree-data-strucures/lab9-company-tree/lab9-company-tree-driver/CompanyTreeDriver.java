package com.mycompany.companytree;

public class CompanyTreeDriver {
    public static void main(String[] args) {

        // root
        GeneralTreeNode root = new GeneralTreeNode("CEO");

        // level 1
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering");

        root.addChild(vpSales);
        root.addChild(vpEngineering);

        // sales branch
        GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);

        // engineering branch
        GeneralTreeNode devLead = new GeneralTreeNode("Dev Team Lead");
        GeneralTreeNode qaLead = new GeneralTreeNode("QA Team Lead");
        vpEngineering.addChild(devLead);
        vpEngineering.addChild(qaLead);

        // developers
        GeneralTreeNode dev1 = new GeneralTreeNode("Developer 1");
        GeneralTreeNode dev2 = new GeneralTreeNode("Developer 2");
        devLead.addChild(dev1);
        devLead.addChild(dev2);

        // traversals
        System.out.println("--- Preorder ---");
        root.traversePreorder();

        System.out.println("\n--- Postorder ---");
        root.traversePostorder();
    }
}