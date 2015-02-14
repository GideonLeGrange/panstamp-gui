package me.legrange.panstamp.gui.view;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.tree.TreePath;
import me.legrange.panstamp.Gateway;
import me.legrange.panstamp.GatewayException;
import me.legrange.panstamp.Register;
import me.legrange.panstamp.gui.model.EndpointNode;
import me.legrange.panstamp.gui.model.GatewayNode;
import me.legrange.panstamp.gui.model.NetworkTreeNode;
import me.legrange.panstamp.gui.model.PanStampNode;
import me.legrange.panstamp.gui.model.WorldNode;

/**
 *
 * @author gideon
 */
public class TreeMenus {

    public JPopupMenu getPopupMenu(TreePath path) {
        NetworkTreeNode node = (NetworkTreeNode) path.getLastPathComponent();
        switch (node.getType()) {
            case WORLD:
                return getWorldPopupMenu((WorldNode) node);
            case GATEWAY:
                return getGatewayPopupMenu((GatewayNode) node);
            case PANSTAMP:
                return getPanStampPopupMenu((PanStampNode) node);
            case ENDPOINT:
                return getEndpointPopupMenu((EndpointNode) node);
            default:
                return null;
        }
    }

    TreeMenus(View view) {
        this.view = view;

    }

    private JPopupMenu getWorldPopupMenu(final WorldNode wn) {
        JPopupMenu menu = popupMenus.get(wn);
        if (menu == null) {
            menu = new JPopupMenu(wn.toString());
            final JMenuItem addSerialItem = new JMenuItem("Add network...");
            addSerialItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    view.showNetworkAddDialog();
                }
            });
            menu.add(addSerialItem);
        }
        return menu;
    }

    private JPopupMenu getGatewayPopupMenu(final GatewayNode gn) {
        JPopupMenu menu = popupMenus.get(gn);
        if (menu == null) {

            menu = new JPopupMenu(gn.toString());

            final JMenuItem activateItem = new JMenuItem();
            activateItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Gateway gw = gn.getGateway();
                        if (gw.isOpen()) {
                            gw.close();
                        } else {
                            gw.open();
                        }
                        activateItem.setText(gw.isOpen() ? "Close" : "Open");
                    } catch (GatewayException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            activateItem.setText(gn.getGateway().isOpen() ? "Close" : "Open");
            menu.add(activateItem);
            popupMenus.put(gn, menu);
        }
        return menu;
    }

    private JPopupMenu getPanStampPopupMenu(final PanStampNode psn) {
        JPopupMenu menu = popupMenus.get(psn);
        if (menu == null) {

            menu = new JPopupMenu(psn.toString());
            menu.add(getPanstampSettingsItem(psn));
            menu.add(getPanstampParametersItem(psn));

            final JMenuItem graphItem = new JMenuItem("RSSI/LQI Graph...");
            graphItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    view.showSignalChart(psn.getPanStamp());
                }
            });
            menu.add(graphItem);
            // register selection
            menu.add(new JSeparator());
            final JMenu regsMenu = new JMenu("Show Standard Registers");
            final JRadioButtonMenuItem allItem = new JRadioButtonMenuItem("All");
            final JRadioButtonMenuItem intItem = new JRadioButtonMenuItem("Interesting");
            final JRadioButtonMenuItem noneItem = new JRadioButtonMenuItem("None", true);
            ActionListener regL = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    allItem.setSelected(false);
                    noneItem.setSelected(false);
                    intItem.setSelected(false);
                    if (e.getSource().equals(noneItem)) {
                        noneItem.setSelected(true);
                        psn.setRegisterDisplay(PanStampNode.RegisterDisplay.NONE);
                    }
                    if (e.getSource().equals(allItem)) {
                        allItem.setSelected(true);
                        psn.setRegisterDisplay(PanStampNode.RegisterDisplay.ALL);
                    }
                    if (e.getSource().equals(intItem)) {
                        intItem.setSelected(true);
                        psn.setRegisterDisplay(PanStampNode.RegisterDisplay.INTERESTING);
                    }
                }

            };
            allItem.addActionListener(regL);
            noneItem.addActionListener(regL);
            intItem.addActionListener(regL);

            regsMenu.add(allItem);
            regsMenu.add(intItem);
            regsMenu.add(noneItem);
            menu.add(regsMenu);
            popupMenus.put(psn, menu);
        }
        return menu;
    }

    /** build the settings item from the panStamp menu */
    private JMenuItem getPanstampSettingsItem(final PanStampNode psn) {
        final JMenuItem settingsItem = new JMenuItem("Settings...");
        settingsItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.showPanStampSettingsDialog(psn.getPanStamp());
            }
        });
        return settingsItem;
    }
    
    /** build the parameters item from the panStamp menu */
    private JMenuItem getPanstampParametersItem(final PanStampNode psn) {
            final JMenuItem paramItem = new JMenuItem("Parameters...");
            paramItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    view.showPanStampParamDialog(psn.getPanStamp());
                }
            });
            boolean hasParams = false;
            try {
                for (Register reg : psn.getPanStamp().getRegisters()) {
                    if (!reg.getParameters().isEmpty()) {
                        hasParams = true;
                        break;
                    }
                }
            } catch (GatewayException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
            paramItem.setEnabled(hasParams);
            return paramItem;
    }
    
    private JPopupMenu getEndpointPopupMenu(final EndpointNode epn) {
        JPopupMenu menu = popupMenus.get(epn);
        if (menu == null) {
            menu = new JPopupMenu(epn.toString());
            final JMenuItem graphItem = new JMenuItem("Data graph...");
            graphItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    view.showEndpointChart(epn.getEndpoint());
                }
            });
            menu.add(graphItem);
            popupMenus.put(epn, menu);
        }

        return menu;
    }

    private final View view;
    private final Map<NetworkTreeNode, JPopupMenu> popupMenus = new HashMap<>();



}
